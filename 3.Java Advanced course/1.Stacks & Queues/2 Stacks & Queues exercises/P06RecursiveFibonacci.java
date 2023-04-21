package P02StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P06RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Long> result = new ArrayDeque<>();


        result.push(1L);
        result.push(1L);
        long fibonacci = 0;

        for (int i = 1; i < num; i++) {

            long lastNum = result.peek();
            result.addLast(result.pop());
            long numBeforeLast = result.peek();
            result.pop();

            fibonacci = lastNum + numBeforeLast;
            result.push(fibonacci);
        }
        System.out.println(fibonacci);
    }

}
