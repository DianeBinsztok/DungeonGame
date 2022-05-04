package gear.offensiveGear;

import gear.Gear;

public class Weapon extends Gear {

    public Weapon(String name, int stat) {
        super(name, stat);
    }

    public String getWeaponName() {
        return this.getName();
    }

    public int getWeaponStat() {
        return this.getStat();
    }
}
