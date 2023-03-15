package fundamentals.P10.Methods.exercise;

import java.util.Scanner;

public class P02VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String wordInput = scanner.nextLine();
        vowelsCountOfAWord(wordInput);

    }

    public static void vowelsCountOfAWord(String word) {
        int counter = 0;
        for (int i = 0; i < word.length(); i++) {
            char currentSymbol = word.charAt(word.length() - 1 - i);
            if (currentSymbol == 'a' || currentSymbol == 'e' || currentSymbol == 'i' ||
                    currentSymbol == 'o' || currentSymbol == 'u'
                    || currentSymbol == 'A' || currentSymbol == 'E' ||
                    currentSymbol == 'I' || currentSymbol == 'O' || currentSymbol == 'U') {

                counter++;
            }
        }

        System.out.println(counter);
    }
}
