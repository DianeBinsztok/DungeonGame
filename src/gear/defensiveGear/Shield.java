package gear.defensiveGear;

import character.player.Player;
import character.player.Warrior;
import character.player.Wizard;
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

    @Override
    public void changePlayerStat(Player player) {
        if (player instanceof Warrior){
            player.setDefensiveGear(this);
            System.out.println("Congratulations warrior, you gained a new "+ this.getClass().getSimpleName() +". This will diminish your enemy's damage by "+ this.getStat() +" points!");
        }else{
            System.out.println("You are not a warrior! This is useless to you.");
        }
    }

    @Override
    public void happen(Player player) {
        System.out.println("You found a " + this.getName());
        this.changePlayerStat(player);
    }
}
