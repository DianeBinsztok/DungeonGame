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
                System.out.println("You just found a " + loot.getName() + " !");
                loot.changePlayerStat(player);
                break;
            case "enemy":
                Enemy enemy = getEnemy();
                System.out.println("You are facing a blood-thirsty " + enemy.getName() + " !");
                // 1 - le joueur attaque l'ennemi
                player.attackOpponent(player.getAttack(), enemy);
                System.out.println("Attack on the " + enemy.getName());
                // Décompte des dommages:
                if(enemy.getLifePoints()>0){
                    System.out.println("   -> The "+ enemy.getName()+ " has "+ enemy.getLifePoints()+" life points left");
                }else{
                    System.out.println("   -> Critical! the " + enemy.getName() + " is dead");
                }

                // 2 - l'ennemi (s'il est en vie) attaque le joueur
                if(enemy.getLifePoints()>0){
                    enemy.attackOpponent(enemy.getAttack(), player);
                    System.out.println(enemy.getName()+ "'s counterattack!");
                    // Décompte des dommages:
                   if(player.getLifePoints()>0){
                       System.out.println("   -> You have "+ player.getLifePoints()+" life points left!");
                   }else{
                       System.out.println("   -> You are dead!");
                   }
                }
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
