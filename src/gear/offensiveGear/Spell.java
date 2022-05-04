package gear.offensiveGear;

import gear.Gear;

public class Spell extends Gear {

    public Spell(String name, int stat) {
        super(name, stat);
    }

    public String getSpellName() {
        return this.getName();
    }

    public int getSpellStat() {
        return this.getStat();
    }
}
