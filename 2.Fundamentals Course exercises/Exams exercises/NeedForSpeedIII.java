package fundamentals.exams;

import java.util.*;

public class NeedForSpeedIII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCars = Integer.parseInt(scanner.nextLine());
        Map<String, List<Integer>> cars = new LinkedHashMap<>();

        for (int i = 1; i <= numberOfCars; i++) {
            String[] data = scanner.nextLine().split("\\|");
            String model = data[0];
            int mileage = Integer.parseInt(data[1]);
            int fuel = Integer.parseInt(data[2]);

            if (!cars.containsKey(model)) {
                cars.put(model, new ArrayList<>());
            }
            cars.get(model).add(0, mileage);
            cars.get(model).add(1, fuel);
        }

        String input = scanner.nextLine();

        while (!input.equals("Stop")) {
            String[] data = input.split(" : ");
            String command = data[0];
            String car = data[1];

            switch (command) {
                case "Drive":
                    int distance = Integer.parseInt(data[2]);
                    int fuelNeeded = Integer.parseInt(data[3]);
                    int fuelInTank = cars.get(car).get(1);
                    if (fuelNeeded > fuelInTank) {
                        System.out.println("Not enough fuel to make that ride");
                        break;
                    } else {
                        int currentMileage = cars.get(car).get(0);
                        cars.get(car).set(0, currentMileage + distance);
                        cars.get(car).set(1, fuelInTank - fuelNeeded);
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", car, distance, fuelNeeded);
                        if (cars.get(car).get(0) >= 100_000) {
                            cars.remove(car);
                            System.out.printf("Time to sell the %s!%n", car);
                        }
                    }

                    break;
                case "Refuel":
                    int fuelToRefill = Integer.parseInt(data[2]);
                    int currentFuelInTank = cars.get(car).get(1);
                    if (currentFuelInTank + fuelToRefill > 75) {
                        cars.get(car).set(1, 75);
                        System.out.printf("%s refueled with %d liters%n", car, 75 - currentFuelInTank);
                    } else {
                        cars.get(car).set(1, currentFuelInTank + fuelToRefill);
                        System.out.printf("%s refueled with %d liters%n", car, fuelToRefill);
                    }
                    break;
                case "Revert":
                    int kilometersToRevert = Integer.parseInt(data[2]);
                    int currentMileage = cars.get(car).get(0);

                    if (currentMileage - kilometersToRevert < 10_000) {
                        cars.get(car).set(0, 10_000);
                    } else {
                        cars.get(car).set(0, currentMileage - kilometersToRevert);
                        System.out.printf("%s mileage decreased by %d kilometers%n", car, kilometersToRevert);
                    }

                    break;
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, List<Integer>> entry : cars.entrySet()) {
            System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n",
                    entry.getKey(), entry.getValue().get(0), entry.getValue().get(1));
        }

    }
}
