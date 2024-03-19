package handball.entities.equipment;

public abstract class BaseEquipment implements Equipment {

    private int protection;

    private double price;

    protected BaseEquipment(int protection, double price) {
        this.protection = protection;
        this.price = price;
    }

    @Override
    public int getProtection() {
        return this.protection;
    }

    @Override
    public double getPrice() {
        return this.price;
    }
}
