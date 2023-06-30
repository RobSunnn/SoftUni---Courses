package aquarium.entities.fish;

public class SaltwaterFish extends BaseFish{

    public SaltwaterFish(String name, String species, double price) {
        super(name, species, price);
        this.setSize(5);
    }

    @Override
    public void eat() {
        this.setSize(this.getSize() + 2);
    }
}
