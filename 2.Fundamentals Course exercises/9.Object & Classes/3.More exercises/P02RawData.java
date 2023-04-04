package More.Exercise.ObjectAndClasses;

import java.util.*;

public class P02RawData {
    public static class Car {
        private String model;
        private Engine engine;
        private Cargo cargo;
        private List<Tire> tires;

        public Car(String model, Engine engine, Cargo cargo) {
            this.model = model;
            this.engine = engine;
            this.cargo = cargo;
            this.tires = new ArrayList<>();
        }

        public String getModel() {
            return model;
        }

        public List<Tire> getTires() {
            return tires;
        }

        public Cargo getCargo() {
            return cargo;
        }

        public Engine getEngine() {
            return engine;
        }
    }

    public static class Engine {
        private int speed;
        private int power;

        public Engine(int speed, int power) {
            this.speed = speed;
            this.power = power;
        }

        public int getPower() {
            return power;
        }
    }

    public static class Cargo {
        private int weight;
        private String type;

        public Cargo(int weight, String type) {
            this.weight = weight;
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }

    public static class Tire {
        private double pressure;
        private int age;

        public Tire(double pressure, int age) {
            this.pressure = pressure;
            this.age = age;
        }

        public double getPressure() {
            return pressure;
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countCommands = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new ArrayList<>();

        for (int i = 1; i <= countCommands; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String carModel = data[0];
            int engineSpeed = Integer.parseInt(data[1]);
            int enginePower = Integer.parseInt(data[2]);
            int cargoWeight = Integer.parseInt(data[3]);
            String cargoType = data[4];
            double firstTirePressure = Double.parseDouble(data[5]);
            int firstTyreAge = Integer.parseInt(data[6]);
            double secondTirePressure = Double.parseDouble(data[7]);
            int secondTyreAge = Integer.parseInt(data[8]);
            double thirdTirePressure = Double.parseDouble(data[9]);
            int thirdTyreAge = Integer.parseInt(data[10]);
            double fourthTirePressure = Double.parseDouble(data[11]);
            int fourthTyreAge = Integer.parseInt(data[12]);

            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            Tire firstTire = new Tire(firstTirePressure, firstTyreAge);
            Tire secondTire = new Tire(secondTirePressure, secondTyreAge);
            Tire thirdTire = new Tire(thirdTirePressure, thirdTyreAge);
            Tire fourthTire = new Tire(fourthTirePressure, fourthTyreAge);

            Car car = new Car(carModel, engine, cargo);
            car.getTires().add(firstTire);
            car.getTires().add(secondTire);
            car.getTires().add(thirdTire);
            car.getTires().add(fourthTire);

            cars.add(car);
        }
        String command = scanner.nextLine();

        if (command.equals("fragile")) {
            for (Car car : cars) {
                if (car.getCargo().getType().equals("fragile")) {
                    for (Tire tire : car.getTires()) {
                        if (tire.getPressure() < 1) {
                            System.out.println(car.getModel());
                            break;
                        }
                    }
                }
            }


        } else if (command.equals("flamable")) {
            for (Car car : cars) {
                if (car.getCargo().getType().equals("flamable") && car.getEngine().getPower() > 250) {
                    System.out.println(car.getModel());
                }
            }

        }


    }


}






