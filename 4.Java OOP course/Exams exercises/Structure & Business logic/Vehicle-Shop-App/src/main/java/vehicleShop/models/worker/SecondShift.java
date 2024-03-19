package vehicleShop.models.worker;

public class SecondShift extends BaseWorker{

    public SecondShift(String name) {
        super(name, 70);
    }

    @Override
    public void working() {
        setStrength(getStrength() - 15);
        if (getStrength() < 0) {
            setStrength(0);
        }
    }
}
