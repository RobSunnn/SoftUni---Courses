package ConditionalStatementsExercise;

import java.util.Scanner;

public class WorldSwimmingRecord {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        double record = Double.parseDouble(scan.nextLine());
        double meters = Double.parseDouble(scan.nextLine());
        double secondsForMeter = Double.parseDouble(scan.nextLine());

        double time = meters * secondsForMeter;
        double resistance = Math.floor(meters / 15);
        double slowingDown = resistance * 12.5;
        double totalTime = time + slowingDown;

        if (record > totalTime) {
            System.out.printf("Yes, he succeeded! The new world record is %.2f seconds.", Math.abs(totalTime));
        } else {
            System.out.printf("No, he failed! He was %.2f seconds slower.", Math.abs(record - totalTime));
        }
    }
}
