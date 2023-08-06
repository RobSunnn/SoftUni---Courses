package toyStore;

import org.junit.Assert;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class ToyStoryTest {
    //TODO: Write your tests here

    @Test
    public void getVaultCells() {
        ToyStore toyStore = new ToyStore();
        Map<String, Toy> toyShelf;
        toyShelf = new LinkedHashMap<>();
        toyShelf.put("A", null);
        toyShelf.put("B", null);
        toyShelf.put("C", null);
        toyShelf.put("D", null);
        toyShelf.put("E", null);
        toyShelf.put("F", null);
        toyShelf.put("G", null);
        Assert.assertEquals(toyShelf, toyStore.getToyShelf());

    }

    @Test(expected = IllegalArgumentException.class)
    public void isToyAddedToRepository() throws OperationNotSupportedException {
        ToyStore toyStore = new ToyStore();
        String toyShelf = "H";
        Toy toy = new Toy("Y", "Z");

        Assert.assertEquals("Shelf doesn't exist!", toyStore.addToy(toyShelf, toy));
    }

    @Test
    public void isToyPlaced() throws OperationNotSupportedException {
        ToyStore toyStore = new ToyStore();
        Toy toy = new Toy("A", "B");

        Assert.assertEquals(String.format("Toy:%s placed successfully!", toy.getToyId()), toyStore.addToy("A", toy));
    }

    @Test
    public void isItemExist() throws OperationNotSupportedException {
        ToyStore toyStore = new ToyStore();
        Toy toy = new Toy("A", "B");
        toyStore.addToy("A", toy);
        boolean isExist = toyStore.getToyShelf().containsValue(toy);
        Assert.assertTrue("Toy is already in shelf!", isExist);
    }

    @Test(expected = IllegalArgumentException.class)
    public void isShelfBusy() throws OperationNotSupportedException {
        ToyStore toyStore = new ToyStore();
        Toy toy = new Toy("Y", "Z");
        String shelf = "A";
        toyStore.addToy(shelf, toy);


        Assert.assertEquals("Shelf is already taken!", toyStore.addToy(shelf, toy));

    }

    @Test(expected = IllegalArgumentException.class)
    public void isToyExistingOnShelf() throws OperationNotSupportedException {
        ToyStore toyStore = new ToyStore();
        Toy toy = new Toy("A", "B");
        String shelf = "A";
        toyStore.addToy(shelf, new Toy("A", "B"));


        Assert.assertEquals("Toy is already in shelf!", toyStore.addToy(shelf, toy));
    }

    @Test(expected = IllegalArgumentException.class)
    public void isToyOnShelf() {
        ToyStore toyStore = new ToyStore();
        Toy toy = new Toy("A", "B");
        String shelf = "A";

        Assert.assertEquals("Toy in that shelf doesn't exists!", toyStore.removeToy(shelf, toy));
    }

    @Test(expected = IllegalArgumentException.class)
    public void isShelfExisting() {
        ToyStore toyStore = new ToyStore();
        Toy toy = new Toy("A", "B");
        Assert.assertEquals("Shelf doesn't exists!", toyStore.removeToy("Z", toy));
    }

    @Test
    public void isToyRemoved() throws OperationNotSupportedException {
        ToyStore toyStore = new ToyStore();
        Toy toy = new Toy("A", "B");
        toyStore.addToy("A", toy);
        String result = toyStore.removeToy("A", toy);
        long count = toyStore.getToyShelf().values().stream().filter(Objects::nonNull).count();
        Assert.assertEquals(0, count);
        Assert.assertEquals(String.format("Remove toy:%s successfully!", toy.getToyId()), result);
    }
}