package garage;

import org.junit.Assert;

import org.junit.Test;

import java.util.List;

public class GarageTests {
    //TODO: Test Garage class

    @Test
    public void isFindAllCarsWithMaxHPWork() {
        Garage garage = new Garage();
        Car car = new Car("AUDI", 300, 30000);
        Car car1 = new Car("Mercedes", 300, 30000);
        Car car2 = new Car("BMW", 300, 30000);
        garage.addCar(car);
        garage.addCar(car1);
        garage.addCar(car2);
        List<Car> list = garage.findAllCarsWithMaxSpeedAbove(250);

        Assert.assertEquals(3, list.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void isAddCarWorkWhenCarNull() {
        Garage garage = new Garage();
        garage.addCar(null);
    }
    @Test
    public void isAddCarWork(){
        Garage garage = new Garage();
        Car car = new Car("AUDI", 300, 30000);
        Car car1 = new Car("Mercedes", 300, 30000);
        Car car2 = new Car("BMW", 300, 30000);
        garage.addCar(car);
        garage.addCar(car1);
        garage.addCar(car2);

        Assert.assertEquals(3, garage.getCount());
    }

    @Test
    public void isGetMostExpensiveWork() {
        Garage garage = new Garage();
        Car car = new Car("AUDI", 300, 300000);
        Car car1 = new Car("Mercedes", 300, 30000);
        Car car2 = new Car("BMW", 300, 30000);
        garage.addCar(car);
        garage.addCar(car1);
        garage.addCar(car2);

        Assert.assertEquals(car, garage.getTheMostExpensiveCar());
    }

    @Test
    public void isGetCarByBrandWork() {
        Garage garage = new Garage();
        Car car = new Car("AUDI", 300, 30000);
        Car car1 = new Car("AUDI", 300, 30000);
        Car car2 = new Car("AUDI", 300, 30000);
        garage.addCar(car);
        garage.addCar(car1);
        garage.addCar(car2);
        List<Car> cars = garage.findAllCarsByBrand("AUDI");

        Assert.assertEquals(3, cars.size());
    }
}