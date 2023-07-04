package christmasPastryShop.entities.delicacies;

public class Stolen extends BaseDelicacy {
    private static final double STOLEN_PORTION = 250.0;

    public Stolen(String name, double price) {
        super(name, STOLEN_PORTION, price);
    }
}
