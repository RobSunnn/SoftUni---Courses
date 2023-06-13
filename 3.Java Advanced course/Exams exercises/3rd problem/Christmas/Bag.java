package christmas;

import java.util.ArrayList;
import java.util.List;

public class Bag {
    private String color;
    private int capacity;
    private List<Present> data;

    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }


    public String getColor() {
        return color;
    }

    public int getCapacity() {
        return capacity;
    }

    public int count() {
        return this.data.size();
    }

    public void add(Present present) {
        if (this.data.size() + 1 <= this.capacity) {
            this.data.add(present);
        }
    }

    public boolean remove(String name) {
        for (Present present : this.data) {
            if (present.getName().equals(name)) {
                this.data.remove(present);
                return true;
            }
        }

        return false;
    }

    public Present heaviestPresent() {
        Present presentToReturn = null;
        double weight = -1.0;
        for (Present present : this.data) {
            if (present.getWeight() > weight) {
                weight = present.getWeight();
                presentToReturn = present;
            }
        }

        return presentToReturn;
    }

    public Present getPresent(String name) {
        Present presentToReturn = null;

        for (Present present : this.data) {
            if (present.getName().equals(name)) {
                presentToReturn = present;
                break;
            }
        }
        return presentToReturn;
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s bag contains:", getColor())).append(System.lineSeparator());
        for (Present present : this.data) {
            sb.append(present).append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
