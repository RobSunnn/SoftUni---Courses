package fundamentals.P07.Arrays.lab;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class P03SumEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            int currentElement = numbers[i];
            if (currentElement % 2 == 0) {
                sum += numbers[i];
            }
        }
        System.out.println(sum);
    }
}
