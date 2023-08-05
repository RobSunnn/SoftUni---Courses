package cats;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HouseTests {

    private House house;
    private Cat cat;

    @Before
    public void prepare() {
        this.house = new House("House", 1);
        this.cat = new Cat("KOTIO");
    }

    @Test(expected = NullPointerException.class)
    public void testIsHouseCreatedWhenNameNull() {
        new House(null, 10);
    }

    @Test(expected = NullPointerException.class)
    public void testIsHouseCreatedWhenNameEmpty() {
        new House("   ", 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIsHouseCreatedWhenCapacityIsNegative() {
        new House("Housee", -10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCatWhenFullHouse() {
        this.house.addCat(this.cat);
        this.house.addCat(new Cat("MEOW"));
    }

    @Test
    public void testAddCat() {
        this.house.addCat(this.cat);
        Assert.assertEquals(1, house.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIsCatRemovedWhenCatIsNull() {
        this.house.addCat(this.cat);
        this.house.removeCat("MEOW");
    }

    @Test
    public void testIsCatRemovedFromHouse() {
        this.house.addCat(cat);
        this.house.removeCat("KOTIO");
        Assert.assertEquals(0, house.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCatForSaleWhenCatNull() {
        this.house.addCat(this.cat);
        this.house.catForSale("MEOW");
    }

    @Test
    public void testCatForSale() {
        this.house.addCat(this.cat);
        this.house.catForSale("KOTIO");
        boolean hungry = this.cat.isHungry();
        Assert.assertFalse(hungry);
    }

}
