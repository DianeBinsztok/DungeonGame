import character.player.Player;
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
/*
    private Event event;

    public Cell(){
        this.event = new Event();
    }

    public void launchCellEvent(){
         event.launchEvent();
    }
*/

    private String[] eventTypes = {"neutral","loot","enemy"};

    private String getEvent(){
        int randomI = (int) ((Math.random()*(this.eventTypes.length)));
        return this.eventTypes[randomI];
    }

    public void launchEvent(Player player){
        switch (getEvent()) {
            case "neutral":
                System.out.println("You entered a boring looking room");
                break;
            case "loot":
                Gear loot = getLoot();
                System.out.println("You just found a " + loot + " !");
                loot.changePlayerStat(player);
                break;
            case "enemy":
                String enemy = getEnemy();
                System.out.println("You are facing a blood-thirsty " + enemy + " !");
                break;
        }
    }


    public Gear getLoot(){
        Gear[] loots={new Philter(), new Shield(), new Hammer(), new Sword(), new FireBall(), new Bolt(), new StandardPotion(),new BigPotion()};
        int randomI = (int) ((Math.random()*(loots.length)));
        Gear loot = loots[randomI];
        return loot;
    }

    public String getEnemy(){
        String[] enemies={"Dragon", "Sorcerer", "Goblin"};
        int randomI = (int) ((Math.random()*(enemies.length)));
        String enemy = enemies[randomI];
        return enemy;
    }

}
