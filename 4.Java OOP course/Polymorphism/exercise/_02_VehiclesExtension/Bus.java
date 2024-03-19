package Polymorphism.exercise._02_VehiclesExtension;

import java.text.DecimalFormat;

public class Bus extends Vehicle {

    protected Bus(Double fuelQuantity, Double litersPerKilometer, Double tankCapacity) {
        super(fuelQuantity, litersPerKilometer, tankCapacity);
    }

    @Override
    public String drive(Double kilometersToDrive) {

        Double fuelNeeded = kilometersToDrive * (getLitersPerKilometer() + 1.4);
        if (fuelNeeded > this.getFuelQuantity()) {
            return "Bus needs refueling";
        } else {
            DecimalFormat df = new DecimalFormat("#.##");
            setFuelQuantity(this.getFuelQuantity() - fuelNeeded);
            return String.format("Bus travelled %s km", df.format(kilometersToDrive));
        }
    }

    public String driveEmpty(Double kilometersToDrive) {

        Double fuelNeeded = kilometersToDrive * getLitersPerKilometer();
        if (fuelNeeded > this.getFuelQuantity()) {
            return "Bus needs refueling";
        } else {
            DecimalFormat df = new DecimalFormat("#.##");
            setFuelQuantity(this.getFuelQuantity() - fuelNeeded);
            return String.format("Bus travelled %s km", df.format(kilometersToDrive));
        }
    }

    @Override
    public void refuel(Double fuel) {
        if (getFuelQuantity() + fuel > this.getTankCapacity()) {
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
        return String.format("Bus: %.2f", this.getFuelQuantity());
    }
}
