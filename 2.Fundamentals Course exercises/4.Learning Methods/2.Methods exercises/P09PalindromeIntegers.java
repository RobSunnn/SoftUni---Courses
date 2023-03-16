package fundamentals.P10.Methods.exercise;

import java.util.Scanner;

public class P09PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        while (!input.equals("END")) {
            palindromeIntegers(input);

            input = scanner.nextLine();
        }
    }

    private static void palindromeIntegers(String textInput) {

        String[] text = textInput.split("");
        String[] newInput = new String[text.length];
        for (int i = 0; i < text.length; i++) {
            newInput[newInput.length - 1 - i] = text[i];
        }
        String newText = "" + String.join("", text);
        String newNewInput = "" + String.join("", newInput);
        if (newText.equals(newNewInput)) {
            System.out.println("true");
            ;
        } else {
            System.out.println("false");
        }
    }
}
