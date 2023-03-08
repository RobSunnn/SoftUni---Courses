package fundamentals.P06.dataTypesAndVariables.MoreExercise;

import java.util.Scanner;

public class P04RefactoringPrimeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 2; i <= n; i++) {

            boolean isTrue = true;

            for (int subtract = 2; subtract < i; subtract++) {

                if (i % subtract == 0) {

                    isTrue = false;

                    break;

                }

            }

            System.out.printf("%d -> %b%n", i, isTrue);

        }
    }
}
