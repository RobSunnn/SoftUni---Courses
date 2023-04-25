package P03MultidimensionalArrays.lab;

import java.util.Scanner;

public class P06PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[rows][];


        for (int row = 0; row < rows; row++) {
            String[] input = scanner.nextLine().split("\\s+");

            matrix[row] = input;

        }


        for (int row = 0; row < matrix.length; row++) {

            System.out.print(matrix[row][row] + " ");
        }
        System.out.println();

        for (int row = 0; row < matrix.length; row++) {

            System.out.print(matrix[matrix.length - 1 - row][row] + " ");
        }
    }
}
