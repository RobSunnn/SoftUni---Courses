package P09FunctionalProgramming.lab.exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P10PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> people = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        String commandInput = scanner.nextLine();

        while (!commandInput.equals("Party!")) {
            String[] commandLine = commandInput.split("\\s+");
            String command = commandLine[0];
            String type = commandLine[1];
            String toDo = commandLine[2];

            switch (command) {

                case "Double":
                    switch (type) {

                        case "StartsWith":
                            List<String> names = people.stream().filter(name -> name.startsWith(toDo)).collect(Collectors.toList());
                            for (int i = 0; i < names.size(); i++) {
                                people.add(names.get(i));
                            }
                            break;
                        case "EndsWith":

                            List<String> namesEndsWith = people.stream().filter(name -> name.endsWith(toDo)).collect(Collectors.toList());
                            for (int i = 0; i < namesEndsWith.size(); i++) {
                                people.add(namesEndsWith.get(i));
                            }
                            break;
                        case "Length":

                            List<String> namesLength = people.stream().filter(name -> name.length() == (Integer.parseInt(toDo))).collect(Collectors.toList());
                            for (int i = 0; i < namesLength.size(); i++) {
                                people.add(namesLength.get(i));
                            }
                            break;

                    }

                    break;
                case "Remove":
                    switch (type) {
                        case "Length":

                            people = people.stream().filter(name -> name.length() != (Integer.parseInt(toDo))).collect(Collectors.toList());
                            break;
                        case "StartsWith":
                            people = people.stream().filter(name -> !name.startsWith(toDo)).collect(Collectors.toList());
                            break;
                        case "EndsWith":
                            people = people.stream().filter(name -> !name.endsWith(toDo)).collect(Collectors.toList());
                            break;

                    }
                    break;
            }


            commandInput = scanner.nextLine();
        }

        Collections.sort(people);
        if (people.size() < 1) {

            System.out.println("Nobody is going to the party!");
        } else {

            System.out.printf("%s are going to the party!", String.join(", ", people));
        }


    }
}
