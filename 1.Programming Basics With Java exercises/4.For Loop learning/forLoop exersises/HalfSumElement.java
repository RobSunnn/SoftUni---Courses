package ForLoopExercise;

import java.util.Scanner;

public class HalfSumElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        int maxValue = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < n; i++) {

            int number = Integer.parseInt(scan.nextLine());
            sum += number;

            if (number > maxValue) {
                maxValue = number;
            }

        }
        int sumWithoutMaxNumber = sum - maxValue;

        if (maxValue == sumWithoutMaxNumber) {
            System.out.printf("Yes%nSum = %d", maxValue);
        } else {
            System.out.printf("No%nDiff = %d", Math.abs(maxValue - sumWithoutMaxNumber));
        }
    }
}
