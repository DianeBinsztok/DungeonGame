package gear.offensiveGear;

import gear.Gear;

public class Spell extends Gear {

    public Spell(String name, int stat) {
        super("Basic spell", 5);
    }

    public String getSpellName() {
        return this.getName();
    }

    public int getSpellStat() {
        return this.getStat();
    }
}
