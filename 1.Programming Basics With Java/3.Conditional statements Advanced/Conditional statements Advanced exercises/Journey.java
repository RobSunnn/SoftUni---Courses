package ConditionalStatementsAdvancedExercise;

import java.util.Scanner;

public class Journey {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double budget = Double.parseDouble(scan.nextLine());
        String season = scan.nextLine();

        String destination = "";
        String camp = "";


        if (budget <= 100) {

            destination = "Bulgaria";

            if (season.equals("summer")) {
                budget = budget * 30 / 100;
                camp = "Camp";

            } else {
                budget = budget * 70 / 100;
                camp = "Hotel";
            }


            System.out.printf("Somewhere in %s %n%s - %.2f", destination, camp, budget);


        }


        if (budget > 100 && budget <= 1000) {

            destination = "Balkans";

            if (season.equals("summer")) {
                budget = budget * 40 / 100;
                camp = "Camp";
            } else {
                budget = budget * 80 / 100;
                camp = "Hotel";
            }


            System.out.printf("Somewhere in %s %n%s - %.2f", destination, camp, budget);
        }

        if (budget > 1000) {

            destination = "Europe";

            budget = budget * 90 / 100;
            camp = "Hotel";


            System.out.printf("Somewhere in %s %n%s - %.2f", destination, camp, budget);
        }

    }
}
