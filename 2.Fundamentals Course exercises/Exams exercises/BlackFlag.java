package fundamentals.exams;

import java.util.Scanner;

public class BlackFlag {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        byte dailyPlunder = Byte.parseByte(scanner.nextLine());
        double expectedPlunder = Double.parseDouble(scanner.nextLine());
        double totalPlunder = 0.0;
        int daysCounter = 0;

        for (int i = 1; i <= days; i++) {
            totalPlunder += dailyPlunder;
            daysCounter++;

            if (daysCounter % 3 == 0) {

                totalPlunder += dailyPlunder * 0.5;
            }

            if (daysCounter % 5 == 0) {

                totalPlunder -= totalPlunder * 0.3;
            }

        }

        if (totalPlunder >= expectedPlunder) {

            System.out.printf("Ahoy! %.2f plunder gained.%n", totalPlunder);
        } else {
            double percent = (totalPlunder / expectedPlunder) * 100;

            System.out.printf("Collected only %.2f%% of the plunder.%n", percent);
        }
    }
}
