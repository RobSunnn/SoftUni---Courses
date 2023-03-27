package fundamentals.P15.TextProcessing.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P08LettersChangeNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        double sum = 0;


        for (int i = 0; i < input.length; i++) {

            char firstLetter = input[i].charAt(0);
            char secondLetter = input[i].charAt(input[i].length() - 1);
            double number = Double.parseDouble(input[i].replace(input[i].charAt(0), ' ').replace(input[i].charAt(input[i].length() - 1), ' ').trim());

            if (firstLetter >= 65 && firstLetter <= 90) {
                double numberToDivide = firstLetter - 64;
                number = number / numberToDivide;

            } else if (firstLetter >= 97 && firstLetter <= 122) {
                double numberToMultiply = firstLetter - 96;
                number = number * numberToMultiply;

            }
            if (secondLetter >= 65 && secondLetter <= 90) {
                double numberToSubtract = secondLetter - 64;
                number = number - numberToSubtract;

            } else if (secondLetter >= 97 && secondLetter <= 122) {
                double numberToAdd = secondLetter - 96;
                number = number + numberToAdd;

            }
            sum += number;

        }

        System.out.printf("%.2f", sum);


    }
}
