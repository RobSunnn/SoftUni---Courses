package fundamentals.P04.dataTypesAndVariables.lab;

import java.util.Scanner;

public class P06CharToString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char symbol = scanner.nextLine().charAt(0);
        char symbol1 = scanner.nextLine().charAt(0);
        char symbol2 = scanner.nextLine().charAt(0);

        String word = String.format("%c%c%c", symbol, symbol1, symbol2);

        System.out.println(word);
    }
}
