package gear;

import character.player.Player;
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

    public void switchGear(Player player, Gear gear){
        Gear playersGear;
        if(gear instanceof OffensiveGear){

            // aller chercher l'arme du joueur
            playersGear=player.getOffensiveGear();
            // mettre l'arme du joueur dans l'inventaire
            this.setOffensiveGear((OffensiveGear) playersGear);
            // mettre l'arme de l'inventaire dans la main du joueur
            player.setOffensiveGear((OffensiveGear) gear);

        } else if (gear instanceof DefensiveGear) {

            // chercher la protection du joueur
            playersGear=player.getDefensiveGear();
            // mettre la protection dans l'inventaire
            this.setDefensiveGear((DefensiveGear) playersGear);
            // mettre la protection de l'inventaire sur le joueur
            player.setDefensiveGear((DefensiveGear) gear);

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
