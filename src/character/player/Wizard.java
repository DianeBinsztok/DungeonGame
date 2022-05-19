package character.player;

import gear.defensiveGear.DefensiveGear;
import gear.offensiveGear.OffensiveGear;

public class Wizard extends Player {

    /**
     * Constructor for newly created Warrior
     * @param name
     */
    public Wizard(String name) {
        super(name, "Wizard", "Wizard", 3, 8, 6, 15, null, null);
    }

    /**
     * Constructor for Wizard picked in database (with modified stats and gear)
     * @param name
     * @param type
     * @param image
     * @param lifePoints
     * @param attack
     * @param maxLifePoints
     * @param maxAttack
     * @param offensiveGear
     * @param defensiveGear
     */
    public Wizard(String name, String type, String image, int lifePoints, int attack, int maxLifePoints,  int maxAttack, OffensiveGear offensiveGear, DefensiveGear defensiveGear) {
        super(name, type, image,lifePoints, attack, maxLifePoints, maxAttack, offensiveGear, defensiveGear);
    }
}
