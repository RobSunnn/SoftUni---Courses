package spaceStation.models.astronauts;

public class Biologist extends BaseAstronaut {

    private static final double INITIAL_OXYGEN = 70.0;

    public Biologist(String name) {
        super(name, INITIAL_OXYGEN);
    }

    @Override
    public void breath() {
        double newOxygen = getOxygen() - 5.0;
        if (newOxygen < 0.0) {
            this.setOxygen(0.0);
        } else {
            this.setOxygen(newOxygen);
        }
    }
}
