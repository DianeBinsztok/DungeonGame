package gear.potions;

import character.player.Player;
import character.player.Wizard;
import gear.Gear;

public abstract class Potion extends Gear {
    /**
     * Potions use the global constructor for Gear : potions can be picked by all player types
     * @param name
     * @param stat
     */
    public Potion(String name, int stat) {
        super(name, stat);
    }

    /**
     * Overriding interface Event's method happen(): When the player finds a potion, he/she drinks it
     * @param player
     */
    public void happen(Player player){
        System.out.println("You found a "+ this.getName());
        player.drinkPotion(this);
    }
}
