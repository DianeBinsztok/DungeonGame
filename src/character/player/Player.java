package character.player;

import character.Character;
import character.enemy.Enemy;

public abstract class Player extends Character {


    public Player(String name, String image, Object offensiveGear, Object defensiveGear, int lifePoints, int maxLifePoints, int attack, int maxAttack) {
        super(name, image, offensiveGear, defensiveGear, lifePoints, maxLifePoints, attack, maxAttack);
    }


    public String toString(){
        String l = System.getProperty("line.separator");
        return( "------------   New player :   ------------" + l +
                "* Name : " + this.getName() + l +
                "* Class : " + this.getClass()+ l +
                "* Gear : offensive: "+this.getOffensiveGear() + ", defensive : "+this.getDefensiveGear()+ l +
                "* LifePoints : " + this.getLifePoints()+ l +
                "* Attack power : " + this.getAttack()+ l +
                "-------------------------------------------"
        );
    }
}

