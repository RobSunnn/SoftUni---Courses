package easterRaces.entities.cars;

import easterRaces.common.ExceptionMessages;

public class SportsCar extends BaseCar {

    private static final double INITIAL_CUBIC_CENTIMETERS = 3000;

    public SportsCar(String model, int horsePower) {
        super(model, horsePower, INITIAL_CUBIC_CENTIMETERS);
        this.setHorsePower(horsePower);
    }

    @Override
    public void setHorsePower(int horsePower) {
        if (horsePower < 250 || horsePower > 450) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_HORSE_POWER, horsePower));
        }
        super.setHorsePower(horsePower);
    }
}
