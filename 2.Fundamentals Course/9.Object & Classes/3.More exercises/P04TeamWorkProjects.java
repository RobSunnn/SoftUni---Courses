package More.Exercise.ObjectAndClasses;

import java.util.*;
import java.util.stream.Collectors;


public class P04TeamWorkProjects {
    public static class Team {
        private String creator;
        private String name;
        private List<String> users;

        public Team(String creator, String name) {
            this.creator = creator;
            this.name = name;
            this.users = new ArrayList<>();
        }

        public String getCreator() {
            return creator;
        }

        public String getName() {
            return name;
        }

        public int getCount() {
            return users.size();
        }

        public List<String> getUsers() {
            return users;
        }

        public void sortPeople() {
            this.users = this.users.stream().sorted(String::compareTo).collect(Collectors.toList());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countTeamsToCreate = Integer.parseInt(scanner.nextLine());
        List<Team> teams = new ArrayList<>();

        for (int i = 1; i <= countTeamsToCreate; i++) {
            String[] data = scanner.nextLine().split("-");
            String creator = data[0];
            String teamName = data[1];
            Team team = new Team(creator, teamName);

            if (isCreatorNotMadeATeamAlready(teams, creator)) {
                System.out.printf("%s cannot create another team!%n", creator);
                continue;
            }
            if (isTeamNotExistInCollection(teams, teamName)) {
                System.out.printf("Team %s was already created!%n", teamName);
                continue;
            }

            teams.add(team);
            System.out.printf("Team %s has been created by %s!%n", teamName, creator);

        }

        String input = scanner.nextLine();

        while (!input.equals("end of assignment")) {
            String[] data = input.split("->");
            String username = data[0];
            String teamName = data[1];

            if (!isTeamNotExistInCollection(teams, teamName)) {
                System.out.printf("Team %s does not exist!%n", teamName);
                input = scanner.nextLine();
                continue;
            }
            if (isCreatorNotMadeATeamAlready(teams, username) || isMemberExistInAClub(teams, username)) {
                System.out.printf("Member %s cannot join team %s!%n", username, teamName);
                input = scanner.nextLine();
                continue;
            }

            addUserToTeam(teams, username, teamName);

            input = scanner.nextLine();
        }

        printTheTeams(teams);

    }

    private static void printTheTeams(List<Team> teams) {
        List<Team> teamsNotDisband = new ArrayList<>();
        List<Team> teamsDisband = new ArrayList<>();
        for (Team team : teams) {
            if (team.getUsers().isEmpty()) {
                teamsDisband.add(team);
            } else {
                teamsNotDisband.add(team);
            }
        }
        teamsDisband.sort(Comparator.comparing(Team::getName));
        teamsNotDisband.sort(Comparator.comparing(Team::getCount).reversed().thenComparing(Team::getName));

        for (Team team : teamsNotDisband) {
            team.sortPeople();
            System.out.println(team.getName());
            System.out.println("- " + team.getCreator());
            for (String member : team.getUsers()) {
                System.out.println("-- " + member);
            }
        }
        System.out.println("Teams to disband:");
        for (Team team : teamsDisband) {
            System.out.println(team.getName());
        }
    }

    private static void addUserToTeam(List<Team> teams, String username, String teamName) {
        for (Team t : teams) {
            if (t.getName().equals(teamName)) {
                t.getUsers().add(username);
            }
        }
    }

    public static boolean isCreatorNotMadeATeamAlready(List<Team> teams, String creator) {
        for (Team t : teams) {
            if (t.getCreator().equals(creator)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isTeamNotExistInCollection(List<Team> teams, String teamName) {
        for (Team t : teams) {
            if (t.getName().equals(teamName)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isMemberExistInAClub(List<Team> teams, String member) {
        for (Team team : teams) {
            for (String user : team.getUsers()) {
                if (user.equals(member)) {
                    return true;
                }
            }
        }
        return false;
    }

}
