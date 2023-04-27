package P04MultidimensionalArrays.exercise;

import java.util.Scanner;

public class P11ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] rowsAndCols = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(rowsAndCols[0]);
        int cols = Integer.parseInt(rowsAndCols[1]);
        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] input = scanner.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {

                matrix[row][col] = input[col];
            }
        }

        for (int i = cols; i >= 0; i--) {
            int index = rows;
            for (int j = i; j <= cols - 1 && index > 0; j++) {

                if (index > 0) {
                    System.out.print(matrix[index - 1][j] + " ");
                    index--;
                }
            }
            System.out.println();
        }

        if (rows >= 2) {
            for (int i = rows - 2; i >= 0; i--) {

                int index = i;
                for (int j = 0; j <= i && j < cols; j++) {

                    System.out.print(matrix[index][j] + " ");
                    index--;
                }
                System.out.println();
            }
        }
    }
}

