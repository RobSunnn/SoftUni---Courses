package WhileLoopExercise;

import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double moneyNeeded = Double.parseDouble(scan.nextLine());
        double ownedMoney = Double.parseDouble(scan.nextLine());

        int daysCounter = 0;
        int spendingCounter = 0;

        while (ownedMoney < moneyNeeded && spendingCounter < 5) {

            String command = scan.nextLine();
            double money = Double.parseDouble(scan.nextLine());

            daysCounter++;

            if ("save".equals(command)) {
                ownedMoney += money;
                spendingCounter = 0;
            } else if ("spend".equals(command)) {
                ownedMoney -= money;
                spendingCounter += 1;
                if (ownedMoney < 0) {
                    ownedMoney = 0;
                }
            }
        }
        if (spendingCounter == 5) {
            System.out.println("You can't save the money.");
            System.out.println(daysCounter);
        }
        if (ownedMoney >= moneyNeeded) {
            System.out.printf("You saved the money for %d days.", daysCounter);
        }
    }
}
