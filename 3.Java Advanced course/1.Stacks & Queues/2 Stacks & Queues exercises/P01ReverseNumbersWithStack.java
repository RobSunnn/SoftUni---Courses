package P02StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P01ReverseNumbersWithStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] inputNumbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> reversedNumbers = new ArrayDeque<>();

        for (int i = 0; i < inputNumbers.length; i++) {

            int currentNum = inputNumbers[i];

            reversedNumbers.push(currentNum);
        }

        while (!reversedNumbers.isEmpty()) {

            System.out.print(reversedNumbers.pop() + " ");
        }

    }
}
