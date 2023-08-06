package toyStore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import toyStore.Toy;
import toyStore.ToyStore;

import javax.naming.OperationNotSupportedException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;


public class ToyStoryTest {
    private ToyStore toyStore;

    @Before
    public void init() {
        toyStore = new ToyStore();
    }

    @Test
    public void getVaultCells() {
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
    public void addToy() throws OperationNotSupportedException {
        Toy i = new Toy("TestOwner", "TestItem");
        Toy i2 = new Toy("TestOwner", "TestItem2");
        toyStore.addToy("A", i);
        long exist = toyStore.getToyShelf().values().stream().filter(Objects::nonNull).count();
        Assert.assertEquals(1, exist);
        toyStore.addToy("A", i2);


    }

    @Test(expected = OperationNotSupportedException.class)
    public void addToy2() throws OperationNotSupportedException {
        Toy i = new Toy("TestOwner", "TestItem");
        Toy i2 = new Toy("TestOwner", "TestItem");
        toyStore.addToy("A", i);
        toyStore.addToy("B", i);


    }

    @Test(expected = IllegalArgumentException.class)
    public void addToy3() throws OperationNotSupportedException {
        Toy i = new Toy("TestOwner", "TestItem");
        toyStore.addToy("A23", i);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeToy() throws OperationNotSupportedException {
        Toy i = new Toy("TestOwner", "TestItem");
        Toy i2 = new Toy("TestOwner", "TestItem2");
        toyStore.addToy("A", i);
        toyStore.addToy("B", i2);
        toyStore.removeToy("A", i2);
        long exist = toyStore.getToyShelf().values().stream().filter(Objects::nonNull).count();
        Assert.assertEquals(1, exist);
    }

    @Test
    public void removeToy2() throws OperationNotSupportedException {
        Toy i = new Toy("TestOwner", "TestItem");
        Toy i2 = new Toy("TestOwner", "TestItem2");
        toyStore.addToy("A", i);
        toyStore.addToy("B", i2);
        String result = toyStore.removeToy("B", i2);
        long exist = toyStore.getToyShelf().values().stream().filter(Objects::nonNull).count();
        Assert.assertEquals(1, exist);
        Assert.assertEquals("Remove toy:TestItem2 successfully!", result);
    }


}