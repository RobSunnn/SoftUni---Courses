package fundamentals.P06.dataTypesAndVariables.MoreExercise;

import java.util.Scanner;

public class P05DecryptingMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        byte key = Byte.parseByte(scanner.nextLine());
        byte n = Byte.parseByte(scanner.nextLine());

        String word = "";

        for (int i = 1; i <= n; i++) {
            char symbol = scanner.nextLine().charAt(0);
            symbol += key;
            word += symbol;
        }
        System.out.println(word);
    }
}
