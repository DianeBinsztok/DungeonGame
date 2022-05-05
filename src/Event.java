import character.player.Player;

public class Event {

    private String[] eventTypes = {"neutral","loot","enemy"};

    public void launchEvent(){

        switch (getEvent()) {
            case "neutral":
                System.out.println("You entered a boring looking room");
                break;
            case "loot":
                String loot = getLoot();
                System.out.println("You just found a " + loot + " !");
                break;
            case "enemy":
                String enemy = getEnemy();
                System.out.println("You are facing a blood-thirsty " + enemy + " !");
                break;
        }
    }

    private String getEvent(){
        int randomI = (int) ((Math.random()*(eventTypes.length)));
        String event = eventTypes[randomI];
        return event;
    }
    public String getLoot(){
        String[] loots={"Philter", "Shield", "Hammer", "Sword", "Fireball", "Bolt", "Life Potion","Big Life Potion"};
        int randomI = (int) ((Math.random()*(loots.length)));
        String loot = loots[randomI];
        return loot;
    }
    public String getEnemy(){
        String[] enemies={"Dragon", "Sorcerer", "Goblin"};
        int randomI = (int) ((Math.random()*(enemies.length)));
        String enemy = enemies[randomI];
        return enemy;
    }

    public void setEvent(String event) {
        switch (event) {
            case "neutral":
                System.out.println("You entered a boring looking room");
                break;
            case "loot":
                String loot = getLoot();
                System.out.println("You just found a " + loot + " !");
                break;
            case "enemy":
                String enemy = getEnemy();
                System.out.println("You are facing a blood-thirsty " + enemy + " !");
                break;
        }
    }
}
