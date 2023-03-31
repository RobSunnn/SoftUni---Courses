package fundamentals.P19.ObjectsAndClasses.Exercise;

import com.sun.source.tree.BreakTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P05VehicleCatalogue {

    public static class Cars {
        String model;
        String color;
        double horsePower;

        public Cars(String model, String color, double horsePower) {
            this.model = model;
            this.color = color;
            this.horsePower = horsePower;
        }

        public String getModel() {
            return model;
        }

        public String getColor() {
            return color;
        }

        public double getHorsePower() {
            return horsePower;
        }

    }

    public static class Trucks {
        String model;
        String color;
        double horsePower;

        public Trucks(String model, String color, double horsePower) {
            this.model = model;
            this.color = color;
            this.horsePower = horsePower;
        }

        public String getModel() {
            return model;
        }

        public String getColor() {
            return color;
        }

        public double getHorsePower() {
            return horsePower;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputLine = scanner.nextLine();
        List<Cars> carsList = new ArrayList<>();
        List<Trucks> trucksList = new ArrayList<>();

        while (!inputLine.equals("End")) {
            String[] inputLineArr = inputLine.split(" ");
            String typeOfVehicle = inputLineArr[0];
            String model = inputLineArr[1];
            String color = inputLineArr[2];
            double horsePower = Double.parseDouble(inputLineArr[3]);

            switch (typeOfVehicle) {
                case "car":

                    Cars currentCar = new Cars(model, color, horsePower);
                    carsList.add(currentCar);

                    break;
                case "truck":

                    Trucks currentTruck = new Trucks(model, color, horsePower);
                    trucksList.add(currentTruck);
                    break;
            }

            inputLine = scanner.nextLine();
        }

        String type = scanner.nextLine();
        while (!type.equals("Close the Catalogue")) {
            String model = type;

            for (Cars cars : carsList) {
                if (cars.getModel().equals(model)) {
                    System.out.println("Type: Car");
                    System.out.printf("Model: %s%n", cars.getModel());
                    System.out.printf("Color: %s%n", cars.getColor());
                    System.out.printf("Horsepower: %.0f%n", cars.getHorsePower());
                    break;
                }
            }

            for (Trucks trucks : trucksList) {
                if (trucks.getModel().equals(model)) {
                    System.out.println("Type: Truck");
                    System.out.printf("Model: %s%n", trucks.getModel());
                    System.out.printf("Color: %s%n", trucks.getColor());
                    System.out.printf("Horsepower: %.0f%n", trucks.getHorsePower());
                    break;
                }
            }

            type = scanner.nextLine();
        }

        double totalHorsePowerCars = 0.0;

        for (Cars cars : carsList) {
            totalHorsePowerCars += cars.getHorsePower();
        }
        double averageCars = totalHorsePowerCars / carsList.size();

        double totalHorsePowerTrucks = 0.0;

        for (Trucks trucks : trucksList) {
            totalHorsePowerTrucks += trucks.getHorsePower();
        }
        double averageTrucks = totalHorsePowerTrucks / trucksList.size();

        if (averageCars > 0) {
            System.out.printf("Cars have average horsepower of: %.2f.%n", averageCars);
        } else {
            System.out.println("Cars have average horsepower of: 0.00.");
        }

        if (averageTrucks > 0) {
            System.out.printf("Trucks have average horsepower of: %.2f.%n", averageTrucks);
        } else {
            System.out.println("Trucks have average horsepower of: 0.00.");
        }


    }
}
