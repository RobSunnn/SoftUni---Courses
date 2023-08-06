package blueOrigin;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SpaceshipTests {
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS Spaceship
    private Spaceship spaceship;
    private Astronaut astronaut;
    private Spaceship spaceship1;

    @Before
    public void prepare() {
        this.spaceship = new Spaceship("Name", 1);
        this.spaceship1 = new Spaceship("SPACESHIP", 10);
        this.astronaut = new Astronaut("NAME", 20.9);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameOnSpaceshipWhenNameIsNull() {
        new Spaceship(null, 11);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameOnSpaceshipWhenNameIsEmpty() {
        new Spaceship("         ", 11);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityWhenCapacityIsNegative() {
        new Spaceship("Name", -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAstronautWhenFullCapacity() {
        this.spaceship.add(this.astronaut);
        this.spaceship.add(new Astronaut("WOW", 10.2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAstronautWhenAstronautExist() {
        this.spaceship1.add(this.astronaut);
        this.spaceship1.add(new Astronaut("NAME", 20.9));

    }

    @Test
    public void testAddAstronaut() {
        this.spaceship.add(this.astronaut);
        Assert.assertEquals(1, this.spaceship.getCount());
    }

    @Test
    public void testRemoveAstronautWhenAstronautNotExist() {
        boolean remove = this.spaceship.remove(this.astronaut.getName());
        Assert.assertFalse(remove);
        Assert.assertEquals(0, this.spaceship.getCount());
    }
    @Test
    public void testRemoveAstronaut() {
        this.spaceship.add(this.astronaut);
        boolean remove = this.spaceship.remove(this.astronaut.getName());
        Assert.assertTrue(remove);
        Assert.assertEquals(0, this.spaceship.getCount());
    }

}
