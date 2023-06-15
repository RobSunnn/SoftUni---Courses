package guild;

import java.util.ArrayList;
import java.util.List;

public class Guild {
    private String name;
    private int capacity;
    private List<Player> roster;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Player> getRoster() {
        return roster;
    }

    public void setRoster(List<Player> roster) {
        this.roster = roster;
    }

    public void addPlayer(Player player) {
        if (this.roster.size() + 1 <= this.capacity) {
            this.roster.add(player);
        }
    }

    public boolean removePlayer(String name) {
        for (Player player : this.roster) {
            if (player.getName().equals(name)) {
                this.roster.remove(player);
                return true;
            }
        }
        return false;
    }

    public void promotePlayer(String name) {
        for (Player player : this.roster) {

            if (player.getName().equals(name) && !player.getRank().equals("Member")) {
                player.setRank("Member");
                break;
            }
        }

    }

    public void demotePlayer(String name) {
        for (Player player : this.roster) {

            if (player.getName().equals(name) && !player.getRank().equals("Trial")) {
                player.setRank("Trial");
                break;
            }
        }
    }

    public Player[] kickPlayersByClass(String clazz) {
        List<Player> list = new ArrayList<>();
        for (Player player : this.roster) {

            if (player.getClazz().equals(clazz)) {
                list.add(player);
            }
        }
        Player[] kickedPlayers = new Player[list.size()];

        for (int i = 0; i < list.size(); i++) {
            kickedPlayers[i] = list.get(i);
        }
        for (Player currentPlayer : list) {
            for (Player player : this.roster) {
                if (currentPlayer.getName().equals(player.getName())) {
                    this.roster.remove(currentPlayer);
                    break;
                }
            }
        }

        return kickedPlayers;
    }

    public int count() {
        return this.roster.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Players in the guild: %s:", getName())).append(System.lineSeparator());
        for (Player player : this.roster) {
            sb.append(player).append(System.lineSeparator());
        }


        return sb.toString().trim();
    }

}
