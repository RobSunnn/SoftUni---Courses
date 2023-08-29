package basic.exams;

import java.util.Scanner;

public class filmPremiere {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String projection = scanner.nextLine();
        String drink = scanner.nextLine();
        int ticketsCount = Integer.parseInt(scanner.nextLine());
        double price = 0;

        switch (projection) {

            case "John Wick":

                switch (drink) {
                    case "Drink":
                        price = 12;
                        break;
                    case "Popcorn":
                        price = 15;
                        break;
                    case "Menu":
                        price = 19;
                        break;
                }
                break;

            case "Star Wars":

                switch (drink) {
                    case "Drink":
                        price = 18;
                        break;
                    case "Popcorn":
                        price = 25;
                        break;
                    case "Menu":
                        price = 30;
                        break;
                }
                break;

            case "Jumanji":

                switch (drink) {
                    case "Drink":
                        price = 9;
                        break;
                    case "Popcorn":
                        price = 11;
                        break;
                    case "Menu":
                        price = 14;
                        break;
                }
                break;
        }

        price = price * ticketsCount;

        if (projection.equals("Star Wars")) {
            if (ticketsCount >= 4) {
                price = price - price * 0.3;
            }
        }

        if (projection.equals("Jumanji")) {
            if (ticketsCount == 2) {
                price = price - price * 0.15;
            }
        }

        System.out.printf("Your bill is %.2f leva.", price);
    }
}
