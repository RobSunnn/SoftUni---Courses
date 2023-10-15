package Inheritance.lab._03_RandomArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList extends ArrayList<Object> {

    public Object getRandomElement() {
        Random random = new Random();
        int index = random.nextInt(this.size());
        return remove(index);
    }

}
