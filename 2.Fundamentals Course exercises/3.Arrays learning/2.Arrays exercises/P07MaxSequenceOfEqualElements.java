package fundamentals.P08.Arrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P07MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int maxCount = 0;
        int digit = 0;
        int counter = 1;

        for (int i = 1; i < array.length; i++) {
            if (array[i] == (array[i - 1])) {
                counter++;

                if (counter > maxCount) {
                    maxCount = counter;
                    digit = array[i];
                }
            } else {
                counter = 1;
            }

        }
        for (int i = 0; i < maxCount; i++) {
            System.out.print(digit + " ");
        }


    }
}
