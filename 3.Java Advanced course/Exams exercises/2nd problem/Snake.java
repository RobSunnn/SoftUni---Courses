package Exams;

import java.util.*;

public class P02Snake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];
        fillingMatrix(matrix, scanner);

        int row = -1;
        int col = -1;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                if (matrix[i][j] == 'S') {
                    row = i;
                    col = j;
                    break;
                }
            }
        }

        int foodEaten = 0;
        boolean isSnakeStillInside = true;

        while (foodEaten < 10) {
            String command = scanner.nextLine();

            matrix[row][col] = '.';

            switch (command) {
                case "up":
                    if (row - 1 >= 0) {
                        row--;
                    } else {
                        isSnakeStillInside = false;
                    }
                    break;
                case "down":
                    if (row + 1 < size) {
                        row++;
                    } else {
                        isSnakeStillInside = false;
                    }
                    break;
                case "right":
                    if (col + 1 < size) {
                        col++;
                    } else {
                        isSnakeStillInside = false;
                    }
                    break;
                case "left":
                    if (col - 1 >= 0) {
                        col--;
                    } else {
                        isSnakeStillInside = false;
                    }
                    break;
            }

            if (!isSnakeStillInside) {
                break;
            }

            if (matrix[row][col] == '*') {
                foodEaten++;
                matrix[row][col] = 'S';
            } else if (matrix[row][col] == 'B') {
                matrix[row][col] = '.';

                for (int i = 0; i < matrix.length; i++) {

                    for (int j = 0; j < matrix[i].length; j++) {

                        if (matrix[i][j] == 'B') {
                            matrix[i][j] = 'S';
                            row = i;
                            col = j;
                            break;
                        }
                    }
                }
            } else {
                matrix[row][col] = 'S';
            }
        }

        if (!isSnakeStillInside) {
            System.out.println("Game over!");
        }

        if (foodEaten >= 10) {
            System.out.println("You won! You fed the snake.");
        }

        System.out.printf("Food eaten: %d%n", foodEaten);

        printMatrix(matrix);

    }

    private static void fillingMatrix(char[][] table, Scanner scanner) {
        for (int row = 0; row < table.length; row++) {
            char[] input = scanner.nextLine().toCharArray();
            table[row] = input;
        }
    }

    private static void printMatrix(char[][] table) {
        for (int row = 0; row < table.length; row++) {
            for (int col = 0; col < table[row].length; col++) {

                System.out.print(table[row][col]);
            }
            System.out.println();
        }
    }

}


