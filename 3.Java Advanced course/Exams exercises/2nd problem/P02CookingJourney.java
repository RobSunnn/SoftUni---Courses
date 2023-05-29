package Exams;

import java.util.*;

public class P02CookingJourney {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];
        filingMatrix(matrix, scanner);

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

        int money = 0;
        boolean isStillInside = true;

        while (money < 50) {
            String command = scanner.nextLine();
            matrix[row][col] = '-';
            switch (command) {

                case "up":
                    if (row - 1 >= 0) {

                        row--;
                    } else {

                        isStillInside = false;
                    }
                    break;
                case "down":
                    if (row + 1 < size) {

                        row++;
                    } else {

                        isStillInside = false;
                    }
                    break;
                case "right":
                    if (col + 1 < size) {
                        col++;
                    } else {

                        isStillInside = false;
                    }
                    break;
                case "left":
                    if (col - 1 >= 0) {

                        col--;
                    } else {

                        isStillInside = false;
                    }
                    break;

            }

            if (!isStillInside) {

                break;
            }

            if (matrix[row][col] == 'P') {
                matrix[row][col] = '-';

                for (int i = 0; i < matrix.length; i++) {

                    for (int j = 0; j < matrix[i].length; j++) {

                        if (matrix[i][j] == 'P') {

                            row = i;
                            col = j;
                            matrix[row][col] = 'S';
                        }
                    }
                }

            } else if (Character.isDigit(matrix[row][col])) {

                money += matrix[row][col] - 48;
                matrix[row][col] = 'S';
            }

        }
        if (!isStillInside) {
            System.out.println("Bad news! You are out of the pastry shop.");
        } else if (money >= 50) {
            System.out.println("Good news! You succeeded in collecting enough money!");
        }
        System.out.printf("Money: %d%n", money);
        printMatrix(matrix);

    }

    private static void printMatrix(char[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {

            for (int col = 0; col < matrix[row].length; col++) {

                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void filingMatrix(char[][] table, Scanner scanner) {

        for (int row = 0; row < table.length; row++) {

            char[] input = scanner.nextLine().toCharArray();
            table[row] = input;
        }
    }
}


