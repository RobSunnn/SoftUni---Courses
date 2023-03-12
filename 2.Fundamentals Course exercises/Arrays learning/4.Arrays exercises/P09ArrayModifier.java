package fundamentals.P08.Arrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P09ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String command = scanner.nextLine();

        while (!command.equals("end")) {
            String[] commandInput = command.split(" ");
            String input = commandInput[0];

            switch (input) {

                case "swap":
                    int firstIndex = Integer.parseInt(commandInput[1]);
                    int secondIndex = Integer.parseInt(commandInput[2]);
                    int oldIndex = array[firstIndex];
                    array[firstIndex] = array[secondIndex];
                    array[secondIndex] = oldIndex;
                    break;

                case "multiply":
                    int firstMultiplyIndex = Integer.parseInt(commandInput[1]);
                    int secondMultiplyIndex = Integer.parseInt(commandInput[2]);
                    int multiply = array[firstMultiplyIndex] * array[secondMultiplyIndex];
                    array[firstMultiplyIndex] = multiply;
                    break;

                case "decrease":
                    for (int i = 0; i < array.length; i++) {
                        array[i] = array[i] - 1;
                    }
                    break;
            }


            command = scanner.nextLine();
        }
        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.print(array[array.length - 1]);
    }
}
