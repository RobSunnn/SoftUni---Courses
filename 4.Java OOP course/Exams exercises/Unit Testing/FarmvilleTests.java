package farmville;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FarmvilleTests {
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS Farm
    private Farm farm;
    private Animal animal;

    @Before
    public void prepare() {
        this.farm = new Farm("Name", 1);
        this.animal = new Animal("GOAT", 13.0);
    }


    @Test(expected = NullPointerException.class)
    public void testFarmCreatedWithNameNull() {
        new Farm(null, 13);
    }

    @Test(expected = NullPointerException.class)
    public void testFarmCreatedWithNameEmpty() {
        new Farm("     ", 13);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFarmCreatedWithNegativeCapacity() {
        new Farm("Name", -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAnimalWhenNoRoomForIt() {
        this.farm.add(this.animal);
        this.farm.add(new Animal("SHEEP", 13.0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAnimalWhenAnimalExist() {
        Farm farm1 = new Farm("FArm", 2);
        farm1.add(this.animal);
        farm1.add(this.animal);
    }

    @Test
    public void testAddAnimal() {
        this.farm.add(this.animal);
        Assert.assertEquals(1, farm.getCount());
    }

    @Test
    public void testRemoveAnimal() {
        this.farm.add(this.animal);
        Assert.assertTrue(this.farm.remove("GOAT"));
    }

    @Test
    public void testGetName() {
        this.farm.add(this.animal);
        Assert.assertEquals("Name", this.farm.getName());
    }

}
