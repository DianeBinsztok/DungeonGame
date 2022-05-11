package gear.defensiveGear;

import character.player.Player;
import character.player.Wizard;
import gear.Gear;

public class Philter extends DefensiveGear {


    public Philter() {
        super("Philter", 5, "Wizard");
    }
    /*
    @Override
    public void changePlayerStat(Player player) {
        if (player instanceof Wizard){
            player.setDefensiveGear(this);
            System.out.println("Congratulations wizard, you gained a new "+ this.getClass().getSimpleName() +". This will diminish your enemy's damage by "+ this.getStat() +" points!");
        }else{
            System.out.println("You are not a wizard! This is useless to you.");
        }
    }
    */
}
