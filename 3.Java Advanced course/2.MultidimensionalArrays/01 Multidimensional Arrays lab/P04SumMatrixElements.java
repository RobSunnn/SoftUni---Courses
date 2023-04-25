package P03MultidimensionalArrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class P04SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String rowsAndCols = scanner.nextLine();
        int rows = Integer.parseInt(rowsAndCols.split(",\\s+")[0]);
        int cols = Integer.parseInt(rowsAndCols.split(",\\s+")[1]);
        int[][] matrix = new int[rows][cols];

        int sum = 0;

        for (int row = 0; row < matrix.length; row++) {
            int[] input = Arrays.stream(scanner.nextLine().split(",\\s+"))
                    .mapToInt(Integer::parseInt).toArray();

            for (int col = 0; col < matrix[row].length; col++) {

                sum += input[col];
            }
        }

        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sum);
    }
}
