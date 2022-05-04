import character.player.Player;
import character.player.Warrior;

public class Main {
    public static void main(String[] args) {
        Game g = new Game();
        for (int i = 0; i < 1000; i++) {
            int test = g.diceRoll();
            if ((test < 1) || (test > 6)) {
                System.out.println("Problem");
            }
        }

        Player Dudule = new Player("Dudule", "Dudule_avatar", "Sword", "Shield", 3, 10, 5, 10);
        System.out.println("New player named "+ Dudule.getName() + ", equiped with "+ Dudule.getOffensiveGear()+ " and " + Dudule.getDefensiveGear());
    }
}