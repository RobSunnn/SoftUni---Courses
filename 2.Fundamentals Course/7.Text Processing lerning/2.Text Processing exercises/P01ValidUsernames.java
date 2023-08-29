package fundamentals.P15.TextProcessing.exercise;

import java.util.IllegalFormatCodePointException;
import java.util.Scanner;

public class P01ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        for (String word : input) {
            if (wordIsValid(word)) {
                System.out.println(word);
            }
        }

    }

    private static boolean wordIsValid(String word) {
        char[] symbols = word.toCharArray();
        if (word.length() < 3 || word.length() > 16) {
            return false;
        }
        for (char symbol : symbols) {
            if (!Character.isLetterOrDigit(symbol) && !(symbol == '-') && !(symbol == '_')) {
                return false;
            }
        }
        return true;

    }
}
