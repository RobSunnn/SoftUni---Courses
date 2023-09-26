package Polymorphism.exercise._01_Vehicles;

import java.text.DecimalFormat;

public class Car extends Vehicle {


    public Car(Double fuelQuantity, Double litersPerKilometer) {
        super(fuelQuantity, litersPerKilometer);
        this.setLitersPerKilometer(litersPerKilometer + 0.9);
    }


    @Override
    public String drive(Double kilometers) {
        Double fuelNeeded = kilometers * getLitersPerKilometer();
        if (fuelNeeded > this.getFuelQuantity()) {
            return "Car needs refueling";
        } else {
            DecimalFormat df = new DecimalFormat("#.##");
            setFuelQuantity(this.getFuelQuantity() - fuelNeeded);
            return String.format("Car travelled %s km", df.format(kilometers));
        }
    }

    @Override
    public void refuel(Double fuel) {
        this.setFuelQuantity(getFuelQuantity() + fuel);
    }

    @Override
    public String toString() {
        return String.format("Car: %.2f", this.getFuelQuantity());
    }
}
