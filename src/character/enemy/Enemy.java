package character.enemy;

import events.Event;
import character.Character;
import character.player.Player;

import java.util.Scanner;

public abstract class Enemy extends Character implements Event {

    /**
     * Calling the 2nd Character constructor
     * @param lifePoints
     * @param attack
     */
    public Enemy(String name, String type, int lifePoints, int attack) {
        super(name, type ,lifePoints, attack);
    }

    @Override
    /**
     * Overriding Character's method attackOpponent()
     * the opponent is cast as a Player
     * considers the player's defensiveGear to limit the damage
     */
    public int attackOpponent(Character opponent) {
        int opponentsNewLifePoints = opponent.getLifePoints() - this.getAttack();
        if(((Player) opponent).getDefensiveGear()!=null){
            opponentsNewLifePoints += ((Player) opponent).getDefensiveGear().getStat();
        }
        if(opponentsNewLifePoints > 0){
            opponent.setLifePoints(opponentsNewLifePoints);
        }else{
            opponent.setLifePoints(0);
        }
        return opponent.getLifePoints();
    }

    @Override
    /**
     * Overriding interface Event's method happen():
     * when the event in an Enemy :
     * - call player's method acceptFight();
     * - If the player accepts the fight, call attackOpponent() for Player, then Enemy
     * - If the player refuses the fight, throw an exception
     */
    public void happen (Player player) throws Exception {
        System.out.println("You are facing a blood-thirsty " + getName() + " !");
        // 1  - La décision du joueur:
        if(player.acceptFight(this)){
            System.out.println("Attack on the "+this.getName()+"!");
            player.attackOpponent(this);
            // 2 - l'ennemi (s'il est en vie) attaque le joueur
            if(this.getLifePoints()>0){
                System.out.println("He has "+this.getLifePoints()+" life point(s) left...");
                System.out.println(this.getName()+ "'s counterattack!");
                this.attackOpponent(player);

                // Décompte des dommages:
                if(player.getLifePoints()>0){
                    System.out.println("   -> You have "+ player.getLifePoints()+" life points left!");
                }else{
                    System.out.println("   -> You have been killed by the " +this.getName()+ ".");
                }
            }else{
                System.out.println("   -> Critical! the "+this.getName()+" is dead.");
            }
        }else{
            System.out.println("You will be set 3 rooms back");
            // throw an exception to be caught in Game => renvoie un roll négatif
            Exception playerRunsException = new Exception("You will be set 3 rooms back");
            throw playerRunsException;
        }
    }


}
