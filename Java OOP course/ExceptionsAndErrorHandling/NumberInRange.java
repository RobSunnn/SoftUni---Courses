package ExceptionsAndErrorHandling;

import java.util.Scanner;

public class NumberInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] rangeInput = scanner.nextLine().split("\\s+");
        int firstNum = Integer.parseInt(rangeInput[0]);
        int secondNum = Integer.parseInt(rangeInput[1]);

        System.out.printf("Range: [%d...%d]%n", firstNum, secondNum);

        String input = scanner.nextLine();


        while (true) {

            int numInRange = Integer.parseInt(rangeInput[0]) - 1;

            try {
                numInRange = Integer.parseInt(input);
            } catch (IllegalArgumentException ignored) {
            }

            String output = "Invalid number: " + input;

            if (numInRange >= firstNum && numInRange <= secondNum) {
                output = "Valid number: " + input;
                System.out.println(output);
                break;
            }
            System.out.println(output);

            input = scanner.nextLine();
        }


    }
}
