package gear.defensiveGear;

import character.player.Player;
import character.player.Warrior;
import character.player.Wizard;
import gear.Gear;

public class Shield extends DefensiveGear {
    public Shield() {
        super("Shield", 5, "Warrior");
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
}
