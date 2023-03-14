package fundamentals.P09.Methods.lab;

import java.text.DecimalFormat;
import java.util.Scanner;

public class P11MathOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double firstNumInput = Double.parseDouble(scanner.nextLine());
        char operatorInput = scanner.nextLine().charAt(0);
        double secondNumInput = Double.parseDouble(scanner.nextLine());
        DecimalFormat df = new DecimalFormat("0.####");

        System.out.println(df.format(calculate(firstNumInput, operatorInput, secondNumInput)));

    }

    public static double calculate(double firstNum, char operator, double secondNum) {
        double result = 0;
        switch (operator) {
            case '/':
                result = firstNum / secondNum;
                break;
            case '*':
                result = firstNum * secondNum;
                break;
            case '+':
                result = firstNum + secondNum;
                break;
            case '-':
                result = firstNum - secondNum;
                break;
        }
        return result;
    }
}
