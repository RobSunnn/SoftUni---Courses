package fundamentals.exams;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] commandInput = input.split(" ");
            String command = commandInput[0];

            if (command.equals("swap")) {
                int firstIndex = Integer.parseInt(commandInput[1]);
                int secondIndex = Integer.parseInt(commandInput[2]);
                int oldElement = numbers[firstIndex];
                numbers[firstIndex] = numbers[secondIndex];
                numbers[secondIndex] = oldElement;
            } else if (command.equals("multiply")) {
                int firstIndex = Integer.parseInt(commandInput[1]);
                int secondIndex = Integer.parseInt(commandInput[2]);
                numbers[firstIndex] = numbers[firstIndex] * numbers[secondIndex];
            } else if (command.equals("decrease")) {
                for (int i = 0; i < numbers.length; i++) {
                    numbers[i] = numbers[i] - 1;
                }
            }

            input = scanner.nextLine();
        }
        for (int i = 0; i < numbers.length - 1; i++) {
            System.out.print(numbers[i] + ", ");
        }
        System.out.println(numbers[numbers.length - 1]);
    }
}
