package gear.offensiveGear;

import character.player.Player;
import character.player.Warrior;

public abstract class Weapon extends OffensiveGear {

    public Weapon(String name, int stat) {
        super(name, stat, "Warrior");
    }
}
