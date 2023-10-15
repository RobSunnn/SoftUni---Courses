package Inheritance.exercise._06_animals;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String animalType = scanner.nextLine();

        while (!animalType.equals("Beast!")) {
            String command = scanner.nextLine();
            String[] data = command.split(" ");
            String name = data[0];
            int age = Integer.parseInt(data[1]);
            String gender = data[2];

            switch (animalType) {
                case "Dog":
                    try {
                        Dog dog = new Dog(name, age, gender);
                        System.out.println(dog);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case "Cat":
                    try {
                        Cat cat = new Cat(name, age, gender);
                        System.out.println(cat);

                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "Frog":
                    try {
                        Frog frog = new Frog(name, age, gender);
                        System.out.println(frog);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case "Kitten":
                    try {
                        Kitten kitten = new Kitten(name, age);
                        System.out.println(kitten);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "Tomcat":
                    try {
                        Tomcat tomcat = new Tomcat(name, age);
                        System.out.println(tomcat);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

            }


            animalType = scanner.nextLine();
        }
    }
}
