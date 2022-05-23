package character.enemy;
import character.Character;
import character.player.Player;
import events.Event;
import exceptions.PlayerRunsException;
import gear.defensiveGear.DefensiveGear;

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
        int damage = this.getAttack();
        DefensiveGear protection = ((Player) opponent).getDefensiveGear();
        if(protection!=null){
            if(damage<= protection.getStat()){
                damage = 0;
            }else if(damage>protection.getStat()){
                damage -= ((Player) opponent).getDefensiveGear().getStat();
            }
        }
        int opponentsNewLifePoints = opponent.getLifePoints() - damage;
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
    public void happen (Player player) throws PlayerRunsException {
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
            // throw an exception to be caught in game.Game => renvoie un roll négatif
            PlayerRunsException playerRunsException = new PlayerRunsException();
            throw playerRunsException;
        }
    }


}
