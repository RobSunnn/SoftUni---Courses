package Inheritance.lab._04_StackOfStrings;

import java.util.ArrayList;

public class StackOfStrings extends ArrayList<String> {

    private ArrayList<String> data;

    public StackOfStrings() {
        this.data = new ArrayList<>();
    }

    public void push(String string) {
        this.data.add(string);
    }


    public String pop() {
        return this.data.remove(this.data.size() - 1);
    }

    public String peek() {
        return this.data.get(this.data.size() - 1);
    }
}
