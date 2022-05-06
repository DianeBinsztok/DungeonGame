package character.enemy;

import character.Character;
import character.player.Player;

public  class  Enemy extends Character {

    /**
     * Calling the 2nd Character constructor
     * @param lifePoints
     * @param attack
     */
    public Enemy(int lifePoints, int attack) {
        super(lifePoints, attack);
    }
}
