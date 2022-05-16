package gear.potions;

import character.player.Player;
import character.player.Wizard;
import gear.Gear;

public abstract class Potion extends Gear {
    public Potion(String name, int stat) {
        super(name, stat);
    }

    public void happen(Player player){
        System.out.println("You found a "+ this.getName());
        player.drinkPotion(this);
    }
}
