package ExceptionsAndErrorHandling;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EnterNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = new ArrayList<>();
        int start = 1;
        while (numbers.size() < 10) {

            try {
                start = readNumber(start, 100, scanner);
                numbers.add(start);
            } catch (NumberFormatException e) {
                System.out.println("Invalid Number!");
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }

        }

        for (int i = 0; i < numbers.size() - 1; i++) {
            System.out.printf("%d, ", numbers.get(i));
        }
        System.out.println(numbers.get(numbers.size() - 1));

    }

    private static int readNumber(int start, int end, Scanner scanner) {
        int number = Integer.parseInt(scanner.nextLine());
        if (number <= start || number >= end) {
            throw new IllegalStateException("Your number is not in range " + start + " - 100!");
        }
        return number;
    }
}
