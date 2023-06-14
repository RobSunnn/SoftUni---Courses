package easterBasket;

public class Egg {
    private String color;
    private int strength;
    private String shape;

    public Egg(String color, int strength, String shape) {
        this.color = color;
        this.strength = strength;
        this.shape = shape;
    }

    public String getColor() {
        return this.color;
    }

    public int getStrength() {
        return this.strength;
    }

    public String getShape() {
        return this.shape;
    }


    @Override
    public String toString() {
        //Green egg with 9 strength, pointy shape
        return String.format("%s egg, with %d strength and %s shape.", getColor(), getStrength(), getShape());
    }
}
