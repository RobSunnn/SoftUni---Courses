package MoreExercise.Text.Processing;

import java.util.Scanner;

public class P02AsciiSumator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char first = scanner.nextLine().charAt(0);
        char second = scanner.nextLine().charAt(0);
        String text = scanner.nextLine();

        int sum = 0;


        for (int i = 0; i < text.length(); i++) {

            char current = text.charAt(i);

            if (current > first && current < second) {

                sum += current;
            }
        }

        System.out.println(sum);
    }
}
