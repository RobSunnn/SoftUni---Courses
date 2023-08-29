package fundamentals.P15.TextProcessing.exercise;

import java.util.Scanner;

public class P04CeaserCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        char[] symbols = text.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < symbols.length; i++) {
            symbols[i] = (char) (symbols[i] + 3);
            sb.append(symbols[i]);
        }
        System.out.println(sb);
    }
}
