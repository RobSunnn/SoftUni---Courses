package toyStore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ToyStoryTest {
    //TODO: Write your tests here

    private ToyStore toyStore;
    private Toy toy;
    private Toy toy1;
    private Toy toy2;

    @Before
    public void prepare() {
        this.toyStore = new ToyStore();
        this.toy = new Toy("Toy", "1");
        this.toy1 = new Toy("Toy1", "11");
        this.toy2 = new Toy("Toy2", "12");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddToyInShelfThatNotExist() throws OperationNotSupportedException {
        this.toyStore.addToy("A", this.toy);
        this.toyStore.addToy("z", this.toy1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddToyWhenShelfIsBusy() throws OperationNotSupportedException {
        this.toyStore.addToy("A", this.toy);
        this.toyStore.addToy("A", this.toy1);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddToyWhenToyExist() throws OperationNotSupportedException {
        this.toyStore.addToy("A", this.toy);
        this.toyStore.addToy("B", this.toy);
    }

    @Test
    public void testAddToy() throws OperationNotSupportedException {
        String a = this.toyStore.addToy("A", this.toy);
        Assert.assertEquals("Toy:1 placed successfully!", a);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveToyWhenShelfNotExist() throws OperationNotSupportedException {
        this.toyStore.addToy("A", this.toy);
        this.toyStore.removeToy("Z", this.toy);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveToyWhenToyNotOnShelf() throws OperationNotSupportedException {
        this.toyStore.addToy("A", this.toy);
        this.toyStore.addToy("B", this.toy1);
        this.toyStore.addToy("C", this.toy2);
        this.toyStore.removeToy("A", this.toy1);
    }

    @Test
    public void testRemoveToy() throws OperationNotSupportedException {
        this.toyStore.addToy("A", this.toy);
        this.toyStore.addToy("B", this.toy1);
        this.toyStore.addToy("C", this.toy2);
        String a = this.toyStore.removeToy("A", this.toy);

        Assert.assertEquals("Remove toy:1 successfully!", a);
        Assert.assertNull(this.toyStore.getToyShelf().get("A"));
    }

}