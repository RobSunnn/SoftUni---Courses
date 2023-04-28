package P05SetsAndMapsAdvanced.lab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P01ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Set<String> cars = new LinkedHashSet<>();

        while (!input.equals("END")) {
            String[] inputParts = input.split(", ");

            String command = inputParts[0];

            if (command.equals("IN")) {

                cars.add(inputParts[1]);

            } else if (command.equals("OUT")) {

                cars.remove(inputParts[1]);
            }

            input = scanner.nextLine();
        }

        if (cars.isEmpty()) {

            System.out.println("Parking Lot is Empty");

        } else {
            for (String car : cars) {

                System.out.println(car);
            }
        }


    }
}
