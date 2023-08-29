package fundamentals.P03.basicSyntax.moreExercise;

import java.util.Scanner;

public class sortNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());
        int thirdNumber = Integer.parseInt(scanner.nextLine());

        if (firstNumber > secondNumber && firstNumber > thirdNumber && secondNumber > thirdNumber) {
            System.out.printf("%d%n%d%n%d%n", firstNumber, secondNumber, thirdNumber);
        } else if (firstNumber > secondNumber && firstNumber > thirdNumber && thirdNumber > secondNumber) {
            System.out.printf("%d%n%d%n%d%n", firstNumber, thirdNumber, secondNumber);
        } else if (secondNumber > firstNumber && secondNumber > thirdNumber && firstNumber > thirdNumber) {
            System.out.printf("%d%n%d%n%d%n", secondNumber, firstNumber, thirdNumber);
        } else if (secondNumber > firstNumber && secondNumber > thirdNumber && thirdNumber > firstNumber) {
            System.out.printf("%d%n%d%n%d%n", secondNumber, thirdNumber, firstNumber);
        } else if (thirdNumber > firstNumber && thirdNumber > secondNumber && firstNumber > secondNumber) {
            System.out.printf("%d%n%d%n%d%n", thirdNumber, firstNumber, secondNumber);
        } else if (thirdNumber > firstNumber && thirdNumber > secondNumber && secondNumber > firstNumber) {
            System.out.printf("%d%n%d%n%d%n", thirdNumber, secondNumber, firstNumber);
        }
        if (firstNumber > secondNumber && firstNumber > thirdNumber && secondNumber == thirdNumber) {
            System.out.printf("%d%n%d%n%d%n", firstNumber, secondNumber, thirdNumber);
        } else if (secondNumber > firstNumber && secondNumber > thirdNumber && firstNumber == thirdNumber) {
            System.out.printf("%d%n%d%n%d%n", secondNumber, firstNumber, thirdNumber);
        } else if (thirdNumber > firstNumber && thirdNumber > secondNumber && firstNumber == secondNumber) {
            System.out.printf("%d%n%d%n%d%n", thirdNumber, firstNumber, secondNumber);
        }
    }
}
