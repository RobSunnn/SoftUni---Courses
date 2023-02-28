package basic.nestedLoops;

import java.util.Scanner;

public class travelling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String destination = scanner.nextLine();


        while (!destination.equals("End")) {

            double budget = Double.parseDouble(scanner.nextLine());
            double sum = 0;

            while (sum < budget) {
                double money = Double.parseDouble(scanner.nextLine());
                sum += money;
            }
            System.out.printf("Going to %s!%n", destination);

            destination = scanner.nextLine();

        }

    }
}
