package fundamentals.P02.basicSyntax.exercise;

import java.util.Scanner;

public class rageExpenses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lostGamesCount = Integer.parseInt(scanner.nextLine());
        double headsetPrice = Double.parseDouble(scanner.nextLine());
        double mousePrice = Double.parseDouble(scanner.nextLine());
        double keyboardPrice = Double.parseDouble(scanner.nextLine());
        double displayPrice = Double.parseDouble(scanner.nextLine());

        int brokenHeadSetCount = 0;
        int brokenMouseCount = 0;
        int brokenKeyboardCount = 0;
        int brokenDisplayCount = 0;


        for (int i = 1; i <= lostGamesCount; i++) {

            if (i % 2 == 0) {
                brokenHeadSetCount++;
            }

            if (i % 3 == 0) {
                brokenMouseCount++;
            }

            if (i % 6 == 0) {
                brokenKeyboardCount++;
            }
        }

        for (int i = 1; i <= brokenKeyboardCount; i++) {
            if (i % 2 == 0) {
                brokenDisplayCount++;
            }
        }

        double priceBrokenHeadset = brokenHeadSetCount * headsetPrice;
        double priceBrokenMouse = brokenMouseCount * mousePrice;
        double priceBrokenKeyboard = brokenKeyboardCount * keyboardPrice;
        double priceBrokenDisplays = brokenDisplayCount * displayPrice;
        double totalExpenses = priceBrokenHeadset + priceBrokenMouse + priceBrokenKeyboard + priceBrokenDisplays;

        System.out.printf("Rage expenses: %.2f lv.", totalExpenses);
    }
}
