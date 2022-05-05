import character.player.*;
import gear.Gear;
import java.util.Scanner;


public class Game {

    /**
     * start a new Game:
     * 1 - Create a new player with method netNewPlayer
     * 2 - Generate a new Board with random events
     * 3 - First diceroll
     */
    public void start () {
        // 1 - Création du personnage
        System.out.println(" 1 - Création du personnage");
        setNewPlayer();
        // 2 - Mise en place du donjon:
        System.out.println("2 - Mise en place du donjon");
        Board b = new Board();
        b.setBoard();
        // 3 - Diceroll
        System.out.println("3 - Premier lancer de dés:");
        diceRoll();
    }

    /**
     * Ask for user input and create a new player
     * @return player = new instance of Warrior or Wizard
     */
    private  Object setNewPlayer() {

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
        System.out.println(player.toString());
        return player;
    }


    /**
     * Throw dice
     * @return random int between 1 & 6
     */
    public int diceRoll(){
       int roll = (int) ((Math.random()*(6-1))+1);
       System.out.println("Your first roll : " + roll);
        return (int) ((Math.random()*(6-1))+1);
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

