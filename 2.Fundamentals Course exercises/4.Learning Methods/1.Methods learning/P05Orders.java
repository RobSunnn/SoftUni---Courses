package fundamentals.P09.Methods.lab;

import java.util.Scanner;

public class P05Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String productInput = scanner.nextLine();
        int countProduct = Integer.parseInt(scanner.nextLine());

        printPrice(productInput, countProduct);


    }

    public static void printPrice(String product, int count) {
        double price = 0.0;
        switch (product) {
            case "coffee":
                price = 1.50;
                double resultCoffee = price * count;
                System.out.printf("%.2f", resultCoffee);
                break;
            case "water":
                price = 1.00;
                double resultWater = price * count;
                System.out.printf("%.2f", resultWater);
                break;
            case "coke":
                price = 1.40;
                double resultCoke = price * count;
                System.out.printf("%.2f", resultCoke);
                break;
            case "snacks":
                price = 2.00;
                double resultSnacks = price * count;
                System.out.printf("%.2f", resultSnacks);
                break;
        }
    }
}
