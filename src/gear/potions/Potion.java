package gear.potions;

import character.player.Player;
import character.player.Wizard;
import gear.Gear;

public abstract class Potion extends Gear {
    public Potion(String name, int stat) {
        super(name, stat);
    }

    /*
    public void changePlayerStat(Player player) {
            int playersNewLifePoints = player.getLifePoints() + this.getStat();
            // Limiter le gain de vie au maximum autorisé:
            if(playersNewLifePoints<=player.getMaxLifePoints()){
                player.setLifePoints(playersNewLifePoints);
            }else{
                player.setLifePoints(player.getMaxLifePoints());
            }
            System.out.println("Your health is now at " + player.getLifePoints()+ " lifepoints!");
    }
     */

    public void happen(Player player){
        System.out.println("You found a "+ this.getName());
        player.drinkPotion(this);
    }
}
