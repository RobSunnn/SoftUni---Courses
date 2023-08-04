package football;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FootballTeamTests {
    private FootballTeam footballTeam;
    private Footballer footballer;
    private Footballer footballer1;
    private Footballer footballer2;

    @Before
    public void prepare() {
        this.footballTeam = new FootballTeam("Real", 2);
        this.footballer = new Footballer("f");
        this.footballer1 = new Footballer("f1");
        this.footballer2 = new Footballer("f2");
    }

    @Test
    public void testSetName() {
        Assert.assertEquals("Real", this.footballTeam.getName());
    }


    @Test(expected = NullPointerException.class)
    public void testSetNameWhenNameNull() {
        new FootballTeam(null, 10);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameWhenNameEmpty() {
        new FootballTeam("     ", 10);
    }

    @Test
    public void testSetVacantPositions() {
        Assert.assertEquals(2, this.footballTeam.getVacantPositions());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetVacantPositionsWhenNegative() {
        new FootballTeam("Name", -1);
    }

    @Test
    public void testAddFootballer() {
        this.footballTeam.addFootballer(this.footballer);
        this.footballTeam.addFootballer(this.footballer1);

        Assert.assertEquals(2, this.footballTeam.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddFootballerWhenNoVacantPositions() {
        this.footballTeam.addFootballer(this.footballer);
        this.footballTeam.addFootballer(this.footballer1);
        this.footballTeam.addFootballer(this.footballer2);
    }

    @Test
    public void testRemoveFootballer() {
        this.footballTeam.addFootballer(this.footballer);
        this.footballTeam.addFootballer(this.footballer1);
        this.footballTeam.removeFootballer(footballer.getName());
        Assert.assertEquals(1, this.footballTeam.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveFootballerWhenFootballerNotExist() {
        this.footballTeam.addFootballer(this.footballer);
        this.footballTeam.removeFootballer(this.footballer1.getName());
    }


    @Test
    public void testFootballerForSale() {
        this.footballTeam.addFootballer(this.footballer);
        this.footballTeam.addFootballer(this.footballer1);
        Footballer player = this.footballTeam.footballerForSale(this.footballer.getName());
        Assert.assertFalse(player.isActive());

    }

    @Test(expected = IllegalArgumentException.class)
    public void testFootballerForSaleWhenFootballerNotExist() {
        this.footballTeam.addFootballer(this.footballer);
        this.footballTeam.addFootballer(this.footballer1);
        Footballer player = this.footballTeam.footballerForSale("Name");
    }

}
