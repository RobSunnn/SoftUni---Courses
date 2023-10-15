package fairyShop.models.Presents;

public interface Present {
    String getName();

    int getEnergyRequired();

    boolean isDone();

    void getCrafted();
}
