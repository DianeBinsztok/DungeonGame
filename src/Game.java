import character.player.*;
import gear.Gear;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;


public class Game {

    private int playerPosition = 0;
    private Board board;
    private Player player;

    /**
     * start a new Game:
     * 1 - Create a new player with method netNewPlayer
     * 2 - Generate a new Board with random events
     * 3 - First diceroll
     */
    public void start () {
        // 1 - Création du personnage
        System.out.println(" 1 - Création du personnage");
        this.player = setNewPlayer();
        // 2 - Mise en place du donjon:
        System.out.println("2 - Mise en place du donjon");
        this.board = new Board();
        // 3 - Diceroll
        System.out.println("3 - Premier lancer de dés:");
        int roll = diceRoll();
        // 4 - Bouger en fonction du jet
        Cell currentCell = movePlayer(roll);
        // 5 - Event de la cellule
        Event event = currentCell.getEvent();
        event.launchEvent();
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
     * Throw dice
     * @return random int between 1 & 6
     */
    public int diceRoll(){

       int roll = (int) ((Math.random()*(6-1))+1);
       System.out.println("Your first roll : " + roll);
        return roll;
    }

    public Cell movePlayer(int roll){
        playerPosition += roll;
        Cell currentCell = board.getCell(playerPosition);
        return currentCell;
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

