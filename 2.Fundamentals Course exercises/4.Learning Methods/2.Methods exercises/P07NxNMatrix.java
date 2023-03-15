package fundamentals.P10.Methods.exercise;

import java.util.Scanner;

public class P07NxNMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        printMatrixNxN(n);

    }

    public static void printLine(int num) {
        for (int i = 1; i <= num; i++) {
            System.out.print(num + " ");
        }
    }

    public static void printMatrixNxN(int num) {
        for (int i = 1; i <= num; i++) {
            printLine(num);
            System.out.println();
        }
    }
}
