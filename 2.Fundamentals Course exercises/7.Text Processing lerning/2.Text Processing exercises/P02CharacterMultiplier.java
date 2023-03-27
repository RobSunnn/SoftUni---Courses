package fundamentals.P15.TextProcessing.exercise;

import java.util.Scanner;

public class P02CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputLine = scanner.nextLine().split(" ");
        String firstWord = inputLine[0];
        String secondWord = inputLine[1];

        System.out.println(returnsSumOfMultipliedChars(firstWord, secondWord));

    }

    public static int returnsSumOfMultipliedChars(String firstWord, String secondWord) {
        int sum = 0;

        int minLength = Math.min(firstWord.length(), secondWord.length());

        for (int i = 0; i < minLength; i++) {

            char first = firstWord.charAt(i);
            char second = secondWord.charAt(i);
            int result = first * second;

            sum += result;
        }

        if (firstWord.length() > secondWord.length()) {

            for (int i = minLength; i <= firstWord.length() - 1; i++) {

                sum += firstWord.charAt(i);
            }

        } else {

            for (int i = minLength; i <= secondWord.length() - 1; i++) {

                sum += secondWord.charAt(i);
            }
        }


        return sum;
    }

}
