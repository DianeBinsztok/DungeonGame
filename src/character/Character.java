package character;

import gear.Gear;

public class Character {
    private String name;
    private String image;
    private Object offensiveGear;
    private Object defensiveGear;
    private int lifePoints;
    private int maxLifePoints;
    private int attack;
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
    public Character(String name, String image, Object offensiveGear, Object defensiveGear, int lifePoints, int maxLifePoints, int attack, int maxAttack) {
        this.name = name;
        this.image = image;
        this.offensiveGear = offensiveGear;
        this.defensiveGear = defensiveGear;
        this.lifePoints = lifePoints;
        this.maxLifePoints = maxLifePoints;
        this.attack = attack;
        this.maxAttack = maxAttack;
    }

    /**
     * Contructor for Monsters, with fewer params
     * @param lifePoints
     * @param attack
     */
    public Character(int lifePoints, int attack){
        this.lifePoints = lifePoints;
        this.attack = attack;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Object getOffensiveGear() {
        return offensiveGear;
    }

    public void setOffensiveGear(Gear offensiveGear) {
        this.offensiveGear = offensiveGear;
    }

    public Object getDefensiveGear() {
        return defensiveGear;
    }

    public void setDefensiveGear(Gear defensiveGear) {
        this.defensiveGear = defensiveGear;
    }
    public int getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    public int getMaxLifePoints(){
        return maxLifePoints;
    }

    public void setMaxLifePoints(int maxLifePoints){
        this.maxLifePoints = maxLifePoints;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

}
