package basic.exams;

import java.util.Scanner;

public class bestPlayer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int bestGoals = Integer.MIN_VALUE;
        String bestPlayer = "";
        String player = scanner.nextLine();

        while (!player.equals("END")) {

            int goals = Integer.parseInt(scanner.nextLine());
            if (bestGoals < goals) {
                bestGoals = goals;
                bestPlayer = player;

            }
            if (goals >= 10) {
                break;
            }

            player = scanner.nextLine();

        }

        System.out.printf("%s is the best player!%n", bestPlayer);

        if (bestGoals >= 3) {
            System.out.printf("He has scored %d goals and made a hat-trick !!!", bestGoals);
        } else {
            System.out.printf("He has scored %d goals.", bestGoals);
        }
    }
}


