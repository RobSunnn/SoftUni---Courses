package dealership;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    public String name;
    public int capacity;
    public List<Car> data;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (this.data.size() + 1 <= this.capacity) {
            this.data.add(car);
        }

    }

    public boolean buy(String manufacturer, String model) {
        for (Car car : this.data) {
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                this.data.remove(car);
                return true;
            }
        }

        return false;
    }

    public Car getLatestCar() {
        if (this.data.size() > 0) {
            Car carToReturn = null;
            int year = -1;
            for (Car car : this.data) {
                if (car.getYear() > year) {
                    year = car.getYear();
                    carToReturn = car;
                }
            }
            return carToReturn;
        } else {
            return null;
        }
    }

    public Car getCar(String manufacturer, String model){
        Car carToReturn = null;
        if (this.data.size() > 0) {
            for (Car car : this.data) {
                if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                    carToReturn = car;
                }
            }


        }
        return carToReturn;
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("The cars are in a car dealership %s:",this.name)).append(System.lineSeparator());
        for (Car car : this.data) {
            sb.append(car).append(System.lineSeparator());
        }


        return sb.toString().trim();
    }
}
