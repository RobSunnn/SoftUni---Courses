package vetClinic;

import java.util.ArrayList;
import java.util.List;

public class Clinic {
    private int capacity;
    private List<Pet> data;

    public Clinic(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Pet> getData() {
        return data;
    }

    public void add(Pet pet) {
        if (this.data.size() + 1 <= this.capacity) {
            this.data.add(pet);
        }
    }

    public boolean remove(String name) {
        if (this.data.size() > 0) {
            for (Pet pet : this.data) {
                if (pet.getName().equals(name)) {
                    this.data.remove(pet);
                    return true;
                }
            }
        }
        return false;

    }

    public Pet getPet(String name, String owner) {
        Pet petToReturn = null;
        if (this.data.size() > 0) {
            for (Pet pet : this.data) {
                if (pet.getName().equals(name) && pet.getOwner().equals(owner)) {
                    petToReturn = pet;
                }

            }
        }
        return petToReturn;
    }

    public Pet getOldestPet() {
        Pet petToReturn = null;
        int age = -1;

        if (this.data.size() > 0) {
            for (Pet pet : this.data) {
                if (pet.getAge() > age) {
                    age = pet.getAge();
                    petToReturn = pet;
                }
            }
        }
        return petToReturn;
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("The clinic has the following patients:").append(System.lineSeparator());
        for (Pet pet : this.data) {
            sb.append(pet.getName()).append(" ").append(pet.getOwner()).append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
