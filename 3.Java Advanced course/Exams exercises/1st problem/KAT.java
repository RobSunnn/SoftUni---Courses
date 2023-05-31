
package Exams;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P01KAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] licensePlatesArr = scanner.nextLine().split(",\\s+");
        String[] carsArr = scanner.nextLine().split(",\\s+");
        ArrayDeque<Integer> licensePlateStack = new ArrayDeque<>();
        ArrayDeque<Integer> carsQueue = new ArrayDeque<>();
        int daysCount = 0;
        int registeredCars = 0;


        for (int i = licensePlatesArr.length - 1; i >= 0; i--) {

            licensePlateStack.push(Integer.parseInt(licensePlatesArr[i]));
        }

        for (int i = carsArr.length - 1; i >= 0; i--) {

            carsQueue.offer(Integer.parseInt(carsArr[i]));
        }

        while (licensePlateStack.size() > 0 && carsQueue.size() > 0) {
            daysCount++;
            int countPlates = licensePlateStack.pop();
            int countCars = carsQueue.poll();

            int licensePlatesNeeded = countCars * 2;

            if (licensePlatesNeeded <= countPlates) {
                countPlates -= licensePlatesNeeded;
                registeredCars += licensePlatesNeeded / 2;

                if (countPlates != 0) {
                    licensePlateStack.addLast(countPlates);
                }

            } else {

                registeredCars += countPlates / 2;
                countCars -= countPlates / 2;

                if (countCars != 0) {
                    carsQueue.addLast(countCars);
                }


            }
        }

        System.out.printf("%d cars were registered for %d days!%n", registeredCars, daysCount);

        if (licensePlateStack.size() > 0) {
            int sumOfPlates = 0;

            while (licensePlateStack.size() > 0) {

                sumOfPlates += licensePlateStack.pop();
            }
            System.out.printf("%d license plates remain!%n", sumOfPlates);

        } else if (carsQueue.size() > 0) {
            int sumOfCars = 0;

            while (carsQueue.size() > 0) {

                sumOfCars += carsQueue.poll();
            }
            System.out.printf("%d cars remain without license plates!%n", sumOfCars);

        } else {

            System.out.println("Good job! There is no queue in front of the KAT!");
        }
    }
}
