package handball.entities.equipment;

public class Kneepad extends BaseEquipment {

    private static final int KNEE_PAD_PROTECTION = 120;
    private static final double KNEE_PAD_PRICE = 15;


    public Kneepad() {
        super(KNEE_PAD_PROTECTION, KNEE_PAD_PRICE);
    }
}
