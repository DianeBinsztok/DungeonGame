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
    public void happen(Player player) {
        // la partie
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
        }
        // FOF doit renvoyer une info : fuite, attaque critique, attaque non-critique



    }

    //fightOrFlight doit retourner qqc: un statut qui déclence l'event ou une valeur négative pour le rollback

}
