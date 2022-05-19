import character.player.Player;
import character.player.Warrior;
import character.player.Wizard;
import events.Event;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


public class Game {

    private int playerPosition=0;
    private Board board;
    private Player player;
    private int roll;

    /**
     * start a new Game:
     * 1 - Create a new player with method netNewPlayer
     * 2 - Generate a new Board with random events
     * 3 - First diceroll
     */
    public Board start () {
        // 1 - Création du personnage
        getHeroes();
        this.player = setNewPlayer();
        // 2 - Mise en place du donjon:
        this.board = new Board();
        launchGame(board);
        return this.board;
    }

    /**
     * Diplay all Players saved in table Hero
     * @return
     */
    public Player getHeroes(){
        Connection con = DBConnect.getConnection();
        String query = "select Hero .id, Hero.name, PlayersType.name as type, Hero.image, Hero.lifepoints, Hero.attack, Hero.maxLifePoints, Hero.maxAttack, Hero.offensiveGear, Hero.defensiveGear from Hero\n" +
                "join PlayersType where PlayersType.id = Hero.playersType_id";
        ResultSet result=null;
        Player newPlayer = null;
        try{
            Statement stmt = con.createStatement();
            result = stmt.executeQuery(query);
            System.out.println("Enter player's id number to select your player: ");
            while(result.next()){
                String l = System.getProperty("line.separator");
                System.out.println(
                        "--------------- player " +result.getInt("id")+": -----------------------" + l +
                        "Name : " + result.getString("name")+ l +
                        "Class : " + result.getString("type")+ l +
                        "Gear : offensive: "+result.getString("offensiveGear")+ ", defensive : "+result.getString("defensiveGear")+ l +
                        "LifePoints : " + result.getInt("lifepoints")+ l +
                        "Attack power : " + result.getInt("attack")+ l +
                        "--------------------------------------------------"
                );
            };
        }catch(Exception e){
            System.out.println("A problem occurred in the search for players list: "+ e);
        }
        selectPlayer();
        return newPlayer;
    }

    /**
     * Player selects a character from DB
     * returns an instance of the selected player
     */
    public void selectPlayer(){
        try{
            // demander l'id du perso
            Scanner playerIdScan = new Scanner(System.in);
            String selectedPlayerId = playerIdScan.next();
            // Connexion à la bdd
            Connection con = DBConnect.getConnection();
            // Requête préparée
            String query = "select Hero.id, Hero.name, PlayersType.name as type, Hero.image, Hero.lifepoints, Hero.attack, Hero.maxLifePoints, Hero.maxAttack, Hero.offensiveGear, Hero.defensiveGear from Hero \n" +
                    "join PlayersType where PlayersType.id = Hero.playersType_id and Hero.id = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            // Insérer la valeur dans la query
            stmt.setString(1, selectedPlayerId);
            // Exécuter la query
            ResultSet result=null;
            result = stmt.executeQuery();
            // Afficher le perso sélectionné
            if(result.next()){
                String l = System.getProperty("line.separator");
                System.out.println(
                        "--------------- selected player: -----------------------" + l +
                                "Name : " + result.getString("name")+ l +
                                "Class : " + result.getString("type")+ l +
                                "Gear : offensive: "+result.getString("offensiveGear")+ ", defensive : "+result.getString("defensiveGear")+ l +
                                "LifePoints : " + result.getInt("lifepoints")+ l +
                                "Attack power : " + result.getInt("attack")+ l +
                                "--------------------------------------------------"
                );
            };
        }catch (Exception e){
            System.out.println("A problem occurred when selecting the character: "+ e);
        }

    }

    /**
     * Ask for user input and create a new player
     * @return player = new instance of Warrior or Wizard
     */
    private  Player setNewPlayer() {

        Player player=null;

        Scanner nameScan = new Scanner(System.in);
        System.out.println("Welcome in the dungeon. What is your name? ");
        String playersName = nameScan.next();

        Scanner classScan = new Scanner(System.in);
        System.out.println("Welcome " + playersName + ". Are you a Warrior or a Wizard?");
        String playersClass = classScan.next();

        if (playersClass.equals("Warrior")) {
            player = new Warrior(playersName);
        } else if (playersClass.equals("Wizard")) {
            player = new Wizard(playersName);
        }else{
            System.out.println("You can only choose between these types: Warrior or Wizard");
            setNewPlayer();
        }
        System.out.println(player);
        return player;
    }

    /**
     * Launch the game, calls diceRoll(), movePlayer() and cell's launchEvent() methods, sets conditions to stop the game.
     */
    public void launchGame(Board board) {
    // 3 - Début de partie:
        String l = System.getProperty("line.separator");
        System.out.println("********** NEW GAME WITH PLAYER: "+player.getName()+" **********"+l+" Let's go, " +player.getName()+ "! Roll your dice...");
    // L'exception est throw en aval, catch en amont (où est appelée la méthode)
            while((this.playerPosition < board.getBoardLength())&&(this.player.getLifePoints()>0)) {

                // 1 - Diceroll
                 diceRoll();

                // 2 - Bouger en fonction du jet
                try {
                    Cell currentCell = movePlayer(this.roll);

                    // 3 - Interface.Event de la cellule
                    Event cellEvent = currentCell.getCellEvent();
                    cellEvent.happen(this.player);

                }catch (Exception e) {
                    System.out.println("Exception : player runs - "+ e);
                }
            }


        stop(player);
    }

    /**
     * Throw dice
     * @return random int between 1 & 6
     */
    public int diceRoll(){
        this.roll = (int) ((Math.random()*(6-1))+1);
       System.out.println("Your roll : " + roll);
       return roll;
    }

    /**
     * Changes player's current position, depending on player's diceroll. Set a limit at 64
     * @param roll
     * @return currentCell : player's new position
     */
    public Cell movePlayer(int roll){
        Cell currentCell;
            this.playerPosition += roll;

            if(this.playerPosition<board.getBoardLength()-1){
                currentCell = board.getCell(this.playerPosition);
                System.out.println(" -----  You arrived in the " + playerPosition + "th chamber  -----");

            }else{
                System.out.println(" -----  You arrived in the last chamber  -----");
                currentCell = board.getCell(board.getBoardLength()-1);
            }
        return currentCell;
    }

    /**
     * Stop the game, displays end message
     * @param player
     */
    public void stop(Player player){
        String l = System.getProperty("line.separator");
        System.out.println(setMessage(player) +l+
            "Type 1 to quit"+l+
            "Type 2 to start over");
        Scanner scan = new Scanner(System.in);
        String playersChoice = scan.next();
        if(playersChoice.equals("1")){
            System.out.println("Goodbye.");
        }else{
            playerPosition = 0;
            launchGame(board);
        }
    }

    /**
     * Set the end message, depending on how the game ended
     * @param player
     * @return message
     */
    public String setMessage(Player player){
        if(playerPosition>=board.getBoardLength()){
           return  "Congratulations "+player.getName()+", You have survived the dungeon!";
        } else if (player.getLifePoints()<=0) {
            return "You are dead.";
        }
        return "A problem occured";
    }
}

