package P04MultidimensionalArrays.exercise;

import java.util.Scanner;

public class P05MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] rowsAndCols = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(rowsAndCols[0]);
        int cols = Integer.parseInt(rowsAndCols[1]);
        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < matrix.length; row++) {

            String[] inputLine = scanner.nextLine().split("\\s+");

            matrix[row] = inputLine;
        }

        String input = scanner.nextLine();

        while (!input.equals("END")) {

            String[] inputData = input.split("\\s+");

            if (inputData.length != 5) {

                System.out.println("Invalid input!");
                input = scanner.nextLine();
                continue;
            }

            String command = inputData[0];
            int coordinateRowFirst = Integer.parseInt(inputData[1]);
            int coordinateColFirst = Integer.parseInt(inputData[2]);
            int coordinateRowSecond = Integer.parseInt(inputData[3]);
            int coordinateColSecond = Integer.parseInt(inputData[4]);

            if (command.equals("swap")) {

                if (isCoordinateValid(coordinateRowFirst, matrix) || isCoordinateValid(coordinateColFirst, matrix)
                        || isCoordinateValid(coordinateRowSecond, matrix) || isCoordinateValid(coordinateColSecond, matrix)) {

                    String oldElement = matrix[coordinateRowFirst][coordinateColFirst];

                    matrix[coordinateRowFirst][coordinateColFirst] = matrix[coordinateRowSecond][coordinateColSecond];
                    matrix[coordinateRowSecond][coordinateColSecond] = oldElement;

                    for (int row = 0; row < matrix.length; row++) {

                        for (int col = 0; col < matrix[row].length; col++) {

                            System.out.print(matrix[row][col] + " ");
                        }
                        System.out.println();
                    }

                } else {

                    System.out.println("Invalid input!");
                    input = scanner.nextLine();
                    continue;

                }


            } else {

                System.out.println("Invalid input!");
                input = scanner.nextLine();
                continue;
            }

            input = scanner.nextLine();
        }
    }

    private static boolean isCoordinateValid(int n, String[][] table) {

        return n >= 0 && n < table.length;
    }
}
