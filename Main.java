public class Main {
    public static void main(String[] args) {
        Game test = new Game();
        for (int i = 0; i < 1000; i++) {
            int rolltest = test.diceRoll();
            if ((rolltest < 1) || (rolltest > 6)) {
                System.out.println("Probleme");
            }
        }
    }
}