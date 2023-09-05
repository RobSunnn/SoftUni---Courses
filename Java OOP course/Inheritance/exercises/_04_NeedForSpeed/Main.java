package Inheritance.exercise._04_NeedForSpeed;

public class Main {
    public static void main(String[] args) {

        SportCar sportCar = new SportCar(100, 200);

        sportCar.drive(5);

        System.out.println(sportCar.getFuel());

        Vehicle vehicle = new Vehicle(100, 200);

        vehicle.drive(5);

        System.out.println(vehicle.getFuel());

        RaceMotorcycle raceMotorcycle = new RaceMotorcycle(100, 200);

        raceMotorcycle.drive(10);

        System.out.println(raceMotorcycle.getFuel());

    }
}
