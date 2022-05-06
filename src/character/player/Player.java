package character.player;

import character.Character;

public class Player extends Character {
    public Player(String name, String image, Object offensiveGear, Object defensiveGear, int lifePoints, int maxLifePoints, int attack, int maxAttack) {
        super(name, image, offensiveGear, defensiveGear, lifePoints, maxLifePoints, attack, maxAttack);
    }

    /*
    public int modifyStat(int targetStat, int stat){
      return targetStat + stat;
    }
    */

    public String toString(){
        String l = System.getProperty("line.separator");
        return( "New player : " + l +
                "Name : " + this.getName() + l +
                "Class : " + this.getClass()+ l +
                "Gear : offensive: "+this.getOffensiveGear() + ", defensive : "+this.getDefensiveGear()+ l +
                "lifePoints : " + this.getLifePoints()+ l +
                "attack power : " + this.getAttack()
        );
    }
}

