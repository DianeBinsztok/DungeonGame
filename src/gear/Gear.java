package gear;

public class Gear {
    private String name;

    private int stat;


    public Gear(String name, int stat){
        this.name = name;
        this.stat = stat;
    }

    public String getName(){
        return this.name;
    }

    public int getStat(){
        return this.stat;
    }
}
