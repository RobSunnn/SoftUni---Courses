package Encaplsulation.lab._02_SalaryIncrease;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countPersons = Integer.parseInt(scanner.nextLine());

        List<Person> personList = new ArrayList<>();

        for (int persons = 1; persons <= countPersons; persons++) {
            String[] personsInput = scanner.nextLine().split(" ");
            String firstName = personsInput[0];
            String lastName = personsInput[1];
            int age = Integer.parseInt(personsInput[2]);
            double salary = Double.parseDouble(personsInput[3]);

            Person person = new Person(firstName, lastName, age, salary);

            personList.add(person);

        }

        double percentBonus = Double.parseDouble(scanner.nextLine());

        personList.forEach(person -> person.increaseSalary(percentBonus));
        {
            personList.forEach(System.out::println);
        }


    }
}
