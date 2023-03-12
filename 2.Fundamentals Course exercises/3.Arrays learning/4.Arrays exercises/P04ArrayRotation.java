package fundamentals.P08.Arrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P04ArrayRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] damn = scanner.nextLine().split(" ");
        int numberOfRotation = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfRotation; i++) {
            String firstElement = damn[0];

            for (int index = 0; index < damn.length - 1; index++) {
                damn[index] = damn[index + 1];

            }
            damn[damn.length - 1] = firstElement;
        }
        for (String element : damn) {
            System.out.print(element + " ");
        }
    }
}
