package fairyShop.models.Helpers;

public class Sleepy extends BaseHelper {
    private static final int INITIAL_ENERGY = 50;

    public Sleepy(String name) {
        super(name, INITIAL_ENERGY);
    }

    @Override
    public void work() {
        setEnergy(getEnergy() - 5);
        if (getEnergy() < 0) {
            setEnergy(0);
        }
    }
}
