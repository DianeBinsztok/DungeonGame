package gear;

import events.Event;
import character.player.Player;

public abstract class Gear implements Event {
    private String name;

    private int stat;

    /**
     * For gear that works for all player's classes (ex: potions can be picked by all players)
     * @param name
     * @param stat
     */
    public Gear(String name, int stat){
        this.name = name;
        this.stat = stat;
    }

    public String getName(){
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getStat(){
        return this.stat;
    }
    public void setStat(int stat) {
        this.stat = stat;
    }

    //public abstract void changePlayerStat(Player player);

    // (Une classe abstraite peut implémenter une interface sans implémenter ses méthodes: il faudra qu'elles soient implémentées dans les sous-classes.
}
