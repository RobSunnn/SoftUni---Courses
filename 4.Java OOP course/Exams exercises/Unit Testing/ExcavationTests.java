package archeologicalExcavations;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ExcavationTests {

    private Excavation excavation;
    private Archaeologist archaeologist;
    private Archaeologist archaeologist1;
    private Archaeologist archaeologist2;

    @Before
    public void prepare() {
        this.excavation = new Excavation("Name", 2);
        this.archaeologist = new Archaeologist("a", 12.0);
        this.archaeologist1 = new Archaeologist("a1", 13.0);
        this.archaeologist2 = new Archaeologist("a2", 14.0);
    }


    @Test(expected = NullPointerException.class)
    public void testSetNameWhenNameNull() {
        new Excavation(null, 10);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameWhenNameEmpty() {
        new Excavation("    ", 10);
    }

    @Test
    public void testSetName() {
        Assert.assertEquals("Name", this.excavation.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityWhenNegativeCapacity() {
        new Excavation("Name", -1);
    }

    @Test
    public void testSetCapacity() {
        Assert.assertEquals(2, this.excavation.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddArcheologistWhenNoRoomForHim() {
        this.excavation.addArchaeologist(this.archaeologist);
        this.excavation.addArchaeologist(this.archaeologist1);
        this.excavation.addArchaeologist(this.archaeologist2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddArcheologistWhenArcheologistExist() {
        this.excavation.addArchaeologist(this.archaeologist);
        this.excavation.addArchaeologist(this.archaeologist);
    }

    @Test
    public void testAddArcheologist() {
        this.excavation.addArchaeologist(this.archaeologist);
        this.excavation.addArchaeologist(this.archaeologist1);
        Assert.assertEquals(2, this.excavation.getCount());

    }

    @Test
    public void testRemoveArcheologistWhenArcheologistNotExist() {
        this.excavation.addArchaeologist(this.archaeologist);
        this.excavation.addArchaeologist(this.archaeologist1);
        boolean test = this.excavation.removeArchaeologist(this.archaeologist2.getName());
        Assert.assertFalse(test);

    }

    @Test
    public void testRemoveArcheologist() {
        this.excavation.addArchaeologist(this.archaeologist);
        this.excavation.addArchaeologist(this.archaeologist1);
        boolean test = this.excavation.removeArchaeologist(this.archaeologist1.getName());
        Assert.assertTrue(test);
        Assert.assertEquals(1, this.excavation.getCount());
    }


}
