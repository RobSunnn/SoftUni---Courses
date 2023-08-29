package ConditionalStatementsAdvancedExercise;

import java.util.Scanner;

public class FishingBoat {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int budget = Integer.parseInt(scan.nextLine());
        String season = scan.nextLine();
        int fisherman = Integer.parseInt(scan.nextLine());

        double price = 0;

        switch (season) {
            case "Spring":
                price = 3000;
                break;
            case "Summer":
                price = 4200;
                break;
            case "Autumn":
                price = 4200;
                break;
            case "Winter":
                price = 2600;
                break;
        }
        if (fisherman <= 6) {
            price = price - (price * 10 / 100);
        } else if (fisherman <= 11) {
            price = price - (price * 15 / 100);
        } else if (fisherman > 12) {
            price = price - (price * 25 / 100);
        }

        if (season.equals("Spring") || season.equals("Summer") || season.equals("Winter")) {
            if (fisherman % 2 == 0)
                price = price - price * 0.05;

        }

        if (price <= budget) {
            System.out.printf("Yes! You have %.2f leva left.", budget - price);
        } else {
            System.out.printf("Not enough money! You need %.2f leva.", price - budget);
        }
    }
}
