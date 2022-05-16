public class Menu {
    public static void main(String[] args) {
        // starting new Game
        Game newGame = new Game();
        Board board = newGame.start();
        newGame.launchGame(board);
    }
}