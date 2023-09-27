package solid.Calculators;

import solid.Interfaces.Product;

import java.util.List;

public class WeightCalculator implements Calculator {
    @Override
    public double total(List<Product> productList) {
        return productList.stream().mapToDouble(Product::getKilograms).sum();
    }

    @Override
    public double average(List<Product> products) {
        return total(products) / products.size();
    }

}
