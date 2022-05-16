import character.player.Player;
import character.player.Warrior;
import character.player.Wizard;

import javax.swing.*;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        // starting new Game
        Game newGame = new Game();
        Board board = newGame.start();
        newGame.launchGame(board);
    }
}