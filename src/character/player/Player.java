package character.player;

import character.Character;
import character.enemy.Enemy;
import gear.Gear;
import gear.defensiveGear.DefensiveGear;
import gear.offensiveGear.OffensiveGear;
import gear.potions.Potion;

import java.util.Scanner;

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
                "* Class : " + this.getType()+ l +
                "* Gear : offensive: "+this.getOffensiveGear() + ", defensive : "+this.getDefensiveGear()+ l +
                "* LifePoints : " + this.getLifePoints()+ l +
                "* Attack power : " + this.getAttack()+ l +
                "-------------------------------------------"
        );
    }

    /**
     * When the Player finds a potion:
     * set player's lifePoints
     */
    public void drinkPotion(Potion potion){
            int playersNewLifePoints = this.getLifePoints() + potion.getStat();
            // Limiter le gain de vie au maximum autorisé:
            if(playersNewLifePoints<=this.getMaxLifePoints()){
                this.setLifePoints(playersNewLifePoints);
            }else{
                this.setLifePoints(this.getMaxLifePoints());
            }
            System.out.println("Your health is now at " + this.getLifePoints()+ " lifepoints!");
    }

    /**
     * When the Player finds a specialised gear:
     * check if compatible with player's type
     * set Player's gear
     */
    public void pickDefensiveGear(DefensiveGear defensiveGear){
        if (defensiveGear.getAuthorizedHandler().equals(this.getType())){
            if(this.getDefensiveGear()!=null){
                System.out.println("You already have a "+this.getDefensiveGear().getName()+" as defensive gear. Type 1 to replace it, type 2 to leave it.");
                Scanner scan = new Scanner(System.in);
                String playersChoice = scan.next();
                if(playersChoice.equals("1")){
                    this.setDefensiveGear(defensiveGear);
                    System.out.println("Your inventory now contains a "+ this.getDefensiveGear().getName());
                }
            }else{
                this.setDefensiveGear(defensiveGear);
                System.out.println("Congratulations "+ this.getType()+", you gained a new "+ defensiveGear.getName() +". This will diminish your enemy's damage by "+ defensiveGear.getStat() +" points!");
                }
        }else{
            System.out.println("You are not a "+defensiveGear.getAuthorizedHandler()+"! This is useless to you.");
        }
    }

    public void pickOffensiveGear(OffensiveGear offensiveGear){
        if (offensiveGear.getAuthorizedHandler().equals(this.getType())){
            if(this.getOffensiveGear()!=null){
                System.out.println("You already have a "+this.getOffensiveGear().getName()+" as offensive gear. Type 1 to replace it, type 2 to leave it.");
                Scanner scan = new Scanner(System.in);
                String playersChoice = scan.next();
                if(playersChoice.equals("1")){
                    this.setOffensiveGear(offensiveGear);
                    System.out.println("Your inventory now contains a "+ this.getOffensiveGear().getName());
                    int playersNewAttackStat = this.getAttack() + offensiveGear.getStat();
                    // placer la nouvelle arme dans l'inventaire
                    this.setOffensiveGear(offensiveGear);
                    // limiter la force d'attaque au maximum autorisé:
                    if(playersNewAttackStat <= this.getMaxAttack()){
                        this.setAttack(playersNewAttackStat);
                    }else{
                        this.setAttack(this.getMaxAttack());
                    }
                }
            }else{
                int playersNewAttackStat = this.getAttack() + offensiveGear.getStat();
                // placer la nouvelle arme dans l'inventaire
                this.setOffensiveGear(offensiveGear);
                // limiter la force d'attaque au maximum autorisé:
                if(playersNewAttackStat <= this.getMaxAttack()){
                    this.setAttack(playersNewAttackStat);
                }else{
                    this.setAttack(this.getMaxAttack());
                }
                System.out.println("Congratulations "+this.getType()+", you gained a new "+ offensiveGear.getName() +". This will increase your damages on enemies by "+ offensiveGear.getStat() +" points!");
            }

        }else{
            System.out.println("You are not a "+offensiveGear.getAuthorizedHandler()+"! This is useless to you.");
        }
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

