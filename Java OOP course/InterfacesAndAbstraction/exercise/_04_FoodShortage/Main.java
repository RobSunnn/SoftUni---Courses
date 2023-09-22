package InterfacesAndAbstraction.exercise._04_FoodShortage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countPersons = Integer.parseInt(scanner.nextLine());

        List<Person> personList = new ArrayList<>();

        for (int persons = 1; persons <= countPersons; persons++) {
            String input = scanner.nextLine();
            String[] data = input.split("\\s+");

            Person person = null;

            String name = data[0];
            int age = Integer.parseInt(data[1]);

            if (data.length < 4) {
                String group = data[2];
                person = new Rebel(name, age, group);

            } else {
                String id = data[2];
                String birthDate = data[3];
                person = new Citizen(name, age, id, birthDate);

            }

            personList.add(person);
        }

        String command = scanner.nextLine();


        while (!command.equals("End")) {
            for (Person person : personList) {
                if (person.getName().equals(command)) {
                    if (person.getClass().getSimpleName().equals("Citizen")) {
                        person.buyFood();

                    } else if (person.getClass().getSimpleName().equals("Rebel")) {
                        person.buyFood();
                    }
                }
            }

            command = scanner.nextLine();
        }

        int food = 0;

        for (Person person : personList) {
            food += person.getFood();
        }
        System.out.println(food);


    }
}
