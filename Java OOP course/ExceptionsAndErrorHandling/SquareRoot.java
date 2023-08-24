package ExceptionsAndErrorHandling;

import java.util.Scanner;

public class SquareRoot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        try {
            int number = Integer.parseInt(input);
            System.out.printf("%.2f%n", sqrtOfNumber(number));
        } catch (IllegalArgumentException ignored) {
            System.out.println("Invalid");
        } finally {
            System.out.println("Goodbye");
        }


    }

    private static double sqrtOfNumber(double number) {
        if (number < 0) {
            throw new IllegalArgumentException("Invalid number");
        }
        return Math.sqrt(number);
    }
}
