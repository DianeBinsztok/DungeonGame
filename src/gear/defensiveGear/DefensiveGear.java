package gear.defensiveGear;

import character.player.Player;
import gear.Gear;

public abstract class DefensiveGear extends Gear {

    private String authorizedHandler;

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

}
