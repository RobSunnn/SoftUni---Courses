package basic.exams;

import java.util.Scanner;

public class series {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int seriesCount = Integer.parseInt(scanner.nextLine());
        double totalPrice = 0;

        for (int i = 1; i <= seriesCount; i++) {

            String seriesName = scanner.nextLine();
            double price = Double.parseDouble(scanner.nextLine());

            if (seriesName.equals("Thrones")) {
                price = price - price * 0.5;
            } else if (seriesName.equals("Lucifer")) {
                price = price - price * 0.4;
            } else if (seriesName.equals("Protector")) {
                price = price - price * 0.3;
            } else if (seriesName.equals("TotalDrama")) {
                price = price - price * 0.2;
            } else if (seriesName.equals("Area")) {
                price = price - price * 0.1;
            }
            totalPrice += price;


        }

        if (budget >= totalPrice) {
            System.out.printf("You bought all the series and left with %.2f lv.", budget - totalPrice);
        } else {
            System.out.printf("You need %.2f lv. more to buy the series!", totalPrice - budget);
        }
    }
}
