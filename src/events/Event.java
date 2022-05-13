package events;

import character.player.Player;


public interface Event {
    void happen(Player player)throws Exception;
}
