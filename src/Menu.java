import game.Game;
import gear.Inventory;
import gear.defensiveGear.Shield;
import gear.offensiveGear.Sword;
import gear.potions.BigPotion;
import gear.potions.Potion;
import gear.potions.StandardPotion;

public class Menu {

    /**
     * Creates a new instance of game.Game
     * calls game.Game's method start() to initialize a game.Board and a Character
     * calls game.Game's method launchGame() to start playing
     * @param args
     */
    public static void main(String[] args) {

        Inventory testInventory = new Inventory();
        System.out.println("test inventory -> "+testInventory.getContent());

        testInventory.setOffensiveGear(new Sword());
        System.out.println("test inventory -> "+testInventory.getContent());

        testInventory.setDefensiveGear(new Shield());
        System.out.println("test inventory -> "+testInventory.getContent());

        Potion[] myPotions= new Potion[10];
        myPotions[0]=new StandardPotion();
        testInventory.addPotion(0, new StandardPotion());
        System.out.println("test inventory -> "+testInventory.getPotions());

        testInventory.addPotion(1, new BigPotion());
        System.out.println("test inventory -> "+testInventory.getPotions());

        // starting new game.Game
        Game newGame = new Game();
        newGame.start();
        newGame.launchGame();
    }
}