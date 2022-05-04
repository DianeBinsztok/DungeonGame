package character;

public class Character {
    private String name;
    private String image;
    private Object attackAsset;
    private Object defenseAsset;
    private int lifePoints;
    private int maxLifePoints;
    private int attack;
    private int maxAttack;

    public Character(String name, String image, Object attackAsset, Object defenseAsset, int lifePoints, int maxLifePoints, int attack, int maxAttack) {
        this.name = name;
        this.image = image;
        this.attackAsset = attackAsset;
        this.defenseAsset = defenseAsset;
        this.lifePoints = lifePoints;
        this.maxLifePoints = maxLifePoints;
        this.attack = attack;
        this.maxAttack = maxAttack;
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

    public Object getAttackAsset() {
        return attackAsset;
    }

    public void setAttackAsset(Object attackAsset) {
        this.attackAsset = attackAsset;
    }

    public Object getDefenseAsset() {
        return defenseAsset;
    }

    public void setDefenseAsset(String defenseAsset) {
        this.defenseAsset = defenseAsset;
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
