package P03MultidimensionalArrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class P08WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[n][];

        for (int row = 0; row < n; row++) {

            int[] input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = input;

        }
        int[] coordinates = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int row = coordinates[0];
        int col = coordinates[1];

        int upNum = 0;
        int rightNum = 0;
        int downNum = 0;
        int leftNum = 0;


        int wrongNum = matrix[row][col];
        int[][] rightMatrix = new int[n][];

        for (int i = 0; i < matrix.length; i++) {

            rightMatrix = matrix.clone();
        }


        for (int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {

            for (int colIndex = 0; colIndex < matrix[rowIndex].length; colIndex++) {

                if (matrix[rowIndex][colIndex] == wrongNum) {


                    int sum = 0;

                    if (rowIndex > 0) {

                        if (matrix[rowIndex - 1][colIndex] != wrongNum) {

                            upNum = matrix[rowIndex - 1][colIndex];
                        }

                    }
                    if (colIndex < matrix[rowIndex].length - 1) {

                        if (matrix[rowIndex][colIndex + 1] != wrongNum) {

                            rightNum = matrix[rowIndex][colIndex + 1];
                        }

                    }
                    if (rowIndex < matrix.length - 1) {

                        if (matrix[rowIndex + 1][colIndex] != wrongNum) {

                            downNum = matrix[rowIndex + 1][colIndex];

                        }

                    }
                    if (colIndex > 0) {

                        if (matrix[rowIndex][colIndex - 1] != wrongNum) {

                            leftNum = matrix[rowIndex][colIndex - 1];

                        }

                    }

                    sum += upNum + downNum + rightNum + leftNum;

                    rightMatrix[rowIndex][colIndex] = sum;

                    upNum = 0;
                    downNum = 0;
                    leftNum = 0;
                    rightNum = 0;


                }
            }


        }
        for (int i = 0; i < rightMatrix.length; i++) {

            for (int j = 0; j < rightMatrix[i].length; j++) {

                System.out.print(rightMatrix[i][j] + " ");
            }
            System.out.println();
        }

    }

}
