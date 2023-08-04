package garage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GarageTests {
    //TODO: Test Garage class

    private Garage garage;
    private Car car;
    private Car car1;
    private Car car2;

    @Before
    public void prepare() {
        this.garage = new Garage();
        this.car = new Car("Audi", 300, 1000001);
        this.car1 = new Car("Bmw", 300, 100000);
        this.car2 = new Car("Mercedes", 300, 100000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCarWhenCarIsNull() {
        this.garage.addCar(null);
    }

    @Test
    public void testAddCar() {
        this.garage.addCar(car);
        this.garage.addCar(car1);
        this.garage.addCar(car2);
        Assert.assertEquals(3, garage.getCount());
    }

    @Test
    public void testReturnAllCarsWithMaxSpeedAbove() {
        this.garage.addCar(this.car);
        this.garage.addCar(this.car1);
        this.garage.addCar(this.car2);
        List<Car> cars = new ArrayList<>();
        cars.add(this.car);
        cars.add(this.car1);
        cars.add(this.car2);
        List<Car> garageCars = garage.findAllCarsWithMaxSpeedAbove(250);
        Assert.assertEquals(cars.size(), garageCars.size());
        for (int i = 0; i < cars.size(); i++) {
            Assert.assertEquals(cars.get(i).getMaxSpeed(), garageCars.get(i).getMaxSpeed());
        }
    }

    @Test
    public void testGetMostExpensiveCar() {
        this.garage.addCar(car);
        this.garage.addCar(car1);
        this.garage.addCar(car2);
        Car car = garage.getTheMostExpensiveCar();
        Assert.assertEquals("Audi", car.getBrand());
    }

    @Test
    public void testFindAllCarsByBrand() {
        this.garage.addCar(this.car);
        this.garage.addCar(this.car1);
        this.garage.addCar(this.car2);
        this.garage.addCar(new Car("Audi", 300, 12000));
        this.garage.addCar(new Car("Audi", 301, 120001));
        List<Car> cars = new ArrayList<>();
        cars.add(this.car);
        cars.add(new Car("Audi", 300, 12000));
        cars.add(new Car("Audi", 301, 120001));
        List<Car> garageCars = this.garage.findAllCarsByBrand("Audi");
        Assert.assertEquals(cars.size(), garageCars.size());
        for (int i = 0; i < cars.size(); i++) {
            Assert.assertEquals(cars.get(i).getBrand(), garageCars.get(i).getBrand());
        }

    }

}