package fundamentals.P03.basicSyntax.moreExercise;

import java.util.Scanner;

public class messages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        char letter = ' ';
        String word = "";

        for (int i = 1; i <= n; i++) {
            int currentNumber = Integer.parseInt(scanner.nextLine());

            if (currentNumber == 2) {
                letter = 'a';
            } else if (currentNumber == 22) {
                letter = 'b';
            } else if (currentNumber == 222) {
                letter = 'c';
            } else if (currentNumber == 3) {
                letter = 'd';
            } else if (currentNumber == 33) {
                letter = 'e';
            } else if (currentNumber == 333) {
                letter = 'f';
            } else if (currentNumber == 4) {
                letter = 'g';
            } else if (currentNumber == 44) {
                letter = 'h';
            } else if (currentNumber == 444) {
                letter = 'i';
            } else if (currentNumber == 5) {
                letter = 'j';
            } else if (currentNumber == 55) {
                letter = 'k';
            } else if (currentNumber == 555) {
                letter = 'l';
            } else if (currentNumber == 6) {
                letter = 'm';
            } else if (currentNumber == 66) {
                letter = 'n';
            } else if (currentNumber == 666) {
                letter = 'o';
            } else if (currentNumber == 7) {
                letter = 'p';
            } else if (currentNumber == 77) {
                letter = 'q';
            } else if (currentNumber == 777) {
                letter = 'r';
            } else if (currentNumber == 7777) {
                letter = 's';
            } else if (currentNumber == 8) {
                letter = 't';
            } else if (currentNumber == 88) {
                letter = 'u';
            } else if (currentNumber == 888) {
                letter = 'v';
            } else if (currentNumber == 9) {
                letter = 'w';
            } else if (currentNumber == 99) {
                letter = 'x';
            } else if (currentNumber == 999) {
                letter = 'y';
            } else if (currentNumber == 9999) {
                letter = 'z';
            } else {
                letter = ' ';
            }
            word += letter;
        }
        System.out.println(word);
    }
}
