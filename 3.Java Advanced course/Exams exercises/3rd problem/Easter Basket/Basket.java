package easterBasket;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private String material;
    private int capacity;
    private List<Egg> data;

    public Basket(String material, int capacity) {
        this.material = material;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getMaterial() {
        return this.material;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public List<Egg> getData() {
        return this.data;
    }

    public void addEgg(Egg egg) {
        if (getData().size() + 1 <= getCapacity()) {
            getData().add(egg);
        }
    }

    public boolean removeEgg(String color) {
        for (Egg egg : getData()) {

            if (egg.getColor().equals(color)) {
                getData().remove(egg);
                return true;
            }
        }
        return false;
    }

    public Egg getStrongestEgg() {
        int strength = Integer.MIN_VALUE;
        Egg eggToReturn = null;

        if (getData().size() > 0) {
            for (Egg egg : getData()) {
                if (egg.getStrength() > strength) {
                    strength = egg.getStrength();
                    eggToReturn = egg;
                }
            }
        } else {
            return null;
        }
        return eggToReturn;
    }

    public Egg getEgg(String color) {
        Egg eggToReturn = null;
        for (Egg egg : getData()) {
            if (egg.getColor().equals(color)) {
                eggToReturn = egg;

            }
        }
        return eggToReturn;
    }

    public int getCount() {
        return getData().size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(getMaterial()).append(" ").append("basket contains:").append(System.lineSeparator());
        for (Egg egg : this.data) {
            sb.append(egg).append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
