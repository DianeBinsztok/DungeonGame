/**
 * imports
 */
import character.enemy.Dragon;
import character.enemy.Enemy;
import character.enemy.Goblin;
import character.enemy.Sorcerer;
import character.player.Player;
import events.Event;
import events.NoEvent;
import gear.Gear;
import gear.defensiveGear.Philter;
import gear.defensiveGear.Shield;
import gear.offensiveGear.Bolt;
import gear.offensiveGear.FireBall;
import gear.offensiveGear.Hammer;
import gear.offensiveGear.Sword;
import gear.potions.BigPotion;
import gear.potions.StandardPotion;

public class Cell {

     private Event cellEvent;

     public Event getCellEvent(){
         return this.cellEvent;
     }

    public void setCellEvent(){
        int randomI = (int) ((Math.random()*(3)));
        switch (randomI) {
            case 0: this.cellEvent = getNeutral();
                    break;
            case 1: this.cellEvent = getLoot();
                    break;
            case 2: this.cellEvent = getEnemy();
                    break;
            default: this.cellEvent = getNeutral();
                    break;
        }
    }

    /**
     * calls event's method happen(), with the event that was selected by getEvent()
     * @param player
     */
    /*
    public void launchEvent(Player player){
        cellEvent.happen(player);
    };
*/
    /**
     * set a neutral Event
     * @return instance of class NoEvent
     */
    public NoEvent getNeutral(){
        return new NoEvent();
    }

    /**
     * randomize loot event
     * @return an instance of Gear
     */
    public Gear getLoot(){
        Gear[] loots={new Philter(), new Shield(), new Hammer(), new Sword(), new FireBall(), new Bolt(), new StandardPotion(),new BigPotion()};
        int randomI = (int) ((Math.random()*(loots.length)));
        Gear loot = loots[randomI];
        return loot;
    }

    /**
     * randomize enemy event
     * @return an instance of Enemy
     */
    public Enemy getEnemy(){
        Enemy[] enemies={new Dragon(), new Sorcerer(), new Goblin()};
        int randomI = (int) ((Math.random()*(enemies.length)));
        Enemy enemy = enemies[randomI];
        return enemy;
    }

}
