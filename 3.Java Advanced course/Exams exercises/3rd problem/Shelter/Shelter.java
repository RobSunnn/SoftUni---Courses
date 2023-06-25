package shelter;

import java.util.ArrayList;
import java.util.List;

public class Shelter {
    private List<Animal> data;
    private int capacity;

    public Shelter(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Animal> getData() {
        return data;
    }

    public void setData(List<Animal> data) {
        this.data = data;
    }


    public void add(Animal animal) {
        if (this.data.size() + 1 <= getCapacity()) {
            getData().add(animal);
        }
    }

    public boolean remove(String name) {
        for (Animal animal : this.data) {
            if (animal.getName().equals(name)) {
                getData().remove(animal);
                return true;
            }
        }

        return false;
    }

    public Animal getAnimal(String name, String caretaker) {
        for (Animal animal : getData()) {
            if (animal.getName().equals(name) && animal.getCaretaker().equals(caretaker)) {
                return animal;
            }
        }
        return null;
    }

    public Animal getOldestAnimal() {
        Animal animal = null;
        int age = -1;

        for (Animal animal1 : getData()) {
            if (animal1.getAge() > age) {
                age = animal1.getAge();
                animal = animal1;
            }
        }
        return animal;
    }

    public int getCount() {
        return getData().size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("The shelter has the following animals:").append(System.lineSeparator());
        for (Animal animal : this.data) {
            sb.append(animal.getName()).append(" ").append(animal.getCaretaker()).append(System.lineSeparator());
        }

        return sb.toString();
    }
}
