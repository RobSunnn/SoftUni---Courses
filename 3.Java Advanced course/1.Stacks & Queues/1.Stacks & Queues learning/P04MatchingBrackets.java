package P01StacksAndQueues.lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P04MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<String> matchingBrackets = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            if (current == '(') {

                matchingBrackets.push(String.valueOf(i));
            } else if (current == ')') {

                int startIndex = Integer.parseInt(matchingBrackets.pop());
                String substring = input.substring(startIndex, i + 1);
                System.out.println(substring);
            }
        }
    }
}
