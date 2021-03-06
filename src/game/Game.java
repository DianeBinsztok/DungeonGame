package game;

import character.player.Player;
import character.player.Warrior;
import character.player.Wizard;
import events.Event;
import exceptions.PlayerRunsException;
import gear.defensiveGear.DefensiveGear;
import gear.offensiveGear.OffensiveGear;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.Scanner;

import static java.lang.Class.forName;


public class Game {
    private Board board;
    private Cell currentCell;
    private int playerPosition=0;
    private Player player;

    private boolean forward = true;

    public Cell getCurrentCell(){
        return this.currentCell;
    }
    public Board getBoard(){ return this.board;}
    /**
     * start a new game.Game:
     * 1 - Create a new player with method netNewPlayer
     * 2 - Generate a new game.Board with random events
     *
     */
    public void start () {
        // 1 - Création du personnage
        setPlayer();
        // 2 - Mise en place du donjon:
        this.board = new Board();
    }

    public void menu(){
        String l = System.getProperty("line.separator");
        System.out.println(
                "[1] -> quit the game" +l+
                "[2] -> inventory"+l+
                "[3] -> back to game");
        Scanner scan = new Scanner(System.in);
        String playersChoice = scan.next();
        switch(playersChoice){
            case "1":
                this.stop();
                break;
            case "2":
                System.out.println(this.player.getInventory());
                break;
            case "3":
                break;
            default:
                System.out.println("You can only type 1, 2 or 3");
                break;
        }
    }

    public Player getPlayer(){
        return this.player;
    }
    public void setPlayer(){
        Scanner nameScan = new Scanner(System.in);
        String l = System.getProperty("line.separator");
        System.out.println(
                "Welcome in the dungeon. Who are you? "+l+
                "[1] -> create a new character"+l+
                "[2] -> pick a character from saved players"
                );
        String choice = nameScan.next();
        if(choice.equals("1")){
            setNewPlayer();
        }else if(choice.equals("2")){
            this.player = getHeroes();
        }else{
            System.out.println("Your answer can only be 1 or 2 !");
        }

    }

    /**
     * Ask for user input and create a new player
     * @return player = new instance of Warrior or Wizard
     */
    private void setNewPlayer() {
        Scanner nameScan = new Scanner(System.in);
        System.out.println("Welcome stranger. What is your name? ");
        String playersName = nameScan.next();

        Scanner classScan = new Scanner(System.in);
        System.out.println("Welcome " + playersName + ". Are you a Warrior or a Wizard?");
        String playersClass = classScan.next();

        if (playersClass.equals("Warrior")) {
            this.player = new Warrior(playersName);
        } else if (playersClass.equals("Wizard")) {
            this.player = new Wizard(playersName);
        }else{
            System.out.println("You can only choose between these types: Warrior or Wizard");
            setNewPlayer();
        }
        System.out.println(this.player);
        //savePlayer(player);

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
                        "--------------- player " +result.getInt("id")+": -------------------" + l +
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
        newPlayer = selectPlayer();
        return newPlayer;
    }

