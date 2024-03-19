package InterfacesAndAbstraction.lab._01_CarShop;

public class CarImpl implements Car {

    private String model;
    private String color;
    private Integer horsePower;
    private String countryProduced;

    protected CarImpl(String model, String color, Integer horsePower, String countryProduced) {
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
        this.countryProduced = countryProduced;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public Integer getHorsePower() {
        return horsePower;
    }

    @Override
    public String countryProduced() {
        return countryProduced;
    }

    public String toString() {
        return String.format("%s is %s color and have %d horse power%n" +
                        "This is %s produced in %s and have %d tires", getModel(), getColor(), getHorsePower(),
                getModel(), countryProduced(), Car.TIRE);
    }
}
