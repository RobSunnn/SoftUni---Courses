package ForLoopExercise;

import org.w3c.dom.Text;

import java.util.Scanner;

public class Oscars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String actorName = scan.nextLine();
        double points = Double.parseDouble(scan.nextLine());
        int appraiserCount = Integer.parseInt(scan.nextLine());

        double pointsNeeded = 1250.5;

        for (int i = 0; i < appraiserCount; i++) {

            String appraiserName = scan.nextLine();

            int lengthAppraiser = appraiserName.length();
            double appraiserPoints = Double.parseDouble(scan.nextLine());
            points = points + lengthAppraiser * appraiserPoints / 2;

            if (points >= pointsNeeded) {
                System.out.printf("Congratulations, %s got a nominee for leading role with %.1f!", actorName, points);
                break;
            }

        }
        if (points < pointsNeeded) {
            System.out.printf("Sorry, %s you need %.1f more!", actorName, pointsNeeded - points);
        }
    }
}
