package gear;
import character.player.Player;

public abstract class Gear {
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

}
