package basic.exams;

import java.util.Scanner;

public class oscars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String actorName = scanner.nextLine();
        double startAcademyPoints = Double.parseDouble(scanner.nextLine());
        int appraisersCount = Integer.parseInt(scanner.nextLine());

        double totalPoints = startAcademyPoints;

        for (int i = 1; i <= appraisersCount; i++) {

            String appraiserName = scanner.nextLine();
            double appraiserPoints = Double.parseDouble(scanner.nextLine());
            appraiserPoints = (appraiserName.length() * appraiserPoints) / 2;
            totalPoints += appraiserPoints;

            if (totalPoints >= 1250.5) {
                break;
            }
        }

        if (totalPoints < 1250.50) {
            System.out.printf("Sorry, %s you need %.1f more!", actorName, 1250.5 - totalPoints);
        } else {
            System.out.printf("Congratulations, %s got a nominee for leading role with %.1f!", actorName, totalPoints);
        }


    }
}
