package fundamentals.P04.dataTypesAndVariables.lab;

import java.util.Scanner;

public class P07ReversedChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char symbol1 = scanner.nextLine().charAt(0);
        char symbol2 = scanner.nextLine().charAt(0);
        char symbol3 = scanner.nextLine().charAt(0);

        String word = String.format("%c %c %c", symbol3, symbol2, symbol1);

        System.out.println(word);
    }
}
