public class Cell {

    public String setEvent(){
        String[] events= {"neutral","loot","enemy"};
        int randomizeEvent = (int) ((Math.random()*(3)));
        String randomEvent = events[randomizeEvent];
        return randomEvent;
    }
}
