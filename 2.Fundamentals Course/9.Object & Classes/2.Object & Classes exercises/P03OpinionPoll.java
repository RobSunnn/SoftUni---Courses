package fundamentals.P19.ObjectsAndClasses.Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P03OpinionPoll {
    public static class Person {
        String name;
        int age;

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }


    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int people = Integer.parseInt(scanner.nextLine());
        List<Person> personList = new ArrayList<>();

        for (int i = 1; i <= people; i++) {
            String[] inputArr = scanner.nextLine().split(" ");
            String name = inputArr[0];
            int age = Integer.parseInt(inputArr[1]);

            Person person = new Person(name, age);

            if (age > 30) {
                personList.add(person);
            }
        }
        for (Person person : personList) {
            System.out.printf("%s - %d%n", person.getName(), person.getAge());
        }
    }
}
