package ConditionalStatementsExercise;

import java.util.Scanner;

public class ToyShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double tripPrice = Double.parseDouble(scan.nextLine());
        int puzzles = Integer.parseInt(scan.nextLine());
        int dolls = Integer.parseInt(scan.nextLine());
        int bears = Integer.parseInt(scan.nextLine());
        int minions = Integer.parseInt(scan.nextLine());
        int trucks = Integer.parseInt(scan.nextLine());


        int countToys = puzzles + dolls + bears + minions + trucks;
        double totalPrice = puzzles * 2.60 + dolls * 3.00 + bears * 4.10 + minions * 8.20 + trucks * 2.00;


        if (countToys >= 50) {
            totalPrice = totalPrice - (totalPrice * 0.25);
        }
        totalPrice = totalPrice - (totalPrice * 0.10);


        if (totalPrice >= tripPrice) {
            System.out.printf("Yes! %.2f lv left.", totalPrice - tripPrice);
        } else {
            System.out.printf("Not enough money! %.2f lv needed.", Math.abs(totalPrice - tripPrice));
        }


    }
}
