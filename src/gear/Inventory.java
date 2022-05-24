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
    //private Potion[] potions = new Potion[10];
    private List<Potion> potions = new ArrayList<Potion>();
    private Map<String, Object> content = new HashMap<String, Object>();

    // 0 - CONSTRUCTEUR
    public Inventory(){
        this.setOffensiveGear(null);
        this.setDefensiveGear(null);
        this.setPotions();
    }

    public String toString() {
        String l = System.getProperty("line.separator");
        return ("------------   My inventory :   ------------" + l +
                "* Offensive gear : " + this.getOffensiveGear().getName() + l +
                "* Defensive gear : " + this.getDefensiveGear().getName() + l +
                "* Potions : " + this.getPotionsToString()+l+
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

    public String getPotionsToString(){
        String stringPotions ="";
        for (Potion potion : potions) {
            stringPotions = stringPotions.concat(potion.getName());
        }
        return stringPotions;
    }

    // 2 - SETTERS
    public void setOffensiveGear(OffensiveGear gear){
        this.content.put("OffensiveGear", gear);
    }
    public void setDefensiveGear(DefensiveGear gear){
        this.content.put("DefensiveGear", gear);
    }
    public void setPotions(){
        this.content.put("Potions", this.potions);
    }

    // 3 - ADD to array potions
    public void addPotion(Potion potion){
        this.potions.add(potion);
    }

}
