package P09FunctionalProgramming.lab.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P09ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] numbs = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        boolean isDivisible = false;


        for (int i = 1; i <= n; i++) {
            for (int num : numbs) {
                if (i % num == 0) {
                    isDivisible = true;
                } else {
                    isDivisible = false;
                    break;
                }

            }
            if (isDivisible) {

                System.out.printf("%d ", i);
            }
        }

    }
}
