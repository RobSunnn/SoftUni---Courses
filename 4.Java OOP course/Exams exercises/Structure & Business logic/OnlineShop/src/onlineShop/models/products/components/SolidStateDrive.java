package onlineShop.models.products.components;

public class SolidStateDrive extends BaseComponent {


    public SolidStateDrive(int id, String manufacturer, String model, double price,
                           double overallPerformance, int generation) {
        super(id, manufacturer, model, price, overallPerformance * 1.20, generation);
    }
}
