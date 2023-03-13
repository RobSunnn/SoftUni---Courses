package fundamentals.P08.Arrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P08MagicSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int num = Integer.parseInt(scanner.nextLine());

        for (int index = 0; index < array.length; index++) {
            int currentNum = array[index];

            for (int i = index; i < array.length - 1; i++) {

                int second = array[i + 1];
                int sum = currentNum + second;
                if (sum == num) {
                    System.out.print("" + currentNum + " " + second);
                    System.out.println();
                }

            }
        }

    }
}
