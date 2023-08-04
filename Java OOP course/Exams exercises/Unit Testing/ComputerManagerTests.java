package computers;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ComputerManagerTests {
    // TODO: Test ComputerManager


    @Test(expected = IllegalArgumentException.class)
    public void isComputerAddedWhenNull() {
        new ComputerManager().addComputer(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void isComputerAddedWhenExist() {
        ComputerManager computerManager = new ComputerManager();
        Computer computer = new Computer("DELL", "LAPTOP", 300);
        computerManager.addComputer(computer);
        computerManager.addComputer(computer);

        Assert.assertEquals(1, computerManager.getCount());
    }

    @Test
    public void isComputerAdded() {
        ComputerManager computerManager = new ComputerManager();
        Computer computer = new Computer("DELL", "LAPTOP", 300);
        computerManager.addComputer(computer);
        Assert.assertEquals(1, computerManager.getCount());
    }

    @Test
    public void isComputerRemoved() {
        ComputerManager computerManager = new ComputerManager();
        Computer computer = new Computer("DELL", "LAPTOP", 300);
        computerManager.addComputer(computer);
        computerManager.removeComputer("DELL", "LAPTOP");
        Assert.assertEquals(0, computerManager.getCount());

    }

    @Test(expected = IllegalArgumentException.class)
    public void isComputerRemovedWhenNotExisting() {
        ComputerManager computerManager = new ComputerManager();
        Computer computer = new Computer("DELL", "LAPTOP", 300);
        computerManager.addComputer(computer);
        computerManager.removeComputer("ASUS", "LAPTOP");

    }

    @Test
    public void isComputersFound() {

        ComputerManager computerManager = new ComputerManager();
        Computer computer = new Computer("DELL", "LAPTOP", 300);
        Computer computer1 = new Computer("ASUS", "LAPTOP", 411);
        computerManager.addComputer(computer);
        computerManager.addComputer(computer1);

        List<Computer> computers = new ArrayList<>();

        computers.add(computer1);

        Assert.assertEquals(computers, computerManager.getComputersByManufacturer("ASUS"));
    }


}