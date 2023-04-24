package P03MultidimensionalArrays.lab;

import java.util.Scanner;

public class P02PositionOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputLine = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(inputLine[0]);
        int cols = Integer.parseInt(inputLine[1]);
        int[][] matrix = new int[rows][cols];


        for (int row = 0; row < matrix.length; row++) {
            String[] input = scanner.nextLine().split("\\s+");

            for (int col = 0; col < matrix[row].length; col++) {

                matrix[row][col] = Integer.parseInt(input[col]);
            }
        }

        int numberToCompare = Integer.parseInt(scanner.nextLine());
        boolean isFound = false;
        for (int row = 0; row < matrix.length; row++) {

            for (int col = 0; col < matrix[row].length; col++) {

                if (matrix[row][col] == numberToCompare) {

                    isFound = true;
                    System.out.print(row + " " + col);
                    System.out.println();
                }
            }

        }

        if (!isFound) {

            System.out.println("not found");
        }
    }
}
