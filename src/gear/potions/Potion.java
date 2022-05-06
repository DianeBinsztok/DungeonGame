package gear.potions;

import character.player.Player;
import character.player.Wizard;
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

    public void changePlayerStat(Player player) {
            player.setLifePoints(player.getLifePoints() + this.getStat());
            System.out.println("You are feeling well rested!");

    }
}