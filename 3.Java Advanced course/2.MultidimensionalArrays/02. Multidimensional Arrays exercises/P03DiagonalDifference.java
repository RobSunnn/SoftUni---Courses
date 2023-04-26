package P04MultidimensionalArrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P03DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][];

        for (int row = 0; row < size; row++) {
            int[] input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = input;

        }

        int sumOfFirstDiagonal = sumOfFirstDiagonal(matrix);
        int sumSecondDiagonal = sumOfSecondDiagonal(matrix);
        int result = Math.abs(sumOfFirstDiagonal - sumSecondDiagonal);

        System.out.println(result);


    }

    private static int sumOfFirstDiagonal(int[][] table) {
        int sumOfDiagonal = 0;

        for (int row = 0; row < table.length; row++) {

            sumOfDiagonal += table[row][row];

        }

        return sumOfDiagonal;
    }

    private static int sumOfSecondDiagonal(int[][] table) {
        int sumOfDiagonal = 0;
        int col = table.length - 1;

        for (int row = 0; row < table.length; row++) {

            sumOfDiagonal += table[row][col];
            col--;

        }


        return sumOfDiagonal;
    }
}
