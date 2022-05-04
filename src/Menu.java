import character.player.Warrior;

public class Menu {
    public static void main(String[] args) {
        Game g = new Game();
        for (int i = 0; i < 1000; i++) {
            int test = g.diceRoll();
            if ((test < 1) || (test > 6)) {
                System.out.println("Problem");
            }
        }

       /* Warrior Dudule = new Warrior("Dudule");
        System.out.println("New player named "+ Dudule.getName() + ", equiped with "+ Dudule.getOffensiveGear()+ " and " + Dudule.getDefensiveGear());*/
        Cell c = new Cell();
        System.out.println(c.setEvent());
    }


}