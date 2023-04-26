package P04MultidimensionalArrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P04MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] rowsAndCols = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(rowsAndCols[0]);
        int cols = Integer.parseInt(rowsAndCols[1]);
        int[][] matrix = new int[rows][cols];
        int[][] squareMaxMatrix = new int[3][3];

        for (int row = 0; row < matrix.length; row++) {
            int[] inputLine = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

            for (int col = 0; col < matrix[row].length; col++) {

                matrix[row][col] = inputLine[col];
            }
        }
        int maxSum = Integer.MIN_VALUE;

        for (int row = 0; row < matrix.length - 2; row++) {

            for (int col = 0; col < matrix[row].length - 2; col++) {

                int firstNumToCheck = matrix[row][col];
                int secondNumToCheck = matrix[row][col + 1];
                int thirdNumToCheck = matrix[row][col + 2];
                int fourthNumToCheck = matrix[row + 1][col];
                int fifthNumToCheck = matrix[row + 1][col + 1];
                int sixthNumToCheck = matrix[row + 1][col + 2];
                int seventhNumToCheck = matrix[row + 2][col];
                int eightNumToCheck = matrix[row + 2][col + 1];
                int ninthNumToCheck = matrix[row + 2][col + 2];

                int sumOfNumbers = firstNumToCheck + secondNumToCheck + thirdNumToCheck + fourthNumToCheck
                        + fifthNumToCheck + sixthNumToCheck + seventhNumToCheck + eightNumToCheck + ninthNumToCheck;


                if (sumOfNumbers > maxSum) {
                    maxSum = sumOfNumbers;

                    squareMaxMatrix[0][0] = matrix[row][col];
                    squareMaxMatrix[0][1] = matrix[row][col + 1];
                    squareMaxMatrix[0][2] = matrix[row][col + 2];
                    squareMaxMatrix[1][0] = matrix[row + 1][col];
                    squareMaxMatrix[1][1] = matrix[row + 1][col + 1];
                    squareMaxMatrix[1][2] = matrix[row + 1][col + 2];
                    squareMaxMatrix[2][0] = matrix[row + 2][col];
                    squareMaxMatrix[2][1] = matrix[row + 2][col + 1];
                    squareMaxMatrix[2][2] = matrix[row + 2][col + 2];


                }
            }
        }

        System.out.printf("Sum = %d%n", maxSum);

        for (int row = 0; row < squareMaxMatrix.length; row++) {

            for (int col = 0; col < squareMaxMatrix[row].length; col++) {

                System.out.print(squareMaxMatrix[row][col] + " ");
            }
            System.out.println();
        }


    }


}
