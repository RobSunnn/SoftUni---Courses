package Polymorphism.exercise._02_VehiclesExtension;

public abstract class Vehicle {
    private Double fuelQuantity;
    private Double litersPerKilometer;

    private Double tankCapacity;

    protected Vehicle(Double fuelQuantity, Double litersPerKilometer, Double tankCapacity) {
        setFuelQuantity(fuelQuantity);
        setLitersPerKilometer(litersPerKilometer);
        setTankCapacity(tankCapacity);
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

    public Double getTankCapacity() {
        return tankCapacity;
    }

    public void setTankCapacity(Double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    public abstract String drive(Double kilometersToDrive);

    public abstract void refuel(Double fuel);

}
