package christmasPastryShop.entities.delicacies;

public class Gingerbread extends BaseDelicacy {
    private static final double GINGERBREAD_PORTION = 200.0;

    public Gingerbread(String name, double price) {
        super(name, GINGERBREAD_PORTION, price);
    }

}
