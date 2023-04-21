package P02StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P05BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Character> stack = new ArrayDeque<>();

        String input = scanner.nextLine();
        boolean areBalanced = true;

        if (input.length() % 2 == 1) {
            System.out.println("NO");
            return;
        }

        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);

            switch (symbol) {

                case '(':
                case '[':
                case '{':
                    stack.push(symbol);
                    break;
                case ')':
                case ']':
                case '}':

                    if (!stack.isEmpty()) {

                        char lastSymbol = stack.pop();

                        if (lastSymbol == '(' && symbol == ')') {

                            areBalanced = true;
                        } else if (lastSymbol == '[' && symbol == ']') {

                            areBalanced = true;
                        } else if (lastSymbol == '{' && symbol == '}') {

                            areBalanced = true;
                        } else {

                            areBalanced = false;
                            break;
                        }
                    }

                    break;

            }
            if (!areBalanced) {

                break;
            }

        }
        if (areBalanced) {

            System.out.println("YES");
        } else {

            System.out.println("NO");
        }
    }
}
