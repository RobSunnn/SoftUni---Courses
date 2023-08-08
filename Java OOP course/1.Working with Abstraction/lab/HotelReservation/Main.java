package Abstraction.lab.HotelReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        double priceForADay = Double.parseDouble(input[0]);
        int numberOfDays = Integer.parseInt(input[1]);
        Season season = Season.valueOf(input[2]);
        Discount discount = Discount.valueOf(input[3]);

        System.out.printf("%.2f",PriceCalculator.calculatePrice(priceForADay, numberOfDays, season, discount));





    }
}
