package groomingSalon;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {
    private List<Pet> data;
    private int capacity;

    public GroomingSalon(int capacity) {
        this.data = new ArrayList<>();
        this.capacity = capacity;
    }

    public void add(Pet pet) {
        if (this.data.size() + 1 <= this.capacity) {
            this.data.add(pet);
        }
    }

    public boolean remove(String name) {
        Pet petToRemove = this.data.stream()
                .filter(pet -> pet.getName().equals(name))
                .findFirst()
                .orElse(null);

        return this.data.remove(petToRemove);
    }

    public Pet getPet(String name, String owner) {

        return this.data.stream()
                .filter(pet -> pet.getName().equals(name) && pet.getOwner().equals(owner))
                .findFirst()
                .orElse(null);
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("The grooming salon has the following clients:")
                .append(System.lineSeparator());
        for (Pet pet : this.data) {
            sb.append(String.format("%s %s", pet.getName(), pet.getOwner()))
                    .append(System.lineSeparator());
        }

        return sb.toString().trim();
    }

}
