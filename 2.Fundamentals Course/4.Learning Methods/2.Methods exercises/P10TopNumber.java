package fundamentals.P10.Methods.exercise;

import java.util.Scanner;

public class P10TopNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int num = 1; num <= n; num++) {
            if (findingIsNumDivisibleByEight(num) && isOneOfTheDigitsOdd(num)) {
                System.out.println(num);
            }
        }
    }

    public static boolean findingIsNumDivisibleByEight(int num) {
        int sum = 0;
        while (num > 0) {
            int lastDigit = num % 10;
            sum += lastDigit;
            num /= 10;
        }
        return sum % 8 == 0;
    }

    public static boolean isOneOfTheDigitsOdd(int num) {
        while (num > 0) {
            int lastDigit = num % 10;
            if (lastDigit % 2 == 1) {
                return true;
            }
            num /= 10;
        }
        return false;
    }
}
