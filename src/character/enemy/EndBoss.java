package character.enemy;


public class EndBoss extends Enemy{
    /**
     * Calling the Enemy constructor
     */
    public EndBoss() {
        super("Robert, the Very Bad One", "Boss", 20, 5);
    }

    /*
    @Override
    public void happen (Player player) throws PlayerRunsException {
        System.out.println("You are facing " + this.getName() + " !");
        // 1  - La décision du joueur:
        if(player.acceptFight(this)){
            System.out.println("Attack on "+this.getName()+"!");
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
                    System.out.println("   -> You have been killed by " +this.getName()+ ".");
                }
            }else{
                System.out.println("   -> Critical! "+this.getName()+" is dead.");
            }
        }else{
            System.out.println("You will be set 3 rooms back");
            // throw an exception to be caught in Game => renvoie un roll négatif
            PlayerRunsException playerRunsException = new PlayerRunsException();
            throw playerRunsException;
        }
    }
    */
}
