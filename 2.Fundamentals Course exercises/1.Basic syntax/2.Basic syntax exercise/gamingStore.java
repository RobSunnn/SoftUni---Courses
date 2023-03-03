package fundamentals.P03.basicSyntax.moreExercise;

import java.util.Scanner;

public class gamingStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double price = 0.0;
        double totalSpent = 0.0;

        String input = scanner.nextLine();
        double currentBalance = Double.parseDouble(input);

        while (!input.equals("Game Time")) {

            input = scanner.nextLine();

            if (currentBalance == 0) {
                System.out.println("Out of money!");
                break;
            }
            if (input.equals("Game Time")) {
                System.out.printf("Total spent: $%.2f. Remaining: $%.2f", totalSpent, currentBalance);
                break;
            }

            if (input.equals("OutFall 4")) {
                price = 39.99;
                if (price > currentBalance) {
                    System.out.println("Too Expensive");
                    continue;
                }
                if (currentBalance >= price) {
                    System.out.printf("Bought %s%n", input);
                    currentBalance -= price;
                    totalSpent += price;
                }


            } else if (input.equals("CS: OG")) {
                price = 15.99;
                if (price > currentBalance) {
                    System.out.println("Too Expensive");
                }
                if (currentBalance >= price) {
                    System.out.printf("Bought %s%n", input);
                    currentBalance -= price;
                    totalSpent += price;
                }

            } else if (input.equals("Zplinter Zell")) {
                price = 19.99;
                if (price > currentBalance) {
                    System.out.println("Too Expensive");
                }
                if (currentBalance >= price) {
                    System.out.printf("Bought %s%n", input);
                    currentBalance -= price;
                    totalSpent += price;
                }

            } else if (input.equals("Honored 2")) {
                price = 59.99;
                if (price > currentBalance) {
                    System.out.println("Too Expensive");
                }
                if (currentBalance >= price) {
                    System.out.printf("Bought %s%n", input);
                    currentBalance -= price;
                    totalSpent += price;
                }

            } else if (input.equals("RoverWatch")) {
                price = 29.99;
                if (price > currentBalance) {
                    System.out.println("Too Expensive");
                }
                if (currentBalance >= price) {
                    System.out.printf("Bought %s%n", input);
                    currentBalance -= price;
                    totalSpent += price;
                }

            } else if (input.equals("RoverWatch Origins Edition")) {
                price = 39.99;
                if (price > currentBalance) {
                    System.out.println("Too Expensive");
                }
                if (currentBalance >= price) {
                    System.out.printf("Bought %s%n", input);
                    currentBalance -= price;
                    totalSpent += price;
                }

            } else {
                System.out.println("Not Found");
                continue;
            }

        }

    }
}
