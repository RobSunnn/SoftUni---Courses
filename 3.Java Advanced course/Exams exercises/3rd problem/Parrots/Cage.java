package parrots;

import java.util.ArrayList;
import java.util.List;

public class Cage {
    private String name;
    private int capacity;
    private List<Parrot> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Parrot parrot) {
        if (this.data.size() + 1 <= getCapacity()) {
            this.data.add(parrot);
        }
    }

    public boolean remove(String name) {
        for (Parrot parrot : this.data) {
            if (parrot.getName().equals(name)) {
                this.data.remove(parrot);
                return true;
            }
        }
        return false;
    }

    public Parrot sellParrot(String name) {
        Parrot parrotToReturn = null;
        for (Parrot parrot : this.data) {
            if (parrot.getName().equals(name)) {

                parrotToReturn = parrot;
                parrot.setAvailable(false);
                break;
            }
        }
        return parrotToReturn;
    }

    public List<Parrot> sellParrotBySpecies(String species) {
        List<Parrot> list = new ArrayList<>();

        for (Parrot parrot : this.data) {
            if (parrot.getSpecies().equals(species) && parrot.isAvailable()) {
                parrot.setAvailable(false);
                list.add(parrot);
            }
        }
        return list;
    }

    public int count() {
        return this.data.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append("Parrots available at").append(" ").append(getName()).append(":").append(System.lineSeparator());
        for (Parrot parrot : this.data) {
            if (parrot.isAvailable()) {
                //Parrot (Arinae): Marlin
                //sb.append("Parrot ").append("(").append(parrot.getSpecies()).append("): ").append(parrot.getName()).append(System.lineSeparator());
                sb.append(parrot).append(System.lineSeparator());
            }
        }
        return sb.toString().trim();
    }
}
