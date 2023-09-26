package Polymorphism.exercise._01_Vehicles;

import java.text.DecimalFormat;

public class Truck extends Vehicle {


    protected Truck(Double fuelQuantity, Double litersPerKilometer) {
        super(fuelQuantity, litersPerKilometer);
        this.setLitersPerKilometer(litersPerKilometer + 1.6);
    }

    @Override
    public String drive(Double kilometersToDrive) {
        Double fuelNeeded = kilometersToDrive * getLitersPerKilometer();
        if (fuelNeeded > this.getFuelQuantity()) {
            return "Truck needs refueling";
        } else {
            DecimalFormat df = new DecimalFormat("#.##");
            setFuelQuantity(this.getFuelQuantity() - fuelNeeded);
            return String.format("Truck travelled %s km", df.format(kilometersToDrive));
        }
    }

    @Override
    public void refuel(Double fuel) {
        fuel = fuel * 0.95;
        this.setFuelQuantity(this.getFuelQuantity() + fuel);
    }

    @Override
    public String toString() {
        return String.format("Truck: %.2f", this.getFuelQuantity());
    }
}
