package gear.offensiveGear;

import character.player.Player;
import character.player.Wizard;
import gear.Gear;

public class Spell extends Gear {

    public Spell(String name, int stat) {
        super(name, stat);
    }

    public void changePlayerStat(Player player) {
        if (player instanceof Wizard){
            player.setAttack(player.getAttack() + this.getStat());
            player.setOffensiveGear(this);
            System.out.println("Congratulations wizard, you gained a new "+ this.getClass().getSimpleName() +": "+ player.getAttack()+". This will increase your damages on enemies by "+ this.getStat() +" points!");
        }else{
            System.out.println("You are not a wizard! This is useless to you.");
        }
    }

}
