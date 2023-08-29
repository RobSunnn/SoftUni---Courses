package fundamentals.P09.Methods.lab;

import java.util.Scanner;

public class P03PrintingTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numInput = Integer.parseInt(scanner.nextLine());

        printTriangle(numInput);
        System.out.println();
    }

    public static void printLine(int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void printTriangle(int n) {
        for (int i = 1; i <= n; i++) {
            printLine(1, i);
        }
        for (int i = n - 1; i >= 1; i--) {
            printLine(1, i);
        }

    }

}
