package Polymorphism.lab._04_WildFarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputLine = scanner.nextLine();

        List<Animal> animalList = new ArrayList<>();

        while (!inputLine.equals("End")) {
            String[] infoAboutAnimal = inputLine.split("\\s+");
            String animalType = infoAboutAnimal[0];
            String animalName = infoAboutAnimal[1];
            Double animalWeight = Double.parseDouble(infoAboutAnimal[2]);
            String livingRegion = infoAboutAnimal[3];

            inputLine = scanner.nextLine();
            String[] foodInfo = inputLine.split("\\s+");
            Food food = null;
            if (foodInfo[0].equals("Vegetable")) {
                food = new Vegetable(Integer.parseInt(foodInfo[1]));
            } else if (foodInfo[0].equals("Meat")) {
                food = new Meat(Integer.parseInt(foodInfo[1]));
            }


            switch (animalType) {
                case "Cat":
                    String breed = infoAboutAnimal[4];
                    Cat cat = new Cat(animalName, animalType, animalWeight, livingRegion, breed);
                    cat.makeSound();
                    cat.eat(food);
                    animalList.add(cat);
                    break;
                case "Tiger":
                    Tiger tiger = new Tiger(animalName, animalType, animalWeight, livingRegion);
                    tiger.makeSound();
                    tiger.eat(food);
                    animalList.add(tiger);
                    break;
                case "Zebra":
                    Zebra zebra = new Zebra(animalName, animalType, animalWeight, livingRegion);
                    zebra.makeSound();
                    zebra.eat(food);
                    animalList.add(zebra);
                    break;
                case "Mouse":
                    Mouse mouse = new Mouse(animalName, animalType, animalWeight, livingRegion);
                    mouse.makeSound();
                    mouse.eat(food);
                    animalList.add(mouse);
                    break;

            }


            inputLine = scanner.nextLine();
        }

        animalList.forEach(System.out::println);
    }
}
