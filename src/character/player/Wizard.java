package character.player;

import character.Character;

public class Wizard extends Character {
    public Wizard(String name, String image, Object offensiveGear, Object defensiveGear, int lifePoints, int maxLifePoints, int attack, int maxAttack) {
        super(name, image, null, null, 3, 6, 8, 15);
    }
}
