package gear;

import gear.defensiveGear.DefensiveGear;
import gear.offensiveGear.OffensiveGear;
import gear.potions.Potion;

import java.util.HashMap;
import java.util.Map;

public class Inventory {

    private OffensiveGear offensiveGear;
    private DefensiveGear defensiveGear;
    private Potion[] potions = new Potion[10];
    private Map<String, Object> content = new HashMap<String, Object>();

    // 0 - CONSTRUCTEUR
    public Inventory(){
        this.setOffensiveGear(null);
        this.setDefensiveGear(null);
        this.setPotions();
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
    public void addPotion(int index, Potion potion){
        this.potions[index]=potion;
    }

}
