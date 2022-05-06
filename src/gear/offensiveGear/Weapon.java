package gear.offensiveGear;

import character.player.Player;
import character.player.Warrior;
import gear.Gear;

public class Weapon extends Gear {

    public Weapon(String name, int stat) {

        super(name, stat);
    }

    @Override

    public void changePlayerStat(Player player) {
        if (player instanceof Warrior){
            player.setAttack(player.getAttack() + this.getStat());
            player.setOffensiveGear(this);
            System.out.println("Congratulations warrior, you gained a new "+ this.getClass().getSimpleName() +". This will increase your damages on enemies by "+ this.getStat() +" points!");
        }else{
            System.out.println("You are not a warrior! This is useless to you.");
        }
    }

    public String getWeaponName() {
        return this.getName();
    }

    public int getWeaponStat() {
        return this.getStat();
    }
}
