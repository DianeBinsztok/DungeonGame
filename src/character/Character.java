package character;

public abstract class Character{
    private String name;
    private String type;
    private int lifePoints;
    private int attack;

    /**
     * Contructor for Players and Monsters
     * @param name
     * @param lifePoints
     * @param attack
     */
    public Character(String name, String type, int lifePoints, int attack){
        this.name = name;
        this.type= type;
        this.lifePoints = lifePoints;
        this.attack = attack;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public int getLifePoints() {
        return lifePoints;
    }
    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    public int getAttack() {
        return attack;
    }
    public void setAttack(int attack) {
        this.attack = attack;
    }

    /**
     * Attack tho opponent : resets opponent's lifepoints with a limit of zero
     * Works for a player attacking an enemy and the other way: the method will be overridden to cast the opponent as a player or an enemy
     * @param opponent
     * @return
     */
    public int attackOpponent(Character opponent) {
        int opponentsLife = opponent.getLifePoints() - this.getAttack();
        if(opponentsLife > 0){
            opponent.setLifePoints(opponentsLife);
        }else{
            opponent.setLifePoints(0);
        }
        return opponent.lifePoints;
    }
}
