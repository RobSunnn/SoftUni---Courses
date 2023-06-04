package Exams;

import java.util.*;

public class P02FormulaOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int countCommands = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];
        fillingMatrix(matrix, scanner);

        int row = -1;
        int col = -1;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                if (matrix[i][j] == 'P') {
                    row = i;
                    col = j;
                    break;
                }
            }
        }

        boolean isFinishFound = false;

        for (int i = 0; i < countCommands; i++) {
            String command = scanner.nextLine();

            matrix[row][col] = '.';

            switch (command) {
                case "up":
                    if (row - 1 >= 0) {
                        row--;
                    } else {
                        row = size - 1;
                    }
                    break;
                case "down":
                    if (row + 1 < size) {
                        row++;
                    } else {
                        row = 0;
                    }
                    break;
                case "right":
                    if (col + 1 < size) {
                        col++;
                    } else {
                        col = 0;
                    }
                    break;
                case "left":
                    if (col - 1 >= 0) {
                        col--;
                    } else {
                        col = size - 1;
                    }
                    break;
            }

            if (matrix[row][col] == 'F') {
                isFinishFound = true;
                matrix[row][col] = 'P';
            } else if (matrix[row][col] == 'B') {
                switch (command) {
                    case "up":
                        if (row - 1 >= 0) {
                            row--;
                        } else {
                            row = size - 1;
                        }
                        break;
                    case "down":
                        if (row + 1 < size) {
                            row++;
                        } else {
                            row = 0;
                        }
                        break;
                    case "right":
                        if (col + 1 < size) {
                            col++;
                        } else {
                            col = 0;
                        }
                        break;
                    case "left":
                        if (col - 1 >= 0) {
                            col--;
                        } else {
                            col = size - 1;
                        }
                        break;

                }
                matrix[row][col] = 'P';

            } else if (matrix[row][col] == 'T') {

                switch (command) {
                    case "up":
                        row++;
                        break;
                    case "down":
                        row--;
                        break;
                    case "right":
                        col--;
                        break;
                    case "left":
                        col++;
                        break;

                }
                matrix[row][col] = 'P';

            } else {
                matrix[row][col] = 'P';
            }


            if (isFinishFound) {
                break;
            }
        }


        if (isFinishFound) {
            System.out.println("Well done, the player won first place!");
        } else {
            System.out.println("Oh no, the player got lost on the track!");
        }

        printMatrix(matrix);
    }

    private static void fillingMatrix(char[][] table, Scanner scanner) {
        for (int i = 0; i < table.length; i++) {
            char[] input = scanner.nextLine().toCharArray();
            table[i] = input;
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


