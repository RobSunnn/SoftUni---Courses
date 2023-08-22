package Encaplsulation.lab._04_FirstAndReserveTeam;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countPersons = Integer.parseInt(scanner.nextLine());

        Team team = new Team("Black Eagles");

        for (int persons = 1; persons <= countPersons; persons++) {
            String[] personsInput = scanner.nextLine().split(" ");
            String firstName = personsInput[0];
            String lastName = personsInput[1];
            int age = Integer.parseInt(personsInput[2]);
            double salary = Double.parseDouble(personsInput[3]);

            Person person = new Person(firstName, lastName, age, salary);

            team.addPlayer(person);
        }


        System.out.printf("First team have %d players%n", team.getFirstTeam().size());
        System.out.printf("Reserve team have %d players%n", team.getReserveTeam().size());

    }
}