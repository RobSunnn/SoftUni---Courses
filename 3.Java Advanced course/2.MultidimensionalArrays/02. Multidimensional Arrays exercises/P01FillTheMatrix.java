package P04MultidimensionalArrays.exercise;

import java.util.Scanner;

public class P01FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(",\\s+");
        int size = Integer.parseInt(input[0]);
        String wayOfFilling = input[1];
        int[][] matrix = new int[size][size];

        switch (wayOfFilling) {

            case "A":
                fillingMatrixA(size, matrix);
                printMatrix(matrix);
                break;
            case "B":
                fillingMatrixB(size, matrix);
                printMatrix(matrix);
                break;

        }


    }

    private static void fillingMatrixA(int size, int[][] table) {

        int filling = 1;
        for (int row = 0; row < size; row++) {

            for (int col = 0; col < table[row].length; col++) {

                table[col][row] = filling;
                filling++;
            }
        }
    }

    private static void fillingMatrixB(int size, int[][] table) {

        int filling = 1;
        for (int row = 0; row < size; row++) {

            if (row % 2 == 1) {

                for (int col = table[row].length - 1; col >= 0; col--) {

                    table[col][row] = filling;
                    filling++;
                }

            } else {

                for (int col = 0; col < table[row].length; col++) {

                    table[col][row] = filling;
                    filling++;
                }
            }
        }
    }

    private static void printMatrix(int[][] table) {

        for (int i = 0; i < table.length; i++) {

            for (int j = 0; j < table[i].length; j++) {

                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
    }
}
