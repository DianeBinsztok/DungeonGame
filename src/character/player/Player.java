package character.player;

import character.Character;

public class Player extends Character {
    public Player(String name, String image, Object attackAsset, Object defenseAsset, int lifePoints, int maxLifePoints, int attack, int maxAttack) {
        super(name, image, attackAsset, defenseAsset, lifePoints, maxLifePoints, attack, maxAttack);
    }
}
