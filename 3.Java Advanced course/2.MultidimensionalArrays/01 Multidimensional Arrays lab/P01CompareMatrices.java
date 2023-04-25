package P03MultidimensionalArrays.lab;

import java.util.Scanner;

public class P01CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        int rowsFirst = Integer.parseInt(input[0]);
        int colsFirst = Integer.parseInt(input[1]);

        int[][] matrix = new int[rowsFirst][colsFirst];

        for (int row = 0; row < matrix.length; row++) {
            String[] inputLine = scanner.nextLine().split("\\s+");

            for (int col = 0; col < matrix[row].length; col++) {

                matrix[row][col] = Integer.parseInt(inputLine[col]);
            }
        }

        input = scanner.nextLine().split("\\s+");

        int rowsSecond = Integer.parseInt(input[0]);
        int colsSecond = Integer.parseInt(input[1]);
        int[][] secondMatrix = new int[rowsSecond][colsSecond];

        if (rowsFirst != rowsSecond || colsFirst != colsSecond) {

            System.out.println("not equal");
            return;
        }

        for (int row = 0; row < secondMatrix.length; row++) {
            String[] inputLine = scanner.nextLine().split("\\s+");

            for (int col = 0; col < secondMatrix[row].length; col++) {

                secondMatrix[row][col] = Integer.parseInt(inputLine[col]);
            }
        }

        boolean areEqual = true;

        for (int row = 0; row < matrix.length; row++) {

            for (int col = 0; col < matrix[row].length; col++) {

                if (matrix[row][col] != secondMatrix[row][col]) {

                    areEqual = false;

                }
            }
            if (!areEqual) {

                break;
            }
        }

        if (areEqual) {

            System.out.println("equal");
        } else {

            System.out.println("not equal");
        }
    }
}