    /**
     * Player selects a character from DB
     * returns an instance of the selected player
     */
    public Player selectPlayer(){
        Player newPlayer = null;
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
                        "--------------- selected player: " + result.getString("name")+ "----------------" + l +
                                "Class : " + result.getString("type")+ l +
                                "Gear : offensive: "+result.getString("offensiveGear")+ ", defensive : "+result.getString("defensiveGear")+ l +
                                "LifePoints : " + result.getInt("lifepoints")+ l +
                                "maxLifePoints : " + result.getInt("maxLifePoints")+ l +
                                "Attack power : " + result.getInt("attack")+ l +
                                "Max attack power : " + result.getInt("maxAttack")+ l +
                                "--------------------------------------------------"
                );
                // Vérifier en amont si le perso a du matériel puis, le passer en arg ds le contructeur du perso
                // ou initialiser à null et ajouter le gear avec les setters
                // Vérifier le type du perso pour instancier la bonne classe
                Class selectedPlayersClass = forName( "character.player."+result.getString("type"));
                // Aller chercher le contructeur de la classe correspondante
                Constructor cons= selectedPlayersClass.getConstructor(String.class, String.class, String.class, int.class, int.class, int.class, int.class, OffensiveGear.class, DefensiveGear.class);
                // NewPlayer Appelle le contructeur pour instancier la classe
                newPlayer = (Player) cons.newInstance(result.getString("name"), result.getString("type"), result.getString("image"), result.getInt("lifepoints"), result.getInt("maxLifePoints"), result.getInt("attack"), result.getInt("maxAttack"), checkIfOffensiveGear(result.getString("offensiveGear")), checkIfDefensiveGear(result.getString("defensiveGear")));
                System.out.println("Welcome back, " + newPlayer.getName()+". Let's play!" );

            };
        }catch (InstantiationException e){
            System.out.println("InstantiationException: "+ e);
        } catch (SQLException e) {
            System.out.println("SQLException: "+ e);
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException: "+ e);
        } catch (InvocationTargetException e) {
            System.out.println("InvocationTargetException: "+ e);
        } catch (NoSuchMethodException e) {
            System.out.println("NoSuchMethodException: "+ e);
        } catch (IllegalAccessException e) {
            System.out.println("IllegalAccessException: "+ e);
        }
        return newPlayer;
    }

    /**
     * Check if selected player has offensive gear and create instance of the matching class of offensivegear
     * @param gearname
     * @return
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public OffensiveGear checkIfOffensiveGear(String gearname) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        OffensiveGear playersGear = null;
        if (gearname!=null) {
            Class selectedGearsClass = forName("gear.offensiveGear." + gearname);
            // Aller chercher le contructeur de la classe correspondante
            Constructor cons = selectedGearsClass.getConstructor();
            playersGear = (OffensiveGear) cons.newInstance();
        }
        return playersGear;
    }

    /**
     * Check if selected player has defensive gear and create instance of the matching class of defensivegear
     * @param gearname
     * @return
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public DefensiveGear checkIfDefensiveGear(String gearname) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        DefensiveGear playersGear = null;
        if (gearname!=null){
            Class selectedGearsClass = forName("gear.defensiveGear."+gearname);
            // Aller chercher le contructeur de la classe correspondante
            Constructor cons= selectedGearsClass.getConstructor();
            playersGear = (DefensiveGear) cons.newInstance();
        }
        return playersGear;
    }

    /**
     * Save player in database
     */
    public void savePlayer(){
        try{
            Connection con = DBConnect.getConnection();
            String query = "insert into Hero (name, image, lifepoints, attack, maxLifePoints, maxAttack, offensiveGear, defensiveGear, playersType_id) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(query);
            // Insérer la valeur dans la query
            stmt.setString(1, this.player.getName());
            stmt.setString(2, this.player.getImage());
            stmt.setInt(3, this.player.getLifePoints());
            stmt.setInt(4, this.player.getAttack());
            stmt.setInt(5, this.player.getMaxLifePoints());
            stmt.setInt(6, this.player.getMaxAttack());
            stmt.setObject(7, this.player.getOffensiveGear().getName());
            stmt.setObject(8, this.player.getDefensiveGear().getName());

            if(this.player.getType().equals("Warrior")){
                stmt.setInt(9, 1);
            } else if (this.player.getType().equals("Wizard")) {
                stmt.setInt(9, 2);
            }else{
                System.out.println("A problem occurred with your character's class");
            }


            // Exécuter la query
            int result=0;
            result = stmt.executeUpdate();
            if(result != 0){
                System.out.println("Your "+player.getType()+" "+player.getName()+" has been successfully saved. ");
            }
        }catch(Exception e){
            System.out.println("A problem occurred : your player could not be saved - "+ e);
        }
    }

    /**
     * Launch the game, calls diceRoll(), movePlayer() and cell's launchEvent() methods, sets conditions to stop the game.
     */
    public void launchGame(){
    // 3 - Début de partie:
        String l = System.getProperty("line.separator");
        System.out.println("********** NEW GAME WITH PLAYER: "+player.getName()+" **********"+l+" Let's go, " +player.getName()+ "! Roll your dice...");
    // L'exception est throw en aval, catch en amont (où est appelée la méthode)
            while((this.playerPosition < this.board.getBoardLength())&&(this.player.getLifePoints()>0)) {
                int roll = this.forward ? diceRoll() : -diceRoll();
                try {
                   movePlayer(roll);
                    // 3 - Interface.Event de la cellule
                    Event cellEvent = currentCell.getCellEvent();
                    cellEvent.happen(this.player);
                    this.forward = true;
                }catch (PlayerRunsException e) {
                    System.out.println("Player runs: your next dice roll will send you backward! " + e);
                    this.forward = false;
                }catch (Exception e){
                    System.out.println("A problem occurred -> " + e);
                }
            }
        stop();
    }

    /**
     * Throw dice
     * @return random int between 1 & 6
     */
    public int diceRoll(){
       int roll = (int) ((Math.random()*(6-1))+1);
       System.out.println("Your roll : " + roll);
       return roll;
    }

    /**
     * Changes player's current position, depending on player's diceroll. Set a limit at 64
     * @param roll
     * @return currentCell : player's new position
     */
    public void movePlayer(int roll){
        this.playerPosition += roll;

        if(this.playerPosition<board.getBoardLength()-1){
            this.currentCell = board.getCell(this.playerPosition);
            System.out.println(" -----  You arrived in the " + playerPosition + "th chamber  -----");

        }else{
            this.playerPosition=(board.getBoardLength());
            System.out.println(" --------  You arrived in the last chamber  --------");
            this.currentCell = board.getCell(board.getBoardLength()-1);
        }
    }

    /**
     * Stop the game, displays end message
     */
    public void stop(){
        String l = System.getProperty("line.separator");
        System.out.println(setMessage() +l+
            "[1] -> quit"+l+
            "[2] -> save my player and quit"+l+
            "[3] -> start over");
        Scanner scan = new Scanner(System.in);
        String playersChoice = scan.next();
        if(playersChoice.equals("1")){
            System.out.println("Goodbye.");
        }else if(playersChoice.equals("2")){
            savePlayer();
        }else{
            this.playerPosition = 0;
            this.player.setLifePoints(5);
            //start();
            launchGame();
        }
    }

    /**
     * Set the end message, depending on how the game ended
     * @return message
     */
    public String setMessage(){
        if(playerPosition>=board.getBoardLength()){
           return  "Congratulations "+this.player.getName()+", You have survived the dungeon!";
        } else if (this.player.getLifePoints()<=0) {
            return "You are dead.";
        }
        return "A problem occurred";
    }
}

