package events;

import character.player.Player;

public class NoEvent implements Event{
    @Override
    public void happen(Player player) {
        System.out.println("You entered a boring looking room");
    }
}
