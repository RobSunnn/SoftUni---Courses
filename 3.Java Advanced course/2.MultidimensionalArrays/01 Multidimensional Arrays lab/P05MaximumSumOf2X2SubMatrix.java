package P03MultidimensionalArrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class P05MaximumSumOf2X2SubMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String rowsAndCols = scanner.nextLine();
        int rows = Integer.parseInt(rowsAndCols.split(",\\s+")[0]);
        int cols = Integer.parseInt(rowsAndCols.split(",\\s+")[1]);
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            int[] input = Arrays.stream(scanner.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();

            for (int col = 0; col < matrix[row].length; col++) {

                matrix[row] = input;
            }
        }

        int maxSum = Integer.MIN_VALUE;
        int firstNumToPrint = 0;
        int secondNumToPrint = 0;
        int thirdNumToPrint = 0;
        int fourthNumToPrint = 0;

        for (int row = 0; row < matrix.length - 1; row++) {

            for (int col = 0; col < matrix[row].length - 1; col++) {

                int firstNum = matrix[row][col];
                int secondNum = matrix[row][col + 1];
                int thirdNum = matrix[row + 1][col];
                int fourthNum = matrix[row + 1][col + 1];
                int result = firstNum + secondNum + thirdNum + fourthNum;

                if (result > maxSum) {

                    maxSum = result;
                    firstNumToPrint = firstNum;
                    secondNumToPrint = secondNum;
                    thirdNumToPrint = thirdNum;
                    fourthNumToPrint = fourthNum;
                }

            }
        }

        System.out.print(firstNumToPrint + " " + secondNumToPrint);
        System.out.println();
        System.out.print(thirdNumToPrint + " " + fourthNumToPrint);
        System.out.println();
        System.out.println(maxSum);

    }
}
