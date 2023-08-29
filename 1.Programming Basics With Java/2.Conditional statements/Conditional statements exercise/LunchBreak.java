package ConditionalStatementsExercise;

import java.util.Scanner;

public class LunchBreak {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String movie = scan.nextLine();
        int episodeTime = Integer.parseInt(scan.nextLine());
        int breakTime = Integer.parseInt(scan.nextLine());

        double lunchTime = breakTime / 8.00;
        double rest = breakTime / 4.00;
        double timeLeft = breakTime - lunchTime - rest;

        if (timeLeft >= episodeTime) {
            System.out.printf("You have enough time to watch %s and left with %.0f minutes free time."
                    , movie, Math.ceil(timeLeft - episodeTime));
        } else {
            System.out.printf("You don't have enough time to watch %s, you need %.0f more minutes."
                    , movie, Math.ceil(episodeTime - timeLeft));
        }


    }
}
