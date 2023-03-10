package fundamentals.P08.Arrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P05TopIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] integers = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < integers.length; i++) {
            boolean isTop = true;

            for (int j = i + 1; j < integers.length; j++) {
                if (integers[i] <= integers[j]) {
                    isTop = false;
                    break;
                }
            }

            if (isTop) {
                System.out.print(integers[i] + " ");
            }


        }


    }
}
