package kindergarten;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Kindergarten {
    private String name;
    private int capacity;
    private List<Child> registry;

    public Kindergarten(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.registry = new ArrayList<>();
    }

    public boolean addChild(Child child) {
        if (this.registry.size() + 1 <= this.capacity) {
            this.registry.add(child);
            return true;
        } else {
            return false;
        }

    }

    public boolean removeChild(String firstName) {
        for (Child child : this.registry) {
            if (child.getFirstName().equals(firstName)) {
                this.registry.remove(child);
                return true;
            }
        }

        return false;
    }

    public int getChildrenCount() {
        return this.registry.size();
    }

    public Child getChild(String firstName) {
        Child childToReturn = null;
        for (Child child : this.registry) {
            if (child.getFirstName().equals(firstName)) {
                childToReturn = child;
                break;
            }
        }

        return childToReturn;
    }


    public String registryReport() {
        StringBuilder sb = new StringBuilder();
        this.registry.sort(Comparator.comparing(Child::getAge)
                .thenComparing(Child::getFirstName)
                .thenComparing(Child::getLastName));
        sb.append(String.format("Registered children in %s:", this.name))
                .append(System.lineSeparator());
        sb.append("--").append(System.lineSeparator());

        for (int i = 0; i < this.registry.size(); i++) {
            sb.append(this.registry.get(i)).append(System.lineSeparator());
            if (i != this.registry.size() - 1) {
                sb.append("--").append(System.lineSeparator());
            }

        }

        return sb.toString().trim();
    }
}
