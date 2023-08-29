package ConditionalStatementsExercise;

import java.util.Scanner;

public class Shopping {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double budget = Double.parseDouble(scan.nextLine());
        int videoCards = Integer.parseInt(scan.nextLine());
        int processors = Integer.parseInt(scan.nextLine());
        int ramMemory = Integer.parseInt(scan.nextLine());

        double videoCardsPrice = videoCards * 250;
        double processorsPrice = videoCardsPrice * 0.35;
        double ramMemoryPrice = videoCardsPrice * 0.1;


        double processorsTotal = processors * processorsPrice;
        double ramPrice = ramMemory * ramMemoryPrice;
        double totalPrice = videoCardsPrice + processorsTotal + ramPrice;
        if (videoCards > processors) {
            totalPrice = totalPrice - totalPrice * 0.15;
        }
        if (budget >= totalPrice) {
            System.out.printf("You have %.2f leva left!", budget - totalPrice);
        } else {
            System.out.printf("Not enough money! You need %.2f leva more!", totalPrice - budget);
        }


    }
}
