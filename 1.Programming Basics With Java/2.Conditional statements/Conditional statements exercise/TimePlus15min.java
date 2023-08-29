package ConditionalStatementsExercise;

import java.util.Scanner;

public class TimePlus15min {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int hours = Integer.parseInt(scan.nextLine());
        int minutes = Integer.parseInt(scan.nextLine());

        int timeInMin = minutes + hours * 60;
        timeInMin = timeInMin + 15;
        hours = timeInMin / 60;
        minutes = timeInMin % 60;


        if (hours >= 24) {
            hours = hours - 24;
        }
        if (minutes < 10) {
            System.out.printf("%d:%02d", hours, minutes);
        } else {
            System.out.printf("%d:%d", hours, minutes);
        }

    }
}
