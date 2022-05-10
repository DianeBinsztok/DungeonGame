package gear.defensiveGear;

import character.player.Player;
import character.player.Wizard;
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

    @Override
    public void changePlayerStat(Player player) {
        if (player instanceof Wizard){
            player.setDefensiveGear(this);
            System.out.println("Congratulations wizard, you gained a new "+ this.getClass().getSimpleName() +". This will diminish your enemy's damage by "+ this.getStat() +" points!");
        }else{
            System.out.println("You are not a wizard! This is useless to you.");
        }
    }

    @Override
    public void happen(Player player) {
        System.out.println("You found a " + this.getName());
        this.changePlayerStat(player);
    }
}
