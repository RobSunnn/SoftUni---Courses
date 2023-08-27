package handball;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TeamTests {

    private Team team;

    private HandballPlayer player0;
    private HandballPlayer player1;
    private HandballPlayer player2;

    @Before
    public void prepare() {
        this.team = new Team("Name", 3);
        this.player0 = new HandballPlayer("P0");
        this.player1 = new HandballPlayer("P1");
        this.player2 = new HandballPlayer("P2");
    }

    private void addPlayersToTeam() {
        this.team.add(this.player0);
        this.team.add(this.player1);
        this.team.add(this.player2);
    }


    @Test
    public void testGetName() {
        Assert.assertEquals("Name", this.team.getName());
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameWhenNameNull() {
        new Team(null, 1);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameWhenNameEmpty() {
        new Team("    ", 1);
    }

    @Test
    public void testGetPosition() {
        Assert.assertEquals(3, this.team.getPosition());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetPositionWhenNegative() {
        new Team("Team", -1);
    }

    @Test
    public void testGetCountOfTeam() {
        addPlayersToTeam();
        Assert.assertEquals(3, this.team.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddPlayerWhenNoSpace() {
        addPlayersToTeam();
        this.team.add(new HandballPlayer("S"));
    }

    @Test
    public void testRemovePlayer() {
        addPlayersToTeam();
        this.team.remove("P0");
        Assert.assertEquals(2, this.team.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemovePlayerWhenPlayerNotExist() {
        addPlayersToTeam();
        this.team.remove("@");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPlayerForAnotherTeamWhenPlayerNotExist() {
        addPlayersToTeam();
        this.team.playerForAnotherTeam("@");
    }

    @Test
    public void testPlayerForAnotherTeam() {
        addPlayersToTeam();
        HandballPlayer player = this.team.playerForAnotherTeam("P0");
        Assert.assertFalse(this.player0.isActive());
        Assert.assertEquals(this.player0, player);
    }

}
