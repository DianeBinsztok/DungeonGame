package gear.offensiveGear;

import character.player.Player;
import character.player.Warrior;
import gear.Gear;

public abstract class OffensiveGear extends Gear {

    private String authorizedHandler;

    /**
     * Constructor for offensive gear: uses gear constructor and adds a prop authorizedHandler;
     * @param name
     * @param stat
     * @param authorizedHandler
     */
    public OffensiveGear(String name, int stat, String authorizedHandler) {
        super(name, stat);
        this.authorizedHandler = authorizedHandler;
    }

    public String getAuthorizedHandler() {
        return authorizedHandler;
    }
    public void setAuthorizedHandler(String authorizedHandler) {
        this.authorizedHandler = authorizedHandler;
    }

    /**
     * implementing event interface's method happen()
     * call player's method pickOffensiveGear()
     * @param player
     */
    public void happen(Player player){
        System.out.println("You found a "+ this.getName());
        player.pickOffensiveGear(this);
    }
}