import character.enemy.Dragon;
import character.enemy.Enemy;
import character.enemy.Goblin;
import character.enemy.Sorcerer;
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
                Enemy enemy = getEnemy();
                System.out.println("You are facing a blood-thirsty " + enemy.getName() + " !");
                player.attackOpponent(player.getAttack(), enemy);
                System.out.println("You are attacking the " + enemy.getName()+ ". He has " + enemy.getLifePoints()+ " life points left!");
                break;
        }
    }


    public Gear getLoot(){
        Gear[] loots={new Philter(), new Shield(), new Hammer(), new Sword(), new FireBall(), new Bolt(), new StandardPotion(),new BigPotion()};
        int randomI = (int) ((Math.random()*(loots.length)));
        Gear loot = loots[randomI];
        return loot;
    }

    public Enemy getEnemy(){
        Enemy[] enemies={new Dragon(), new Sorcerer(), new Goblin()};
        int randomI = (int) ((Math.random()*(enemies.length)));
        Enemy enemy = enemies[randomI];
        return enemy;
    }

}
