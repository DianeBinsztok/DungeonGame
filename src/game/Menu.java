package game;

public class Menu {
    /**
     * Creates a new instance of game.Game
     * calls game.Game's method start() to initialize a game.Board and a Character
     * calls game.Game's method launchGame() to start playing
     * @param args
     */
    public static void main(String[] args) {
        // starting new game.Game
        Game game = new Game();
        game.start();
        game.launchGame();
    }
}