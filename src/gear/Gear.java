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

// Une classe abstraite peut implémenter une interface sans implémenter ses méthodes
    public abstract void changePlayerStat(Player player);
}
