package fundamentals.exams;

import java.util.Scanner;

public class WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String destinations = scanner.nextLine();
        StringBuilder destinationsBuilder = new StringBuilder(destinations);

        String commandInput = scanner.nextLine();

        while (!commandInput.equals("Travel")) {
            String command = commandInput.split(":")[0];

            if (command.equals("Add Stop")) {
                int index = Integer.parseInt(commandInput.split(":")[1]);
                String toInsert = commandInput.split(":")[2];

                if (isValidIndex(index, destinationsBuilder)) {
                    destinationsBuilder.insert(index, toInsert);
                }
                System.out.println(destinationsBuilder);

            } else if (command.equals("Remove Stop")) {
                int firstIndex = Integer.parseInt(commandInput.split(":")[1]);
                int secondIndex = Integer.parseInt(commandInput.split(":")[2]);
                if (isValidIndex(firstIndex, destinationsBuilder) && isValidIndex(secondIndex, destinationsBuilder)) {
                    destinationsBuilder.delete(firstIndex, secondIndex + 1);
                }
                System.out.println(destinationsBuilder);
            } else if (command.equals("Switch")) {
                String oldString = commandInput.split(":")[1];
                String newString = commandInput.split(":")[2];
                if (destinationsBuilder.toString().contains(oldString)) {
                    destinationsBuilder = new StringBuilder(destinationsBuilder.toString().replace(oldString, newString));
                }
                System.out.println(destinationsBuilder);

            }


            commandInput = scanner.nextLine();
        }
        System.out.printf("Ready for world tour! Planned stops: %s%n", destinationsBuilder);

    }

    private static boolean isValidIndex(int n, StringBuilder text) {
        return n >= 0 && n <= text.length() - 1;
    }
}
