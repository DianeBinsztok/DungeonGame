package gear.potions;

import gear.Gear;

public class Potion extends Gear {
    public Potion(String name, int stat) {
        super(name, stat);
    }

    public String getPotionName() {
        return this.getName();
    }

    public int getPotionStat() {
        return this.getStat();
    }

}