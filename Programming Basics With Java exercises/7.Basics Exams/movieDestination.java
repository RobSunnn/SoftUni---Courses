package basic.exams;

import java.util.Scanner;

public class movieDestination {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String destination = scanner.nextLine();
        String season = scanner.nextLine();
        int daysCount = Integer.parseInt(scanner.nextLine());

        double price = 0;

        switch (destination) {
            case "Dubai":
                switch (season) {
                    case "Winter":
                        price = 45000;
                        break;
                    case "Summer":
                        price = 40000;
                        break;
                }
                break;
            case "Sofia":
                switch (season) {
                    case "Winter":
                        price = 17000;
                        break;
                    case "Summer":
                        price = 12500;
                        break;
                }
                break;
            case "London":
                switch (season) {
                    case "Winter":
                        price = 24000;
                        break;
                    case "Summer":
                        price = 20250;
                        break;
                }
                break;
        }

        price = price * daysCount;

        if (destination.equals("Dubai")) {
            price = price - price * 0.3;
        }
        if (destination.equals("Sofia")) {
            price = price + price * 0.25;
        }

        if (budget >= price) {
            System.out.printf("The budget for the movie is enough! We have %.2f leva left!", budget - price);
        } else {
            System.out.printf("The director needs %.2f leva more!", price - budget);
        }
    }
}
