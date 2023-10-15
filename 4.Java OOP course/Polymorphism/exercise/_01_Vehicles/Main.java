package Polymorphism.exercise._01_Vehicles;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] carInput = scanner.nextLine().split("\\s+");
        Vehicle car = new Car(Double.parseDouble(carInput[1]), Double.parseDouble(carInput[2]));
        String[] truckInput = scanner.nextLine().split("\\s+");
        Vehicle truck = new Truck(Double.parseDouble(truckInput[1]), Double.parseDouble(truckInput[2]));

        List<Vehicle> vehicleList = new ArrayList<>();
        vehicleList.add(car);
        vehicleList.add(truck);

        int countCommands = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= countCommands; i++) {
            String[] commandParts = scanner.nextLine().split("\\s+");
            String command = commandParts[0];
            String vehicleType = commandParts[1];

            switch (vehicleType) {

                case "Car":

                    switch (command) {

                        case "Drive":
                            Double kilometersToDrive = Double.parseDouble(commandParts[2]);
                            System.out.println(car.drive(kilometersToDrive));
                            break;
                        case "Refuel":
                            Double litres = Double.parseDouble(commandParts[2]);
                            car.refuel(litres);
                            break;

                    }
                    break;
                case "Truck":

                    switch (command) {
                        case "Drive":
                            Double kilometersToDrive = Double.parseDouble(commandParts[2]);
                            System.out.println(truck.drive(kilometersToDrive));
                            break;
                        case "Refuel":
                            Double litres = Double.parseDouble(commandParts[2]);
                            truck.refuel(litres);
                            break;
                    }

                    break;

            }

        }

        vehicleList.forEach(System.out::println);
    }
}
