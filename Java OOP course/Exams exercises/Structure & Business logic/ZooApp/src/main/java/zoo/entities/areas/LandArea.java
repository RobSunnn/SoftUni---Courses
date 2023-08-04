package zoo.entities.areas;

public class LandArea extends BaseArea {
    private static final int LAND_AREA_CAPACITY = 25;

    public LandArea(String name) {
        super(name, LAND_AREA_CAPACITY);
    }
}
