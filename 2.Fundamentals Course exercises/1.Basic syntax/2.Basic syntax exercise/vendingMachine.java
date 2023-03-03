package fundamentals.P02.basicSyntax.exercise;

import java.util.Scanner;

public class vendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String product = "";
        double priceProduct = 0;
        double totalMoney = 0;

        while (!input.equals("Start")) {
            double coins = Double.parseDouble(input);

            if (coins == 2 || coins == 1 || coins == 0.50 || coins == 0.20 || coins == 0.10) {
                totalMoney += coins;
            } else {
                System.out.printf("Cannot accept %.2f%n", coins);
            }

            input = scanner.nextLine();

            if (input.equals("Start")) {
                product = scanner.nextLine();

                while (!product.equals("End")) {
                    if (product.equals("Nuts")) {
                        priceProduct = 2.0;
                    } else if (product.equals("Water")) {
                        priceProduct = 0.7;
                    } else if (product.equals("Crisps")) {
                        priceProduct = 1.5;
                    } else if (product.equals("Soda")) {
                        priceProduct = 0.8;
                    } else if (product.equals("Coke")) {
                        priceProduct = 1.0;
                    } else {
                        System.out.println("Invalid product");
                    }
                    if (priceProduct != 0) {
                        if (totalMoney >= priceProduct) {
                            System.out.printf("Purchased %s%n", product);
                            totalMoney -= priceProduct;
                        } else {
                            System.out.println("Sorry, not enough money");
                        }
                    }

                    product = scanner.nextLine();
                }

            }
        }
        if (totalMoney >= 0) {
            System.out.printf("Change: %.2f", totalMoney);
        }

    }
}
