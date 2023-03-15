package fundamentals.P10.Methods.exercise;

import java.util.Scanner;

public class P05AddAndSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNumInput = Integer.parseInt(scanner.nextLine());
        int secondNumInput = Integer.parseInt(scanner.nextLine());
        int thirdNumInput = Integer.parseInt(scanner.nextLine());

        System.out.println(subtractNumbers(firstNumInput, secondNumInput, thirdNumInput));


    }

    private static int sumOfNumbers(int firstNum, int secondNum) {

        return firstNum + secondNum;
    }

    private static int subtractNumbers(int firstNum, int secondNum, int thirdNum) {

        return sumOfNumbers(firstNum, secondNum) - thirdNum;
    }
}
