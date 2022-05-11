package gear.offensiveGear;

import character.player.Player;
import character.player.Warrior;
import gear.Gear;

public abstract class OffensiveGear extends Gear {

    private String authorizedHandler;

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
}