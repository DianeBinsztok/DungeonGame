import character.player.*;
import gear.Gear;

import java.util.Scanner;


public class Game {




    /**
     * Throw dice
     * @return random int between 1 & 6
     */
    public int diceRoll(){
       return (int) ((Math.random()*(6-1))+1);
    }
}

