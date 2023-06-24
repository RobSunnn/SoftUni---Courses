import java.util.ArrayList;
import java.util.List;

public class Habitat {

    private List<Elephant> data;
    private int capacity;

    public Habitat(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public List<Elephant> getData() {
        return data;
    }

    public void setData(List<Elephant> data) {
        this.data = data;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }


    public void add(Elephant elephant) {
        if (this.data.size() + 1 <= this.capacity) {
            this.data.add(elephant);
        }

    }

    public boolean remove(String name) {
        for (Elephant elephant : this.data) {
            if (elephant.getName().equals(name)) {
                this.data.remove(elephant);
                return true;
            }

        }
        return false;
    }

    public Elephant getElephant(String retiredFrom) {
        for (Elephant elephant : this.data) {
            if (elephant.getRetiredFrom().equals(retiredFrom)) {
                return elephant;
            }
        }

        return null;
    }

    public Elephant getOldestElephant() {
        Elephant elephant = null;
        int age = -1;

        for (Elephant el : this.data) {
            if (el.getAge() > age) {
                age = el.getAge();
                elephant = el;
            }
        }
        return elephant;
    }

    public int getAllElephants() {
        return this.data.size();
    }

    public String getReport() {
        StringBuilder sb = new StringBuilder();
        sb.append("Saved elephants in the park:").append(System.lineSeparator());
        for (Elephant elephant : this.data) {
            sb.append(elephant.getName()).append(" ").append("came from: ").append(elephant.getRetiredFrom()).append(System.lineSeparator());
        }
        return sb.toString();
    }

}
