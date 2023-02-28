package ForLoopExercise;

import java.util.Scanner;

public class TennisRangList {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int tournaments = Integer.parseInt(scan.nextLine());
        int startingPoints = Integer.parseInt(scan.nextLine());

        double pointsWon = 0;
        double pointsAfterTheTournaments = 0;
        double tournamentsWon = 0;
        double averagePointsPerTournament = 0;
        double percentTournamentsWon = 0;

        for (int i = 0; i < tournaments; i++) {

            String tournamentStage = scan.nextLine();

            if (tournamentStage.equals("W")) {
                pointsWon += 2000;
                tournamentsWon++;

            }
            if (tournamentStage.equals("F")) {
                pointsWon += 1200;

            }
            if (tournamentStage.equals("SF")) {
                pointsWon += 720;

            }

        }

        pointsAfterTheTournaments = startingPoints + pointsWon;
        averagePointsPerTournament = pointsWon / tournaments;
        percentTournamentsWon = (tournamentsWon / tournaments) * 100;

        System.out.printf("Final points: %.0f%n", pointsAfterTheTournaments);
        System.out.printf("Average points: %.0f%n", Math.floor(averagePointsPerTournament));
        System.out.printf("%.2f%%", percentTournamentsWon);

    }
}
