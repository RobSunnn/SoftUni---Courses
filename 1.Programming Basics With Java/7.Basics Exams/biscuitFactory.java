package basic.exams;

import java.util.Scanner;

public class biscuitFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int biscuitPerDayPerWorker = Integer.parseInt(scanner.nextLine());
        int workersCount = Integer.parseInt(scanner.nextLine());
        double competingFactory = Integer.parseInt(scanner.nextLine());
        double totalBiscuits = 0;

        int countDays = 0;

        for (int i = 1; i <= 30; i++) {
            countDays++;
            double biscuitsForADay = biscuitPerDayPerWorker * workersCount;
            if (countDays == 3) {

                biscuitsForADay = Math.floor(biscuitsForADay * 1.0 * 0.75);
                countDays = 0;
            }

            totalBiscuits += biscuitsForADay;

        }

        double diff = totalBiscuits - competingFactory;
        double percent = diff / competingFactory;
        System.out.printf("You have produced %.0f count biscuits for the past month.%n", totalBiscuits);

        if (totalBiscuits > competingFactory) {
            System.out.printf("You produce %.2f percent more biscuits.", percent * 100);
        } else {
            System.out.printf("You produce %.2f percent less biscuits.", Math.abs(percent * 100));
        }
    }
}
