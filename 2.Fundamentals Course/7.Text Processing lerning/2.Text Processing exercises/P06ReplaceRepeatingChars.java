package fundamentals.P15.TextProcessing.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P06ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        char[] sequence = text.toCharArray();
        List<Character> textToPrint = new ArrayList<>();

        for (char symbol : sequence) {
            textToPrint.add(symbol);
        }

        for (int i = 1; i < textToPrint.size(); i++) {
            char first = textToPrint.get(i);
            char second = textToPrint.get(i - 1);

            if (first == second) {
                textToPrint.remove(i);
                i--;
            }
        }
        for (char symbol : textToPrint) {
            System.out.print(symbol);
        }

    }
}
