package character.player;

import character.Character;
import character.enemy.Enemy;
import gear.Gear;
import gear.defensiveGear.DefensiveGear;
import gear.offensiveGear.OffensiveGear;

public abstract class Player extends Character {


    private String image;
    private OffensiveGear offensiveGear;
    private DefensiveGear defensiveGear;
    private int maxLifePoints;
    private int maxAttack;

    /**
     * constructor for Playing Characters
     * @param name
     * @param image
     * @param offensiveGear
     * @param defensiveGear
     * @param lifePoints
     * @param maxLifePoints
     * @param attack
     * @param maxAttack
     */
    public Player(String name, String type, String image, OffensiveGear offensiveGear, DefensiveGear defensiveGear, int lifePoints, int maxLifePoints, int attack, int maxAttack) {
        super(name, type, lifePoints, attack);
        this.image = image;
        this.offensiveGear = offensiveGear;
        this.defensiveGear = defensiveGear;
        this.maxLifePoints = maxLifePoints;
        this.maxAttack = maxAttack;
    }

    /**
     * Display player's data & stats
     * @return
     */
    public String toString(){
        String l = System.getProperty("line.separator");
        return( "------------   New player :   ------------" + l +
                "* Name : " + this.getName() + l +
                "* Class : " + this.getClass().getSimpleName()+ l +
                "* Gear : offensive: "+this.getOffensiveGear() + ", defensive : "+this.getDefensiveGear()+ l +
                "* LifePoints : " + this.getLifePoints()+ l +
                "* Attack power : " + this.getAttack()+ l +
                "-------------------------------------------"
        );
    }

    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }

    public OffensiveGear getOffensiveGear() {
        return offensiveGear;
    }
    public void setOffensiveGear(OffensiveGear offensiveGear) {
        this.offensiveGear = offensiveGear;
    }

    public DefensiveGear getDefensiveGear() {
        return defensiveGear;
    }
    public void setDefensiveGear(DefensiveGear defensiveGear) {
        this.defensiveGear = defensiveGear;
    }

    public int getMaxLifePoints() {
        return maxLifePoints;
    }
    public void setMaxLifePoints(int maxLifePoints) {
        this.maxLifePoints = maxLifePoints;
    }

    public int getMaxAttack() {
        return maxAttack;
    }
    public void setMaxAttack(int maxAttack) {
        this.maxAttack = maxAttack;
    }
}

