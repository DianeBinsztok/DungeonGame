public class Cell {

    private Event event;

    public Cell(){
        this.event = new Event();
    }

    public void launchCellEvent(){
         event.launchEvent();
    }

}
