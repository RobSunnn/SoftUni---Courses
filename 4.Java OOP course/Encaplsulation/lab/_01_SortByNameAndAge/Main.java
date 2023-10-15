package Encaplsulation.lab._01_SortByNameAndAge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countPersons = Integer.parseInt(scanner.nextLine());

        List<Person> personList = new ArrayList<>();

        for (int persons = 0; persons < countPersons; persons++) {
            String[] inputData = scanner.nextLine().split(" ");
            String firstName = inputData[0];
            String lastName = inputData[1];
            int age = Integer.parseInt(inputData[2]);

            Person person = new Person(firstName, lastName, age);

            personList.add(person);
        }

        Collections.sort(personList, (firstPerson, secondPerson) -> {
            int result = firstPerson.getFirstName().compareTo(secondPerson.getFirstName());

            if (result != 0) {
                return result;
            }

            return Integer.compare(firstPerson.getAge(), secondPerson.getAge());


        });

        personList.stream().forEach(person -> System.out.println(person));


    }
}
