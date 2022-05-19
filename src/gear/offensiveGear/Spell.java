package gear.offensiveGear;

import character.player.Player;
import character.player.Wizard;
import gear.Gear;

public abstract class Spell extends OffensiveGear {

    public Spell(String name, int stat) {
        super(name, stat, "Wizard");
    }
}
