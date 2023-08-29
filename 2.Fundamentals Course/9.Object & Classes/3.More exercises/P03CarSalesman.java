package More.Exercise.ObjectAndClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P03CarSalesman {
    public static class Car {
        private String model;
        private Engine engine;
        private String weight;
        private String color;

        public Car(String model, Engine engine) {
            this.model = model;
            this.engine = engine;
            this.weight = "n/a";
            this.color = "n/a";
        }

        public String getModel() {
            return model;
        }

        public Engine getEngine() {
            return engine;
        }

        public String getWeight() {
            return weight;
        }

        public String getColor() {
            return color;
        }

        public void setWeight(String weight) {
            this.weight = weight;
        }

        public void setColor(String color) {
            this.color = color;
        }
    }

    public static class Engine {
        private String model;
        private String power;
        private String displacement;
        private String efficiency;

        public Engine(String model, String power) {
            this.model = model;
            this.power = power;
            this.displacement = "n/a";
            this.efficiency = "n/a";
        }

        public String getModel() {
            return model;
        }

        public String getPower() {
            return power;
        }

        public String getDisplacement() {
            return displacement;
        }

        public String getEfficiency() {
            return efficiency;
        }

        public void setDisplacement(String displacement) {
            this.displacement = displacement;
        }

        public void setEfficiency(String efficiency) {
            this.efficiency = efficiency;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countEngines = Integer.parseInt(scanner.nextLine());
        List<Engine> engines = new ArrayList<>();
        List<Car> cars = new ArrayList<>();

        for (int i = 1; i <= countEngines; i++) {
            String[] engineData = scanner.nextLine().split("\\s+");
            String engineModel = engineData[0];
            String enginePower = engineData[1];
            Engine engine = new Engine(engineModel, enginePower);
            if (engineData.length == 3) {
                String data = engineData[2];
                boolean isDataContainsDigit = false;
                for (int j = 0; j < data.length(); j++) {
                    if (Character.isDigit(data.charAt(j))) {
                        isDataContainsDigit = true;
                        break;
                    }
                }
                if (isDataContainsDigit) {
                    engine.setDisplacement(data);
                } else {
                    engine.setEfficiency(data);
                }
            } else if (engineData.length == 4) {
                String dataDisplacement = engineData[2];
                String dataEfficiency = engineData[3];
                boolean isDataDisplacementContainsDigit = false;
                for (int j = 0; j < dataDisplacement.length(); j++) {
                    if (Character.isDigit(dataDisplacement.charAt(j))) {
                        isDataDisplacementContainsDigit = true;
                        break;
                    }
                }
                if (isDataDisplacementContainsDigit) {
                    engine.setDisplacement(dataDisplacement);
                    engine.setEfficiency(dataEfficiency);
                } else {
                    engine.setDisplacement(dataEfficiency);
                    engine.setEfficiency(dataDisplacement);
                }
            }

            engines.add(engine);
        }

        int countCars = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= countCars; i++) {
            String[] carData = scanner.nextLine().split("\\s+");
            String carModel = carData[0];
            String engineModel = carData[1];
            Engine engine = null;
            for (Engine e : engines) {
                if (e.getModel().equals(engineModel)) {
                    engine = e;
                    break;
                }
            }
            Car car = new Car(carModel, engine);

            if (carData.length == 3) {
                String colorOrWeight = carData[2];
                boolean isColorOrWeightContainsDigit = false;
                for (int j = 0; j < colorOrWeight.length(); j++) {
                    if (Character.isDigit(colorOrWeight.charAt(j))) {
                        isColorOrWeightContainsDigit = true;
                        break;
                    }
                }
                if (isColorOrWeightContainsDigit) {
                    car.setWeight(colorOrWeight);
                } else {
                    car.setColor(colorOrWeight);
                }
            } else if (carData.length == 4) {
                String weight = carData[2];
                String color = carData[3];
                boolean isWeightContainDigit = false;
                for (int j = 0; j < weight.length(); j++) {
                    if (Character.isDigit(weight.charAt(j))) {
                        isWeightContainDigit = true;
                        break;
                    }
                }
                if (isWeightContainDigit) {
                    car.setWeight(weight);
                    car.setColor(color);
                } else {
                    car.setWeight(color);
                    car.setColor(weight);
                }

            }
            cars.add(car);
        }

        for (Car car : cars) {
            System.out.println(car.getModel() + ":");
            System.out.println("  " + car.getEngine().getModel() + ":");
            System.out.println("    Power: " + car.getEngine().getPower());
            System.out.println("    Displacement: " + car.getEngine().getDisplacement());
            System.out.println("    Efficiency: " + car.getEngine().getEfficiency());
            System.out.println("  Weight: " + car.getWeight());
            System.out.println("  Color: " + car.getColor());
        }

    }
}
