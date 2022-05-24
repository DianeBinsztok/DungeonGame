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

        testInventory.setOffensiveGear(new Sword());

        testInventory.setDefensiveGear(new Shield());

        Potion[] myPotions= new Potion[10];
        myPotions[0]=new StandardPotion();
        testInventory.addPotion(new StandardPotion());
        testInventory.addPotion(new BigPotion());
        System.out.println(testInventory);

        // starting new game.Game
        Game newGame = new Game();
        newGame.start();
        newGame.launchGame();
    }
}