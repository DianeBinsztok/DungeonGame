package character.player;

import character.Character;

public class Warrior extends Character {

    public Warrior(String name, String image, Object offensiveGear, Object defensiveGear, int lifePoints, int maxLifePoints, int attack, int maxAttack) {
        super(name, image, null, null, 5, 10, 5, 10);
    }
}
