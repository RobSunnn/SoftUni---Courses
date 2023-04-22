package P02StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P08InfixToPostfix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String expression = scanner.nextLine();
        ArrayDeque<Character> output = new ArrayDeque<>();
        ArrayDeque<Character> operatorStack = new ArrayDeque<>();

        for (int i = 0; i < expression.length(); i++) {
            char current = expression.charAt(i);

            if (Character.isDigit(current)) {

                output.offer(current);

            } else if (current == '+' || current == '-' || current == '*' || current == '/') {
                if (!operatorStack.isEmpty()) {
                    char currentOperator = operatorStack.peek();

                    if (currentOperator == '+' || currentOperator == '-') {

                        if (current == '*' || current == '/') {


                        }
                    }
                }
                operatorStack.push(current);
            }

        }
    }
}
