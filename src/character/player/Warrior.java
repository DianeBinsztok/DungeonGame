package character.player;

import gear.Inventory;
import gear.defensiveGear.DefensiveGear;
import gear.offensiveGear.OffensiveGear;

public class Warrior extends Player {

    /**
     * Constructor for newly created Warrior
     * @param name
     */
    public Warrior(String name) {
        super(name, "Warrior", "http://image-of-Warrior", 5, 10, 5, 10, null, null, new Inventory());
    }

    /**
     * Constructor for Warrior picked in database (with modified stats and gear)
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
    public Warrior(String name, String type, String image, int lifePoints, int attack, int maxLifePoints, int maxAttack, OffensiveGear offensiveGear, DefensiveGear defensiveGear) {
        super(name, type, image,lifePoints, attack, maxLifePoints, maxAttack, offensiveGear, defensiveGear, new Inventory());
    }

}
