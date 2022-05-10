package gear.offensiveGear;

import character.player.Player;
import character.player.Warrior;
import character.player.Wizard;
import gear.Gear;

public class Weapon extends Gear {

    public Weapon(String name, int stat) {

        super(name, stat);
    }

    @Override
    public void changePlayerStat(Player player) {

        if (player instanceof Warrior){
            int playersNewAttackStat = player.getAttack() + this.getStat();
            // placer la nouvelle arme dans l'inventaire
            player.setOffensiveGear(this);
            // limiter la force d'attaque au maximum autorisé:
            if(playersNewAttackStat <= player.getMaxAttack()){
                player.setAttack(playersNewAttackStat);
            }else{
                player.setAttack(player.getMaxAttack());
            }
            System.out.println("Congratulations warrior, you gained a new "+ this.getClass().getSimpleName() +". This will increase your damages on enemies by "+ this.getStat() +" points!");
        }else{
            System.out.println("You are not a Warrior! This is useless to you.");
        }
    }

    public String getWeaponName() {
        return this.getName();
    }

    public int getWeaponStat() {
        return this.getStat();
    }

    @Override
    public void happen(Player player) {
        System.out.println("You found a "+ this.getName());
        this.changePlayerStat(player);
    }
}
