package fundamentals.P10.Methods.exercise;

import java.util.Scanner;

public class P08FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstNumInput = Integer.parseInt(scanner.nextLine());
        int secondNumInput = Integer.parseInt(scanner.nextLine());

        long factFirstNum = findingFactorial(firstNumInput);
        long factSecondNum = findingFactorial(secondNumInput);

        double result = factFirstNum * 1.0 / factSecondNum;
        System.out.printf("%.2f", result);

    }

    private static long findingFactorial(long num) {
        long result = 1;
        for (int i = 1; i <= num; i++) {
            result = result * i;
        }
        return result;
    }

}
