package P02StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P04BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] inputArr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int n = inputArr[0];
        int s = inputArr[1];
        int x = inputArr[2];

        int[] sequence = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> deque = new ArrayDeque<>();

        int minNum = Integer.MAX_VALUE;
        boolean isFound = false;

        for (int i = 0; i < n; i++) {
            int currentNum = sequence[i];

            deque.offer(currentNum);
        }
        for (int i = 1; i <= s; i++) {

            deque.poll();
        }

        if (deque.isEmpty()) {
            System.out.println("0");
            return;
        }

        for (int i = 0; i < deque.size(); i++) {

            int currentNum = deque.peek();
            deque.offer(deque.poll());

            if (currentNum < minNum) {

                minNum = currentNum;
            }
            if (currentNum == x) {
                isFound = true;
            }
        }

        if (isFound) {

            System.out.println("true");
        } else {

            System.out.println(minNum);
        }
    }
}
