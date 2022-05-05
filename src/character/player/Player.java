package character.player;

import character.Character;

public class Player extends Character {
    public Player(String name, String image, Object offensiveGear, Object defensiveGear, int lifePoints, int maxLifePoints, int attack, int maxAttack) {
        super(name, image, offensiveGear, defensiveGear, lifePoints, maxLifePoints, attack, maxAttack);
    }
}

