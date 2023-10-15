package catHouse.entities.houses;

public class ShortHouse extends BaseHouse {

    private static final int HOUSE_CAPACITY = 15;

    public ShortHouse(String name) {
        super(name, HOUSE_CAPACITY);
    }
}
