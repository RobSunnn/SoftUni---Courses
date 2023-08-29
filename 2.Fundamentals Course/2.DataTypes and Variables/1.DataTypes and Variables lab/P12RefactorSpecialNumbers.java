package fundamentals.P04.dataTypesAndVariables.lab;

import java.util.Scanner;

public class P12RefactorSpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        boolean isTrue = false;

        for (int i = 1; i <= number; i++) {

            int currentNum = i;
            int sum = 0;

            while (currentNum > 0) {
                sum += currentNum % 10;
                currentNum = currentNum / 10;
            }

            isTrue = (sum == 5) || (sum == 7) || (sum == 11);

            if (!isTrue) {
                System.out.printf("%d -> False%n", i);
            } else {
                System.out.printf("%d -> True%n", i);
            }
        }
    }
}

