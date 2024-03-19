package magicGame;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MagicianTests {
    //TODO
    private Magician magician;
    private Magic magic;
    private Magic magic1;
    private Magic magic2;

    @Before
    public void prepare() {
        this.magician = new Magician("Mag", 100);
        this.magic = new Magic("Magic", 100);
        this.magic1 = new Magic("Magic1", 10);
        this.magic2 = new Magic("Magic2", 13);
    }


    @Test
    public void testGetUsername() {
        Assert.assertEquals("Mag", this.magician.getUsername());
    }

    @Test(expected = NullPointerException.class)
    public void testSetUsernameWhenUsernameEmpty() {
        new Magician("      ", 100);
    }

    @Test(expected = NullPointerException.class)
    public void testSetUsernameWhenUsernameNull() {
        new Magician(null, 100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetHealthWhenHealthNegative() {
        new Magician("Mag", -1);
    }

    @Test
    public void testTakeDamage() {
        this.magician.takeDamage(10);
        Assert.assertEquals(90, this.magician.getHealth());
        this.magician.takeDamage(90);
        Assert.assertEquals(0, this.magician.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void testTakeDamageWhenMagicianIsDead() {
        this.magician.takeDamage(100);
        this.magician.takeDamage(10);
    }

    @Test(expected = NullPointerException.class)
    public void testAddMagicWhenMagicIsNull() {
        this.magician.addMagic(null);
    }

    @Test
    public void testAddMagic() {
        this.magician.addMagic(magic);
        Assert.assertEquals(this.magic, magician.getMagic("Magic"));
        this.magician.addMagic(magic1);
        Assert.assertEquals(this.magic1, magician.getMagic("Magic1"));
        this.magician.addMagic(magic2);
        Assert.assertEquals(this.magic2, magician.getMagic("Magic2"));
    }

    @Test
    public void testRemoveMagic() {
        boolean b = this.magician.removeMagic(this.magic);
        Assert.assertFalse(b);
        this.magician.addMagic(this.magic1);
        boolean b1 = this.magician.removeMagic(this.magic1);
        Assert.assertTrue(b1);
    }

}
