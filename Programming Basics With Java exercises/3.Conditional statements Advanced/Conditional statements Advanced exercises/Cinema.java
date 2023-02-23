package ConditionalStatementsAdvancedExercise;

import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String projectionType = scan.nextLine();
        int r = Integer.parseInt(scan.nextLine());
        int c = Integer.parseInt(scan.nextLine());

        double price = 0.0;

        if (projectionType.equals("Premiere")) {
            price = 12.00;
        } else if (projectionType.equals("Normal")) {
            price = 7.50;
        } else if (projectionType.equals("Discount")) {
            price = 5.00;
        }

        double totalPrice = price * (r * c);

        System.out.printf("%.2f leva", totalPrice);
    }
}
