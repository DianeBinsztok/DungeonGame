package gear.offensiveGear;

public class NoOffensiveGear extends OffensiveGear {
    /**
     * Contructor for defensive gear: uses global Gear's constructor
     */
    public NoOffensiveGear() {
        super("None", 0, "none");
    }
}
