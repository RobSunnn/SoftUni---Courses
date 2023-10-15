package carShop;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CarShopTests {
    private CarShop carShop;
    private Car car1;
    private Car car2;
    private Car car3;

    @Before
    public void prepare() {
        this.carShop = new CarShop();
        this.car1 = new Car("car1", 250, 10000);
        this.car2 = new Car("car2", 255, 10001);
        this.car3 = new Car("car3", 260, 10002);
        this.carShop.add(car1);
        this.carShop.add(car2);
        this.carShop.add(car3);
    }

    @Test
    public void testGetCount() {
        Assert.assertEquals(3, this.carShop.getCount());
    }

    @Test
    public void testGetCars() {
        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        Assert.assertEquals(cars, carShop.getCars());
    }

    @Test
    public void testGetCarsWithMaximumPower() {
        List<Car> cars = new ArrayList<>();
        cars.add(this.car3);

        Assert.assertEquals(cars, carShop.findAllCarsWithMaxHorsePower(256));
    }

    @Test(expected = NullPointerException.class)
    public void testAddCarWhenCarIsNull() {
        this.carShop.add(null);
    }

    @Test
    public void testRemoveCar() {
        boolean remove = this.carShop.remove(this.car1);
        Assert.assertTrue(remove);
        Assert.assertEquals(2, this.carShop.getCount());
    }

    @Test
    public void testGetMostLuxuryCar() {
        Assert.assertEquals(this.car3, this.carShop.getTheMostLuxuryCar());
    }

    @Test
    public void testFindAllCarsByModel() {
        Car car = new Car("car1", 213123, 124124);
        Car car22 = new Car("car1", 213123, 124124);
        List<Car> cars = new ArrayList<>();
        cars.add(this.car1);
        cars.add(car);
        cars.add(car22);
        this.carShop.add(car);
        this.carShop.add(car22);
        Assert.assertEquals(cars, this.carShop.findAllCarByModel("car1"));
    }

}

