package P04MultidimensionalArrays.exercise;

import java.util.Scanner;

public class P02MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] rowsAndCols = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(rowsAndCols[0]);
        int cols = Integer.parseInt(rowsAndCols[1]);
        String[][] matrix = new String[rows][cols];

        fillingMatrix(rows, cols, matrix);
        printMatrix(matrix);


    }

    private static void fillingMatrix(int r, int c, String[][] table) {

        StringBuilder builder = new StringBuilder();

        for (int row = 0; row < table.length; row++) {


            for (int col = 0; col < table[row].length; col++) {

                char first = (char) (row + 97);
                char last = (char) (row + 97);
                char middle = (char) (row + col + 97);
                builder.append(first);
                builder.append(middle);
                builder.append(last);

                table[row][col] = builder.toString();

                builder = new StringBuilder();
            }


        }

    }

    private static void printMatrix(String[][] table) {

        for (int i = 0; i < table.length; i++) {

            for (int j = 0; j < table[i].length; j++) {

                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
    }
}
