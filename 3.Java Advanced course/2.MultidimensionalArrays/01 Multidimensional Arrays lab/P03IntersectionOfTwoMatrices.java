package P03MultidimensionalArrays.lab;

import java.util.Scanner;

public class P03IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[rows][cols];
        String[][] secondMatrix = new String[rows][cols];
        String[][] thirdMatrix = new String[rows][cols];


        for (int row = 0; row < matrix.length; row++) {
            String[] inputLine = scanner.nextLine().split("\\s+");

            for (int col = 0; col < matrix[row].length; col++) {

                matrix[row][col] = inputLine[col];
            }
        }

        for (int row = 0; row < secondMatrix.length; row++) {
            String[] inputLine = scanner.nextLine().split("\\s+");

            for (int col = 0; col < secondMatrix[row].length; col++) {

                secondMatrix[row][col] = inputLine[col];
            }
        }

        for (int row = 0; row < matrix.length; row++) {

            for (int col = 0; col < matrix[row].length; col++) {

                if (!matrix[row][col].equals(secondMatrix[row][col])) {

                    thirdMatrix[row][col] = "*";

                } else {

                    thirdMatrix[row][col] = matrix[row][col];
                }
            }
        }

        for (int row = 0; row < thirdMatrix.length; row++) {

            for (int col = 0; col < thirdMatrix[row].length; col++) {

                System.out.print(thirdMatrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
