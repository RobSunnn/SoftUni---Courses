package solid.Calculators;

import solid.Interfaces.Product;

import java.util.List;

public interface Calculator {

    double total(List<Product> productList);

    double average(List<Product> products);
}
