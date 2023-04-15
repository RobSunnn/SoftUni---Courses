package P01StacksAndQueues.lab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class P02SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> numbs = new ArrayDeque<>();
        String[] input = scanner.nextLine().split(" ");
      
        for (int i = 0; i < input.length; i++) {
            String currentElement = input[i];
            numbs.add(currentElement);
        }

        int result = 0;

        while (numbs.size() > 0) {

            String current = numbs.pop();
            if (current.equals("+")) {
                int num = Integer.parseInt(numbs.pop());
                result += num;

            } else if (current.equals("-")) {
                int num = Integer.parseInt(numbs.pop());
                result -= num;

            } else {

                result = Integer.parseInt(current);
            }
        }

        System.out.println(result);
    }
}
