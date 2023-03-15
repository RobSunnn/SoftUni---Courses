package fundamentals.P10.Methods.exercise;

import java.util.Scanner;

public class P06MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String textInput = scanner.nextLine();
        printMiddleCharacter(textInput);

    }

    private static void printMiddleCharacter(String text) {
        if (text.length() % 2 == 1) {
            int index = text.length() / 2;
            System.out.println(text.charAt(index));
        } else {
            int firstIndex = text.length() / 2 - 1;
            int secondIndex = text.length() / 2;
            System.out.println("" + text.charAt(firstIndex) + text.charAt(secondIndex));
        }

    }
}
