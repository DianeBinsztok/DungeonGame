public class Cell {

    public String setEvent(){
        String[] events= {"neutral","loot","enemy"};
        int randomI = (int) ((Math.random()*(events.length)));
        String event = events[randomI];
        return event;
    }
    public String setLoot(){
        String[] loots={"Philter", "Shield", "Hammer", "Sword", "Fireball", "Bolt", "Life Potion","Big Life Potion"};
         int randomI = (int) ((Math.random()*(loots.length)));
         String loot = loots[randomI];
         return loot;
    }
    public String setEnemy(){
        String[] enemies={"Dragon", "Sorcerer", "Goblin"};
        int randomI = (int) ((Math.random()*(enemies.length)));
        String enemy = enemies[randomI];
        return enemy;
    }

    public void setCell(String event) {
        switch (event) {
            case "neutral":
                System.out.println("You entered a boring looking room");
                break;
            case "loot":
                String loot = setLoot();
                System.out.println("You just found a " + loot + " !");
                break;
            case "enemy":
                String enemy = setEnemy();
                System.out.println("You are facing a blood-thirsty " + enemy + " !");
                break;
        }
    }
}
