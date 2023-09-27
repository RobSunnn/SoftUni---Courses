package solid.Calculators;

import solid.Interfaces.Product;

import java.util.List;

public class CalorieCalculator implements Calculator {
    @Override
    public double total(List<Product> products) {
        return products.stream().mapToDouble(Product::getCalories).sum();
    }

    @Override
    public double average(List<Product> products) {
        return total(products) / products.size();
    }


}
