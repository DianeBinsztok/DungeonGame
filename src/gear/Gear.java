package gear;

import events.Event;
import character.player.Player;

public abstract class Gear implements Event {
    private String name;

    private int stat;


    public Gear(String name, int stat){
        this.name = name;
        this.stat = stat;
    }

    public String getName(){
        return this.name;
    }

    public int getStat(){
        return this.stat;
    }


    public abstract void changePlayerStat(Player player);

    // (Une classe abstraite peut implémenter une interface sans implémenter ses méthodes: il faudra qu'elles soient implémentées dans les sous-classes.
    // Ici, j'implémente happen, donc pas besoin de l'override dans les sous-classes.)
    public void happen(Player player){
        System.out.println("You found a "+ this.getName());
        this.changePlayerStat(player);
    }
}
