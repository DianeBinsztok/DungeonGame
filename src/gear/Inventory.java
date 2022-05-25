package gear;

import character.player.Player;
import gear.defensiveGear.DefensiveGear;
import gear.offensiveGear.OffensiveGear;
import gear.potions.Potion;
import java.util.*;

public class Inventory {

    private Player owner;
    private OffensiveGear offensiveGear;
    private DefensiveGear defensiveGear;
    private final List<Potion> potions = new ArrayList<Potion>();
    private int maxPotions = 5;
    private final Map<String, Object> content = new HashMap<String, Object>();


    // 0 - CONSTRUCTEUR
    public Inventory(){
        this.content.put("OffensiveGear", this.offensiveGear);
        this.content.put("DefensiveGear", this.defensiveGear);
        this.content.put("Potions", this.potions);
    }

    public String toString() {
        String offensiveGearString = "none";
        String defensiveGearString = "none";
        String potionsString = "empty";
        if(this.getOffensiveGear()!=null){
            offensiveGearString = this.getOffensiveGear().getName();
        }
        if(this.getDefensiveGear()!=null){
            defensiveGearString = this.getDefensiveGear().getName();
        }
        if(this.getPotionsToString()!=""){
            potionsString = getPotionsToString();
        }
        String l = System.getProperty("line.separator");
        return ("------------   Inventory :   ------------" + l +
                "* Offensive gear : " + offensiveGearString + l +
                "* Defensive gear : " + defensiveGearString + l +
                "* Potions bag: " + potionsString+l+
                "-------------------------------------------"
        );
    }

    public void inventoryMenu(){
        System.out.println(this);
        String l = System.getProperty("line.separator");
        System.out.println(
                        "[1] -> Switch my offensive gear,"+l+
                        "[2] -> Remove my offensive gear" +l+
                        "[3] -> Switch my defensive gear" +l+
                        "[4] -> Remove my defensive gear" +l+
                        "[5] -> Drink a potion" +l+
                        "-----------------------------------------------------"
        );
        Scanner scan = new Scanner(System.in);
        String playersChoice = scan.next();
        switch (playersChoice){
            case "1":
                switchGear(this.getOffensiveGear());
                break;
            case "2":
                System.out.println("Remove offensive gear - to be implemented");
                break;
            case "3":
                switchGear(this.getDefensiveGear());
                break;
            case "4":
                System.out.println("Remove defensive gear - to be implemented");
                break;
            case "5":
                owner.drinkPotion(getSinglePotion(0));
                break;
        }
    }

    public void switchGear(Gear gear){
        Gear playersGear;
        if(gear instanceof OffensiveGear){

            // aller chercher l'arme du joueur
            playersGear=this.owner.getOffensiveGear();
            // mettre l'arme du joueur dans l'inventaire
            this.setOffensiveGear((OffensiveGear) playersGear);
            // mettre l'arme de l'inventaire dans la main du joueur
            this.owner.setOffensiveGear((OffensiveGear) gear);

        } else if (gear instanceof DefensiveGear) {

            // chercher la protection du joueur
            playersGear=this.owner.getDefensiveGear();
            // mettre la protection dans l'inventaire
            this.setDefensiveGear((DefensiveGear) playersGear);
            // mettre la protection de l'inventaire sur le joueur
            this.owner.setDefensiveGear((DefensiveGear) gear);

        }else if(gear instanceof Potion){
            System.out.println("You can not switch a potion!");
        }else{
            System.out.println("You can not switch this!");
        }
    }

    // 1 - GETTERS
    // Afficher le contenu total de mon inventaire:
    public Map<String, Object> getContent(){
        return this.content;
    }
    // Afficher le détail de mon inventaire, par catégorie d'objets:
    public OffensiveGear getOffensiveGear(){
        return (OffensiveGear) this.content.get("OffensiveGear");
    }
    public DefensiveGear getDefensiveGear(){
        return (DefensiveGear) this.content.get("DefensiveGear");
    }
    public Potion[] getPotions(){
        return (Potion[]) this.content.get("Potions");
    }
    public Potion getSinglePotion(int i){
        return this.getPotions()[i];
    }

    // pour afficher le contenu du sac de potions
    public String getPotionsToString(){
        String stringPotions ="";
        for (Potion potion : potions) {
            stringPotions = stringPotions.concat(potion.getName())+" - ";
        }
        return stringPotions;
    }

    // 2 - SETTERS
    public void setOffensiveGear(OffensiveGear gear){
        this.content.replace("OffensiveGear", gear);
    }
    public void setDefensiveGear(DefensiveGear gear){
        this.content.replace("DefensiveGear", gear);
    }
    public void addPotion(Potion potion){
        if(potions.size()<this.maxPotions){
            this.potions.add(potion);
        }else{
            System.out.println("Your potion's bag is full!");
            // Permettre de cibler et remplacer une potion. Il faudra appeler une autre fonction
        }
    }

}
