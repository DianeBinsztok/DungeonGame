import character.player.*;
import java.util.Scanner;


public class Game {

    private int playerPosition = 0;
    private Board board;
    private Player player;
    private String message;

    /**
     * start a new Game:
     * 1 - Create a new player with method netNewPlayer
     * 2 - Generate a new Board with random events
     * 3 - First diceroll
     */
    public void start () {
        // 1 - Création du personnage
        this.player = setNewPlayer();
        // 2 - Mise en place du donjon:
        this.board = new Board();
        // 3 - Début de partie:
        System.out.println("Let's go, " +player.getName()+ "! Roll your dice...");
        launchGame(board);
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
            System.out.println("You can only choose between these types; Warrior or Wizard");
            setNewPlayer();
        }
        System.out.println(player);
        return player;
    }

    /**
     * Launch the game, calls diceRoll(), movePlayer() and cell's launchEvent() methods, sets conditions to stop the game.
     */
    private void launchGame(Board board){
        while((this.playerPosition<board.getBoardLength())&&(this.player.getLifePoints()>0)){
            // 1 - Diceroll
            int roll = diceRoll();

            // 2 - Bouger en fonction du jet
            Cell currentCell = movePlayer(roll);
            System.out.println(" -----  You arrived in the "+ this.playerPosition + "th chamber  -----");

            // 3 - Event de la cellule
            currentCell.launchEvent(player);
        }
        stop(setMessage(player));
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
    public Cell movePlayer(int roll){
        int newPosition = this.playerPosition += roll;
        Cell currentCell;
        if(newPosition<board.getBoardLength()){
             currentCell = board.getCell(this.playerPosition);
        }else{
             currentCell = board.getCell(board.getBoardLength()-1);
        }
        return currentCell;

    }

    /**
     * Stop the game, displays end message
     * @param message
     */
    public void stop(String message){
        String l = System.getProperty("line.separator");
        System.out.println(message +l+
            "Type 1 to quit"+l+
            "Type 2 to start over");
    }

    /**
     * Set a goodby message
     * @param player
     * @return message
     */
    public String setMessage(Player player){
        String message="";
        if(playerPosition>=64){
            message = ("Congratulations, "+player.getName()+", You have survived the dungeon!");
        } else if (player.getLifePoints()<=0) {
            message =  ("You are dead.");
        }
        return message;
    }

    // Test du diceroll
        /*
        Game g = new Game();
        for (int i = 0; i < 1000; i++) {
            int test = g.diceRoll();
            if ((test < 1) || (test > 6)) {
                System.out.println("Problem with the diceroll");
            }
        }
       */
}

