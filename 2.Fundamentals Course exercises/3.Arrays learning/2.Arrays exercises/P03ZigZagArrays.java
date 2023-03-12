package fundamentals.P08.Arrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P03ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] first = new int[n];
        int[] second = new int[n];

        for (int row = 1; row <= n; row++) {
            String numbers = scanner.nextLine();
            int firstNum = Integer.parseInt(numbers.split(" ")[0]);
            int secondNum = Integer.parseInt(numbers.split(" ")[1]);

            if (row % 2 == 0) {
                first[row - 1] = secondNum;
                second[row - 1] = firstNum;
            } else {
                first[row - 1] = firstNum;
                second[row - 1] = secondNum;
            }


        }
        for (int num : first) {
            System.out.print(num + " ");
        }
        System.out.println();
        for (int num : second) {
            System.out.print(num + " ");
        }

    }
}
