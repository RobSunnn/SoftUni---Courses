package ConditionalStatementAdvancedLab;

import java.util.Scanner;

public class SmallShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String product = scan.nextLine();
        String city = scan.nextLine();
        double quantity = Double.parseDouble(scan.nextLine());

        double price = 0.0;

        switch (city) {
            case "Sofia":

                if ("coffee".equals(product))
                    price = 0.50;

                else if ("water".equals(product))
                    price = 0.80;

                else if ("beer".equals(product))
                    price = 1.20;

                else if (product.equals("sweets"))
                    price = 1.45;

                else if ("peanuts".equals(product))
                    price = 1.60;

                System.out.printf("%f", quantity * price);
                break;

            case "Plovdiv":
                if ("coffee".equals(product))
                    price = 0.40;

                else if ("water".equals(product))
                    price = 0.70;

                else if ("beer".equals(product))
                    price = 1.15;

                else if ("sweets".equals(product))
                    price = 1.30;

                else if ("peanuts".equals(product))
                    price = 1.50;

                System.out.printf("%f", quantity * price);
                break;

            case "Varna":
                if ("coffee".equals(product))
                    price = 0.45;

                else if ("water".equals(product))
                    price = 0.70;

                else if ("beer".equals(product))
                    price = 1.10;

                else if ("sweets".equals(product))
                    price = 1.35;

                else if ("peanuts".equals(product))
                    price = 1.55;

                System.out.println(quantity * price);
                break;
        }

    }
}
