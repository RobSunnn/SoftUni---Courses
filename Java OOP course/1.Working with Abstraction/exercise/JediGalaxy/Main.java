package Abstraction.exercise.JediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = readingFromConsole(scanner);
        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];

        fillingMatrix(rows, cols, matrix);

        String command = scanner.nextLine();

        long sum = 0;

        sum = collectedStars(scanner, matrix, command, sum);

        System.out.println(sum);


    }

    private static long collectedStars(Scanner scanner, int[][] matrix, String command, long sum) {
        while (!command.equals("Let the Force be with you")) {
            int[] ivoS = readingCommand(command);
            int[] evil = readingFromConsole(scanner);
            int rowEvil = evil[0];
            int colEvil = evil[1];

            movingEvil(matrix, rowEvil, colEvil);

            int rowJedi = ivoS[0];
            int colJedi = ivoS[1];

            sum = movingJedi(matrix, sum, rowJedi, colJedi);

            command = scanner.nextLine();
        }
        return sum;
    }

    private static long movingJedi(int[][] matrix, long sum, int rowJedi, int colJedi) {
        while (rowJedi >= 0 && colJedi < matrix[1].length) {
            if (rowJedi < matrix.length && colJedi >= 0 && colJedi < matrix[0].length) {
                sum += matrix[rowJedi][colJedi];
            }

            colJedi++;
            rowJedi--;
        }
        return sum;
    }

    private static void movingEvil(int[][] matrix, int rowEvil, int colEvil) {
        while (rowEvil >= 0 && colEvil >= 0) {
            if (rowEvil < matrix.length && colEvil < matrix[0].length) {
                matrix[rowEvil][colEvil] = 0;
            }
            rowEvil--;
            colEvil--;
        }
    }

    private static int[] readingCommand(String command) {
        return Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    private static int[] readingFromConsole(Scanner scanner) {
        return readingCommand(scanner.nextLine());
    }

    private static void fillingMatrix(int rows, int cols, int[][] matrix) {
        int value = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = value++;
            }
        }
    }
}
