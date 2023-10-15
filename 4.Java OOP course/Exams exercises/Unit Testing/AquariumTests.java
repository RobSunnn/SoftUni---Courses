package aquarium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AquariumTests {
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS Aquarium

    private Aquarium aquarium;
    private Fish fish;
    private Fish fish1;


    @Before
    public void prepare() {
        this.aquarium = new Aquarium("Name", 1);
        this.fish = new Fish("Name");
        this.fish1 = new Fish("Name1");
    }


    @Test(expected = NullPointerException.class)
    public void testSetNameWhenNameNull() {
        new Aquarium(null, 10);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameWhenNameEmpty() {
        new Aquarium("           ", 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityWhenNegativeCapacity() {
        new Aquarium("Name", -1);
    }

    @Test
    public void testAddFish() {
        this.aquarium.add(fish);
        Assert.assertEquals(1, this.aquarium.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddFishWhenNoCapacity() {
        this.aquarium.add(fish);
        this.aquarium.add(fish1);
    }

    @Test
    public void testRemoveFish() {
        this.aquarium.add(fish);
        this.aquarium.remove("Name");
        Assert.assertEquals(0, this.aquarium.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveFishWhenFishNotExist() {
        this.aquarium.remove("Fish");
    }

    @Test
    public void testSellFish() {
        this.aquarium.add(fish);
        Assert.assertEquals(fish, this.aquarium.sellFish("Name"));
        boolean b = this.fish.isAvailable();
        Assert.assertFalse(b);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSellFishWhenFishNotExist() {
        this.aquarium.add(this.fish);
        this.aquarium.sellFish("Fish");
    }


}

