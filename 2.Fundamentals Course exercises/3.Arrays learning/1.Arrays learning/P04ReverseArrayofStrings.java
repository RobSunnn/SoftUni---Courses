package fundamentals.P07.Arrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class P04ReverseArrayofStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] element = scanner.nextLine().split(" ");

        for (int i = 0; i < element.length / 2; i++) {
            String oldElement = element[i];
            element[i] = element[element.length - 1 - i];
            element[element.length - 1 - i] = oldElement;
        }
        System.out.print(String.join(" ", element));
    }
}
