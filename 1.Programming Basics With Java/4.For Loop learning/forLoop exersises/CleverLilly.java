package ForLoopExercise;

import java.util.Scanner;

public class CleverLilly {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int age = Integer.parseInt(scan.nextLine());
        double priceWashingMachine = Double.parseDouble(scan.nextLine());
        int priceToy = Integer.parseInt(scan.nextLine());

        double moneyForBirthday = 0;
        int bro = 0;
        int toys = 0;

        for (int i = 1; i <= age; i++) {

            if (i % 2 == 0) {

                if (i == 2) {
                    moneyForBirthday = 10;
                } else {
                    moneyForBirthday += 10.00 * i / 2;
                }
                bro++;

            } else {
                toys++;
            }

        }

        double toysMoney = toys * priceToy;
        double totalMoney = moneyForBirthday + toysMoney - bro;

        if (priceWashingMachine <= totalMoney) {
            System.out.printf("Yes! %.2f", totalMoney - priceWashingMachine);

        } else {
            System.out.printf("No! %.2f", priceWashingMachine - totalMoney);

        }
    }
}
