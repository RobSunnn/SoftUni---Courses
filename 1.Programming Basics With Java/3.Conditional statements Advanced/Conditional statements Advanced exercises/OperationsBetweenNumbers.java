package ConditionalStatementsAdvancedExercise;

import java.util.Scanner;

public class OperationsBetweenNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double n1 = Integer.parseInt(scan.nextLine());
        double n2 = Integer.parseInt(scan.nextLine());
        String operator = scan.nextLine();

        double result = 0;

        if (operator.equals("+")) {
            result = n1 + n2;

            if (result % 2 == 0) {
                System.out.printf("%.0f + %.0f = %.0f - even", n1, n2, result);
            } else if (result % 2 != 0) {
                System.out.printf("%.0f + %.0f = %.0f - odd", n1, n2, result);
            }

        } else if (operator.equals("-")) {

            result = n1 - n2;

            if (result % 2 == 0) {
                System.out.printf("%.0f - %.0f = %.0f - even", n1, n2, result);
            }
            if (result % 2 != 0) {
                System.out.printf("%.0f - %.0f = %.0f - odd", n1, n2, result);
            }

        } else if (operator.equals("*")) {

            result = n1 * n2;

            if (result % 2 == 0) {
                System.out.printf("%.0f * %.0f = %.0f - even", n1, n2, result);
            } else if (result % 2 != 0) {
                System.out.printf("%.0f * %.0f = %.0f - odd", n1, n2, result);
            }

        } else if (operator.equals("/")) {

            if (n1 == 0) {
                System.out.printf("Cannot divide %.0f by zero", n2);
            } else if (n2 == 0) {
                System.out.printf("Cannot divide %.0f by zero", n1);
            } else {
                result = n1 / n2;
                System.out.printf("%.0f / %.0f = %.2f", n1, n2, result);
            }

        } else if (operator.equals("%")) {

            if (n1 == 0) {
                System.out.printf("Cannot divide %.0f by zero", n2);
            } else if (n2 == 0) {
                System.out.printf("Cannot divide %.0f by zero", n1);
            } else {
                result = n1 % n2;
                System.out.printf("%.0f %% %.0f = %.0f", n1, n2, result);
            }
        }

    }

}

