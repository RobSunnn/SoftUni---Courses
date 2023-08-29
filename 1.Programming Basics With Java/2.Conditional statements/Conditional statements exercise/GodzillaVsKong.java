package ConditionalStatementsExercise;

import java.util.Scanner;

public class GodzillaVsKong {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double budget = Double.parseDouble(scan.nextLine());
        int actors = Integer.parseInt(scan.nextLine());
        double priceForAnActor = Double.parseDouble(scan.nextLine());

        double decor = budget * 0.10;
        double priceForClothing = actors * priceForAnActor;

        if (actors > 150) {
            priceForClothing = priceForClothing - priceForClothing * 0.10;
        }

        double totalPriceFoTheMovie = decor + priceForClothing;
        double totalPrice = budget - totalPriceFoTheMovie;

        if (budget >= totalPriceFoTheMovie) {
            System.out.printf("Action!%nWingard starts filming with %.2f leva left.", totalPrice);
        } else {
            System.out.printf("Not enough money!%nWingard needs %.2f leva more.", Math.abs(totalPrice));
        }
    }
}
