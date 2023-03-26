package fundamentals.P14.TextProcessing.lab;

import java.util.Scanner;

public class P04TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] banWords = scanner.nextLine().split(", ");
        String text = scanner.nextLine();

        for (String banWord : banWords) {
            if (text.contains(banWord)) {
                String replacement = repeat("*", banWord.length());
                text = text.replace(banWord, replacement);
            }
        }
        System.out.println(text);

    }

    private static String repeat(String str, int length) {
        StringBuilder replacement = new StringBuilder();
        for (int i = 0; i < length; i++) {
            replacement.append(str);
        }
        return replacement.toString();
    }
}
