package gear;

import gear.defensiveGear.DefensiveGear;
import gear.offensiveGear.OffensiveGear;
import gear.potions.Potion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory {

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
