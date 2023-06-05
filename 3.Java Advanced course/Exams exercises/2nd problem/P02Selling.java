package Exams;

import java.util.*;

public class P02Selling {
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

        boolean isStillInside = true;
        int money = 0;

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

            if (Character.isDigit(matrix[row][col])) {
                money += matrix[row][col] - 48;
                matrix[row][col] = 'S';
            } else if (matrix[row][col] == 'O') {
                matrix[row][col] = '-';
                for (int i = 0; i < matrix.length; i++) {
                    for (int j = 0; j < matrix[i].length; j++) {
                        if (matrix[i][j] == 'O') {
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

        if (!isStillInside) {
            System.out.println("Bad news, you are out of the bakery.");
        }

        if (money >= 50) {
            System.out.println("Good news! You succeeded in collecting enough money!");
        }

        System.out.printf("Money: %d%n", money);

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


