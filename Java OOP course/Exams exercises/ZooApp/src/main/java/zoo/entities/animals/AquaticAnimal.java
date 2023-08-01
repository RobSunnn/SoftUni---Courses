package zoo.entities.animals;

public class AquaticAnimal extends BaseAnimal {
    private static final double INITIAL_KILOGRAMS = 2.50;

    public AquaticAnimal(String name, String kind, double price) {
        super(name, kind, INITIAL_KILOGRAMS, price);
    }

    @Override
    public void eat() {
        double newKilograms = getKg() + 7.50;
        this.setKg(newKilograms);
    }
}
