package Abstraction.lab;

import java.util.Scanner;

public class RhombusOfStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            printRow(i, n);
        }

        for (int i = n - 1; i >= 0; i--) {
            printRow(i, n);
        }


    }

    private static void printRow(int num, int number) {

        for (int i = 0; i < number - num; i++) {
            System.out.print(" ");
        }

        for (int i = 0; i < num; i++) {
            System.out.print("* ");
        }
        System.out.println();
    }
}
