package Polymorphism.exercise._01_Vehicles;

public abstract class Vehicle {
    private Double fuelQuantity;
    private Double litersPerKilometer;

    protected Vehicle(Double fuelQuantity, Double litersPerKilometer) {
        setFuelQuantity(fuelQuantity);
        setLitersPerKilometer(litersPerKilometer);
    }

    public Double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(Double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public Double getLitersPerKilometer() {
        return litersPerKilometer;
    }

    public void setLitersPerKilometer(Double litersPerKilometer) {
        this.litersPerKilometer = litersPerKilometer;
    }

    public abstract String drive(Double kilometersToDrive);

    public abstract void refuel(Double fuel);

}
