import character.player.*;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {

        // 0 - test du diceroll
        /*
        Game g = new Game();
        for (int i = 0; i < 1000; i++) {
            int test = g.diceRoll();
            if ((test < 1) || (test > 6)) {
                System.out.println("Problem with the diceroll");
            }
        }
       */
        Menu newGame = new Menu();
        newGame.start();

    }


    private  void start () {
        // 1 - Création du personnage
        System.out.println(" 1 - Création du personnage");
        setNewPlayer();
        // 2 - Mise en place du donjon:
        System.out.println("2 - Mise en place du donjon");
        Board b = new Board();
        b.setBoard();
        // 3 - Diceroll
    }


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
            //setNewPlayer();
        }
        System.out.println("New Player: "+player);
        return player;
    }
}