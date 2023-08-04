package onlineShop.models.products.computers;

public class Laptop extends BaseComputer {


    public Laptop(int id, String manufacturer, String model, double price) {
        super(id, manufacturer, model, price, 10);
    }
}
