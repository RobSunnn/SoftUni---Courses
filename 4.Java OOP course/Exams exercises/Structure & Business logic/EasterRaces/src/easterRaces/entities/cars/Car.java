package easterRaces.entities.cars;

public interface Car {
    String getModel();

    int getHorsePower();

    double getCubicCentimeters();

    void calculateRacePoints(int laps);
    double getRacePoints();
}
