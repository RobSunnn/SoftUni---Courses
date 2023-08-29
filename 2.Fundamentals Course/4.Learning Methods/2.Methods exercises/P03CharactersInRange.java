package fundamentals.P10.Methods.exercise;

import java.util.Scanner;

public class P03CharactersInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char firstInput = scanner.nextLine().charAt(0);
        char secondInput = scanner.nextLine().charAt(0);
        charactersInRange(firstInput, secondInput);

    }

    public static void charactersInRange(char first, char second) {

        for (int i = first + 1; i < second; i++) {
            char symbols = (char) i;
            System.out.print(symbols + " ");
        }
        for (int i = second + 1; i < first; i++) {
            char symbols = (char) i;

            System.out.print(symbols + " ");


        }


    }
}
