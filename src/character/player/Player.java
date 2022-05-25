package character.player;

import character.Character;
import character.enemy.Enemy;
import gear.Inventory;
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
    private Inventory inventory;
    /**
     * constructor for Playing Characters
     * @param name
     * @param type
     * @param image
     * @param offensiveGear
     * @param defensiveGear
     * @param lifePoints
     * @param maxLifePoints
     * @param attack
     * @param maxAttack
     */
    public Player(String name, String type, String image, int lifePoints, int maxLifePoints, int attack, int maxAttack, OffensiveGear offensiveGear, DefensiveGear defensiveGear, Inventory inventory) {
        super(name, type, lifePoints, attack);
        this.image = image;
        this.maxLifePoints = maxLifePoints;
        this.maxAttack = maxAttack;
        this.offensiveGear = offensiveGear;
        this.defensiveGear = defensiveGear;
        this.inventory = inventory;
    }

    @Override
    /**
     * Overriding Character's method getAttack:
     * Player's getAttack() getter takes Player's offensiveGear in consideration
     */
    public int getAttack() {
        if(this.getOffensiveGear()!=null){
            // La puissance d'attaque du joueur s'incrémente de celle de son équipement offensif
            int getNewAttack = super.getAttack()+this.getOffensiveGear().getStat();
            // Limiter à la puissance max autorisée dans les props:
            if(getNewAttack>this.getMaxAttack()){
                getNewAttack = this.getMaxAttack();
            }
            return getNewAttack;
        }else{
            return super.getAttack();
        }
    }

    public String getImage() {
        return this.image;
    }
    public void setImage(String image) {
        this.image = image;
    }

    public Inventory getInventory(){return this.inventory;}

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

    /**
     * Display player's data & stats
     * @return
     */
    public String toString(){
        String l = System.getProperty("line.separator");
        return( "------------   New player :  "+this.getName()+" ------------" + l +
                "* Class : " + this.getType()+ l +
                "* Gear : offensive: "+this.getOffensiveGear() + ", defensive : "+this.getDefensiveGear()+ l +
                "* LifePoints : " + this.getLifePoints()+ l +
                "* Attack power : " + this.getAttack()+ l +
                "-------------------------------------------" + l +
                this.getInventory()+ l +

                "-------------------------------------------"
        );
    }

    /**
     * When facing an enemy: ask the player if he chooses to fight or flee
     * @param enemy
     * @return true(to fight) or false(to flee).
     */
    public boolean acceptFight(Enemy enemy) {
        String l = System.getProperty("line.separator");
        System.out.println(
                "--------------   Fight or flight!   --------------" + l +
                        "If you fight the "+ enemy.getName()+", he can cost you "+enemy.getAttack()+ " lifepoint(s). "+l+
                        "If you flee, you will be set back to a previous chamber!"+l+
                        "[1] -> to fight,"+l+
                        "[2] -> to flee." +l+
                        "-----------------------------------------------------"
        );
        Scanner scan = new Scanner(System.in);
        String playersChoice = scan.next();

        if (playersChoice.equals("1")) {
            return true;
        } else if (playersChoice.equals("2")) {
            return false;
        }
        System.out.println("You can only type 1 or 2");
        return acceptFight(enemy);
    }
    /**
     * When the Player finds an offensive gear:
     * 1 - check if compatible with player's type
     * 2 - check player's gear : pick gear, replace or put in inventory
     * 3 - set Player's gear
     */
    public void handleOffensiveGear(OffensiveGear gear){
        if (gear.getAuthorizedHandler().equals(this.getType())){

            if(this.getOffensiveGear()!=null){
                String l = System.getProperty("line.separator");
                System.out.println("You already have a "+this.getOffensiveGear().getName()+" as offensive gear. "+ l +
                        "[1] -> replace my offensive gear" +l+
                        "[2] -> store in my inventory" +l+
                        "[3] -> leave the "+gear.getName());
                Scanner scan = new Scanner(System.in);
                String playersChoice = scan.next();
                if(playersChoice.equals("1")){
                    this.setOffensiveGear(gear);
                    System.out.println("You are now holding a "+ this.getOffensiveGear().getName());
                } else if (playersChoice.equals("2")) {
                    this.inventory.setOffensiveGear(gear);
                    System.out.println(this.inventory);
                }
            }else{
                this.setOffensiveGear(gear);
                System.out.println("Congratulations "+this.getType()+", you gained a new "+ offensiveGear.getName() +". This will increase your damages on enemies by "+ offensiveGear.getStat() +" points!");
            }
        }else{
            System.out.println("You are not a "+gear.getAuthorizedHandler()+"! This is useless to you.");
        }
    }
    /**
     * When the Player finds a defensive gear:
     * 1 - check if compatible with player's type
     * 2 - check player's gear : pick gear, replace or put in inventory
     * 3 - set Player's gear
     */
    public void handleDefensiveGear(DefensiveGear gear){
        if (gear.getAuthorizedHandler().equals(this.getType())){

            if(this.getDefensiveGear()!=null){
                String l = System.getProperty("line.separator");
                System.out.println("You already have a "+this.getDefensiveGear().getName()+" as defensive gear. "+ l +
                        "[1] -> replace my defensive gear" +l+
                        "[2] -> store in my inventory" +l+
                        "[3] -> leave the "+gear.getName());
                Scanner scan = new Scanner(System.in);
                String playersChoice = scan.next();
                if(playersChoice.equals("1")){
                    this.setDefensiveGear(gear);
                    System.out.println("You are now holding a "+ this.getDefensiveGear().getName());
                } else if (playersChoice.equals("2")) {
                    this.inventory.setDefensiveGear(gear);
                    System.out.println(this.inventory);
                }
            }else{
                this.setDefensiveGear(gear);
                System.out.println("Congratulations "+ this.getType()+", you gained a new "+ defensiveGear.getName() +". This will diminish your enemy's damage by "+ defensiveGear.getStat() +" points!");

            }
        }else{
            System.out.println("You are not a "+gear.getAuthorizedHandler()+"! This is useless to you.");
        }
    }

    public void handlePotion(Potion potion){
        String l = System.getProperty("line.separator");
        System.out.println(
                "[1] -> drink the potion" +l+
                        "[2] -> store in my inventory" +l+
                        "[3] -> leave the potion");
        Scanner scan = new Scanner(System.in);
        String playersChoice = scan.next();
        if(playersChoice.equals("1")){
            this.drinkPotion(potion);
        } else if (playersChoice.equals("2")) {
            this.inventory.addPotion(potion);
            System.out.println(this.inventory);
        }
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

}

