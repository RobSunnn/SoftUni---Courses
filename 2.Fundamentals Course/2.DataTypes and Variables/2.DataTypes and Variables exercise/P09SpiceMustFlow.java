package fundamentals.P05.dataTypesAndVariables.Exercise;

import java.util.Scanner;

public class P09SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startingYield = Integer.parseInt(scanner.nextLine());
        int yield;
        int totalSpice = 0;
        int daysCount = 0;
        int workers = 26;

        while (startingYield >= 100) {
            daysCount++;
            yield = startingYield;
            yield -= workers;
            totalSpice += yield;
            startingYield -= 10;
            if (startingYield < 100) {
                totalSpice -= workers;
            }
        }
        System.out.println(daysCount);
        System.out.println(totalSpice);
    }
}
