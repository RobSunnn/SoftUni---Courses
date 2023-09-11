package Inheritance.lab._03_RandomArrayList;

public class Main {
    public static void main(String[] args) {

        RandomArrayList randomArrayList = new RandomArrayList();
        randomArrayList.add(123);
        randomArrayList.add(22);
        randomArrayList.add(23);
        randomArrayList.add(44);
        randomArrayList.add(33);
        randomArrayList.add(69);

        System.out.println(randomArrayList.getRandomElement());
    }
}
