package gear.defensiveGear;

import gear.Gear;

public class Philter extends Gear {

    public Philter() {
        super("Philter", 5);
    }

    public String getPhilterName(){
        return this.getName();
    }
    public int getPhilterProtection() {
        return this.getStat();
    }
}
