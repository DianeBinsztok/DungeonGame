package gear.defensiveGear;

import gear.Gear;

public class Shield extends Gear {
    public Shield() {
        super("Shield", 5);
    }

    public String getShieldName(){
        return this.getName();
    }
    public int getShieldProtection() {
        return this.getStat();
    }
}
