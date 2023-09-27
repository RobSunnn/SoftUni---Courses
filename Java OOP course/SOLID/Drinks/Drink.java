package solid.Drinks;

import solid.Interfaces.Product;

public abstract class Drink implements Product {

    private double milliliters;

    private double caloriesPer100grams;
    private double density;

    public Drink(double milliliters, double caloriesPer100grams, double density) {
        this.milliliters = milliliters;
        this.caloriesPer100grams = caloriesPer100grams;
        this.density = density;
    }

    @Override
    public double getCalories() {
        double grams = milliliters * density;
        return (caloriesPer100grams / 100) * grams;
    }

    public double getLiters() {
        return milliliters / 1000;
    }

    @Override
    public double getKilograms() {
        return getLiters() * density;
    }

}
