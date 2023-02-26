package basic.exams;

import java.util.Scanner;

public class movieStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String actorName = scanner.nextLine();
        double budget = Double.parseDouble(actorName);

        while (!actorName.equals("ACTION")) {
            actorName = scanner.nextLine();
            if (actorName.equals("ACTION")) {
                System.out.printf("We are left with %.2f leva.", budget);
                break;
            }

            if (actorName.length() > 15) {
                budget = budget - budget * 0.2;
                continue;
            }
            double salary = Double.parseDouble(scanner.nextLine());
            budget -= salary;
            if (budget < 0) {
                System.out.printf("We need %.2f leva for our actors.", Math.abs(budget));
                break;
            }


        }

    }
}
