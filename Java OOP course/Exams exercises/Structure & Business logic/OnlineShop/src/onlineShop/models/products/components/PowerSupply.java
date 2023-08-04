package onlineShop.models.products.components;

public class PowerSupply extends BaseComponent {

    public PowerSupply(int id, String manufacturer, String model, double price,
                       double overallPerformance, int generation) {
        super(id, manufacturer, model, price, overallPerformance * 1.05, generation);
    }
}
