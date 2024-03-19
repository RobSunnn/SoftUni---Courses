package Polymorphism.exercise._02_VehiclesExtension;

import java.text.DecimalFormat;

public class Truck extends Vehicle {

    public Truck(Double fuelQuantity, Double litersPerKilometer, Double tankCapacity) {
        super(fuelQuantity, litersPerKilometer, tankCapacity);
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
        if (this.getFuelQuantity() + fuel > this.getTankCapacity()) {
            System.out.println("Cannot fit fuel in tank");
        } else {
            if (fuel <= 0) {
                System.out.println("Fuel must be a positive number");
            } else {
                this.setFuelQuantity(getFuelQuantity() + fuel);
            }
        }


    }

    @Override
    public String toString() {
        return String.format("Truck: %.2f", this.getFuelQuantity());
    }
}
