package gear.defensiveGear;

import character.player.Player;
import gear.Gear;

import java.sql.Driver;

public abstract class DefensiveGear extends Gear {

    private String authorizedHandler;

    /**
     * Contructor for defensive gear: uses global Gear's constructor
     * @param name
     * @param stat
     * @param authorizedHandler
     */
    public DefensiveGear(String name, int stat, String authorizedHandler) {
        super(name, stat);
        this.authorizedHandler=authorizedHandler;
    }

    public String getAuthorizedHandler() {
        return authorizedHandler;
    }
    public void setAuthorizedHandler(String authorizedHandler) {
        this.authorizedHandler = authorizedHandler;
    }

    /**
     * implementing event interface's method happen()
     * call player's method pickDefensiveGear()
     * @param player
     */
    public void happen(Player player){
        System.out.println("You found a "+ this.getName());
        player.pickDefensiveGear(this);
    }

}

