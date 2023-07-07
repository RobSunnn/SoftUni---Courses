package easterRaces.entities.cars;

import easterRaces.common.ExceptionMessages;

public abstract class BaseCar implements Car {

    private String model;
    private int horsePower;
    private double cubicCentimeters;
    private double racePoints;


    protected BaseCar(String model, int horsePower, double cubicCentimeters) {
        this.setModel(model);
        this.setHorsePower(horsePower);
        this.cubicCentimeters = cubicCentimeters;
        this.racePoints = 0;
    }

    private void setModel(String model) {
        if (model == null || model.trim().isEmpty() || model.length() < 4) {
            throw new IllegalArgumentException
                    (String.format(ExceptionMessages.INVALID_MODEL, model, 4));
        }
        this.model = model;
    }

    protected void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public int getHorsePower() {
        return this.horsePower;
    }

    @Override
    public double getCubicCentimeters() {
        return this.cubicCentimeters;
    }

    @Override
    public double calculateRacePoints(int laps) {
        this.racePoints = (this.cubicCentimeters / this.horsePower) * laps;
        return racePoints;
    }

    @Override
    public double getRacePoints() {
        return this.racePoints;
    }
}
