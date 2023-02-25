package basic.exams;

import java.util.Scanner;

public class addBags {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double priceBagsOver20kg = Double.parseDouble(scanner.nextLine());
        double kg = Double.parseDouble(scanner.nextLine());
        int daysLeftTillTrip = Integer.parseInt(scanner.nextLine());
        int bagsCount = Integer.parseInt(scanner.nextLine());

        double tax = 0;
        double priceForBags = 0;

        if (kg < 10) {
            tax = priceBagsOver20kg * 0.2;
        } else if (kg <= 20) {
            tax = priceBagsOver20kg * 0.5;
        } else {
            tax = priceBagsOver20kg;
        }

        if (daysLeftTillTrip > 30) {
            tax = tax + tax * 0.1;

        } else if (daysLeftTillTrip >= 7) {
            tax = tax + tax * 0.15;
        } else {
            tax = tax + tax * 0.4;
        }

        priceForBags = tax * bagsCount;
        System.out.printf("The total price of bags is: %.2f lv.", priceForBags);
    }
}


