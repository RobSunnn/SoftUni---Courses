package onlineShop.models.products.components;

public class RandomAccessMemory extends BaseComponent {


    public RandomAccessMemory(int id, String manufacturer, String model, double price,
                              double overallPerformance, int generation) {
        super(id, manufacturer, model, price, overallPerformance * 1.20, generation);
    }
}
