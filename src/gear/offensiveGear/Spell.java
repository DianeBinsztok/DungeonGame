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
            int playersNewAttackStat = player.getAttack() + this.getStat();
            // placer le nouveau sort dans l'inventaire
            player.setOffensiveGear(this);
            // limiter la force d'attaque au maximum autorisé:
            if(playersNewAttackStat <= player.getMaxAttack()){
                player.setAttack(playersNewAttackStat);
            }else{
                player.setAttack(player.getMaxAttack());
            }
            System.out.println("Congratulations wizard, you gained a new "+ this.getClass().getSimpleName() +": "+ player.getAttack()+". This will increase your damages on enemies by "+ this.getStat() +" points!");
        }else{
            System.out.println("You are not a wizard! This is useless to you.");
        }
    }

}
