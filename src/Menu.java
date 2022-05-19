public class Menu {

    /**
     * Creates a new instance of Game
     * calls Game's method start() to initialize a Board and a Character
     * calls Game's method launchGame() to start playing
     * @param args
     */
    public static void main(String[] args) {

        // starting new Game
        Game newGame = new Game();
        Board board = newGame.start();
        newGame.launchGame(board);
    }
}