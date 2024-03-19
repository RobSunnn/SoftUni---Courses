package InterfacesAndAbstraction.exercise._02_BirthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        List<Birthable> list = new ArrayList<>();

        while (!command.equals("End")) {
            String[] data = command.split("\\s+");

            Birthable birthable = null;
            String name = data[1];

            if (data.length <= 3) {
                if (data[0].equals("Pet")) {
                    String birthDate = data[2];
                    birthable = new Pet(name, birthDate);
                }
            } else {
                int age = Integer.parseInt(data[2]);
                String id = data[3];
                String birthDate = data[4];
                birthable = new Citizen(name, age, id, birthDate);
            }
            if (birthable != null) {
                list.add(birthable);
            }


            command = scanner.nextLine();
        }

        String dateToCheck = scanner.nextLine();

        if (!list.isEmpty()) {
            //  for (Birthable birthable : list) {
            //      if (birthable.getBirthDate().endsWith(dateToCheck)) {
            //          System.out.println(birthable.getBirthDate());
            //      }
            //  }

            list.stream()
                    .map(Birthable::getBirthDate)
                    .filter(e -> e.endsWith(dateToCheck))
                    .forEach(System.out::println);
        }


    }
}
