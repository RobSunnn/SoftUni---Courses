package football;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class FootballTeamTests1 {
    @Test(expected = NullPointerException.class)
    public void testSetNameOnNull(){
        new FootballTeam(null, 10);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameOnWhitespaces(){
        new FootballTeam("      ", 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCapacityOnLessThanZero(){
        new FootballTeam("Messi", -3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCatOnFullHouse(){
        FootballTeam footballTeam = new FootballTeam("PariSenJarmen", 1);
        footballTeam.addFootballer(new Footballer("Meesi"));
        footballTeam.addFootballer(new Footballer("Messi1"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveUnknownCat(){
        FootballTeam footballTeam = new FootballTeam("PariSenJarmen", 1);
        footballTeam.removeFootballer("Messi");
    }

    @Test
    public void testGetName(){
        FootballTeam footballTeam = new FootballTeam("MouseHouse", 1);
        assertEquals("MouseHouse", footballTeam.getName());
    }

    @Test
    public void testGetCapacity(){
        FootballTeam footballTeam = new FootballTeam("MouseHouse", 6);
        assertEquals(6, footballTeam.getVacantPositions());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCatForSaleUnknownCat(){
        FootballTeam footballTeam = new FootballTeam("MouseHouse", 1);
        footballTeam.footballerForSale("Kitten");
    }

    @Test
    public void testCatForSaleHungry(){
        FootballTeam footballTeam = new FootballTeam("MouseHouse", 1);
        Footballer footballer = new Footballer("Kitten");
        footballTeam.addFootballer(footballer);
        footballTeam.footballerForSale("Kitten");

        assertFalse(footballer.isActive());
    }

    @Test
    public void testGetCountAfterAdding(){
        FootballTeam footballTeam = new FootballTeam("MouseHouse", 1);
        Footballer footballer = new Footballer("Kitten");
        footballTeam.addFootballer(footballer);

        assertEquals(1, footballTeam.getCount());
    }

    @Test
    public void testGetCountAfterRemoving(){
        FootballTeam footballTeam = new FootballTeam("MouseHouse", 3);
        Footballer footballer = new Footballer("Kitten");
        Footballer footballer1 = new Footballer("Kitten1");
        Footballer footballer2 = new Footballer("Kitten2");
        footballTeam.addFootballer(footballer);
        footballTeam.addFootballer(footballer1);
        footballTeam.addFootballer(footballer2);
        footballTeam.removeFootballer("Kitten1");
        footballTeam.removeFootballer("Kitten2");

        assertEquals(1, footballTeam.getCount());
    }

    @Test
    public void testStatistics(){
        FootballTeam footballTeam = new FootballTeam("MouseHouse", 3);
        footballTeam.addFootballer(new Footballer("Kitten"));
        footballTeam.addFootballer(new Footballer("Kitten1"));
        footballTeam.addFootballer(new Footballer("Kitten2"));

        String expected = "The footballer Kitten, Kitten1, Kitten2 is in the team MouseHouse.";

        assertEquals(expected, footballTeam.getStatistics());
    }
}
