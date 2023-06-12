package aquarium;


import java.util.LinkedHashSet;
import java.util.Set;

public class Aquarium {
    private String name;
    private int capacity;
    private int size;
    private Set<Fish> fishInPool;

    public Aquarium(String name, int capacity, int size) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
        this.fishInPool = new LinkedHashSet<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    public int getFishInPool() {
        return fishInPool.size();
    }

    public void add(Fish fish) {

        if (fishInPool.size() + 1 <= this.capacity) {

            this.fishInPool.add(fish);
        }

    }
    public boolean remove(String name) {
        for (Fish fish : this.fishInPool) {

            if (fish.getName().equals(name)) {
                this.fishInPool.remove(fish);
                return true;
            }
        }

        return false;
    }

    public Fish findFish(String name) {
        Fish fishToReturn = null;
        for (Fish fish : this.fishInPool) {

            if (fish.getName().equals(name)) {
                fishToReturn = fish;
            }
        }
        return fishToReturn;
    }


    public String report() {
        StringBuilder builder = new StringBuilder();
        
        builder.append(String.format("Aquarium: %s ^ Size: %d", getName(), getSize())).append(System.lineSeparator());
        for (Fish fish : this.fishInPool) {
            builder.append(fish).append(System.lineSeparator());
        }

        return builder.toString();
    }
}
