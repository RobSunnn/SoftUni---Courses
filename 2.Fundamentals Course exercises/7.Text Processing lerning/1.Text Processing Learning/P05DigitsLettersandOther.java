package fundamentals.P14.TextProcessing.lab;

import java.util.Scanner;

public class P05DigitsLettersandOther {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();

        StringBuilder digits = new StringBuilder();
        StringBuilder letters = new StringBuilder();
        StringBuilder other = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            char current = word.charAt(i);

            if (Character.isDigit(current)) {
                digits.append(current);
            } else if (Character.isLetter(current)) {
                letters.append(current);
            } else {
                other.append(current);
            }
        }
        System.out.println(digits);
        System.out.println(letters);
        System.out.println(other);
    }
}
