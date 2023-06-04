package Exams;

import java.util.Scanner;

public class P02MouseAndCheese {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];
        fillingMatrix(matrix, scanner);

        int row = -1;
        int col = -1;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                if (matrix[i][j] == 'M') {
                    row = i;
                    col = j;
                    break;
                }
            }
        }

        boolean isMouseStillInside = true;
        int cheeseEaten = 0;

        String command = scanner.nextLine();

        while (!command.equals("end")) {

            matrix[row][col] = '-';

            switch (command) {

                case "up":
                    if (row - 1 >= 0) {
                        row--;
                    } else {
                        isMouseStillInside = false;
                    }
                    break;
                case "down":
                    if (row + 1 < size) {
                        row++;
                    } else {
                        isMouseStillInside = false;
                    }
                    break;
                case "right":
                    if (col + 1 < size) {
                        col++;
                    } else {
                        isMouseStillInside = false;
                    }
                    break;
                case "left":
                    if (col - 1 >= 0) {
                        col--;
                    } else {
                        isMouseStillInside = false;
                    }
                    break;

            }

            if (!isMouseStillInside) {
                break;
            }

            if (matrix[row][col] == 'c') {
                cheeseEaten++;
                matrix[row][col] = 'M';
            } else if (matrix[row][col] == 'B') {
                matrix[row][col] = '-';

                switch (command) {

                    case "up":
                        row--;
                        break;
                    case "down":
                        row++;
                        break;
                    case "right":
                        col++;
                        break;
                    case "left":
                        col--;
                        break;
                }
                if (matrix[row][col] == 'c') {
                    cheeseEaten++;
                }
                matrix[row][col] = 'M';

            } else {
                matrix[row][col] = 'M';
            }

            command = scanner.nextLine();
        }

        if (!isMouseStillInside) {
            System.out.println("Where is the mouse?");
        }

        if (cheeseEaten >= 5) {
            System.out.printf("Great job, the mouse is fed %d cheeses!%n", cheeseEaten);
        } else {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", 5 - cheeseEaten);
        }

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


