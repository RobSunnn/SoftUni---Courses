package InterfacesAndAbstraction.lab._03_BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Identifiable> identifiableList = new ArrayList<>();

        while (!input.equals("End")) {
            String[] inputData = input.split("\\s+");

            Identifiable identifiable = null;
            if (inputData.length == 2) {
                identifiable = new Robot(inputData[0], inputData[1]);

            } else if (inputData.length == 3) {
                identifiable = new Citizen(inputData[0],
                        Integer.parseInt(inputData[1]), inputData[2]);
            }

            identifiableList.add(identifiable);

            input = scanner.nextLine();
        }

        String idToDetain = scanner.nextLine();

        identifiableList.stream()
                .map(Identifiable::getId)
                .filter(id -> id.endsWith(idToDetain))
                .forEach(System.out::println);


    }
}
