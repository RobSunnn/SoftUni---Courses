package P02StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P02BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] integers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int n = integers[0];
        int s = integers[1];
        int x = integers[2];
        int[] elements = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        boolean isContained = false;
        int smallestNumber = Integer.MAX_VALUE;

        ArrayDeque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            int currentElement = elements[i];

            deque.push(currentElement);
        }

        for (int i = 0; i < s; i++) {

            deque.pop();
        }
        if (deque.isEmpty()) {

            System.out.println("0");
            return;
        }

        while (!deque.isEmpty()) {
            int currentNum = deque.pop();
            if (currentNum < smallestNumber) {

                smallestNumber = currentNum;
            }

            if (currentNum == x) {

                isContained = true;
            }
        }

        if (isContained) {

            System.out.println("true");
        } else {

            System.out.println(smallestNumber);
        }
    }
}
