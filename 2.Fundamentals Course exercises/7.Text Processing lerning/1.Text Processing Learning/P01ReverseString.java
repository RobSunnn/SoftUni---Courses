package fundamentals.P14.TextProcessing.lab;

import java.util.Scanner;

public class P01ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();


        while (!command.equals("end")) {
            StringBuilder reversed = new StringBuilder();

            for (int i = command.length() - 1; i >= 0; i--) {
                char current = command.charAt(i);

                reversed.append(current);
            }

            System.out.printf("%s = %s%n", command, reversed);
            command = scanner.nextLine();
        }

    }
}
