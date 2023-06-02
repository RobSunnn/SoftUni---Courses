package Exams;

import java.util.Scanner;


public class P02Armory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];
        fillingMatrix(matrix, scanner);

        int row = -1;
        int col = -1;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 'A') {
                    row = i;
                    col = j;
                    break;

                }
            }
        }
        boolean isOfficerStillInside = true;
        int moneyForged = 0;
        while (moneyForged < 65) {
            String command = scanner.nextLine();
            matrix[row][col] = '-';

            switch (command) {
                case "up":
                    if (row - 1 >= 0) {
                        row--;
                    } else {
                        isOfficerStillInside = false;
                    }
                    break;
                case "down":
                    if (row + 1 < size) {
                        row++;
                    } else {
                        isOfficerStillInside = false;
                    }
                    break;
                case "right":
                    if (col + 1 < size) {
                        col++;
                    } else {
                        isOfficerStillInside = false;
                    }
                    break;
                case "left":
                    if (col - 1 >= 0) {
                        col--;
                    } else {
                        isOfficerStillInside = false;
                    }
                    break;
            }

            if (!isOfficerStillInside) {
                break;
            }

            if (matrix[row][col] == 'M') {
                matrix[row][col] = '-';

                for (int i = 0; i < matrix.length; i++) {
                    for (int j = 0; j < matrix[i].length; j++) {

                        if (matrix[i][j] == 'M') {
                            matrix[i][j] = 'A';
                            row = i;
                            col = j;
                            break;
                        }
                    }
                }
            } else if (Character.isDigit(matrix[row][col])) {
                moneyForged += matrix[row][col] - 48;
                matrix[row][col] = 'A';
            } else {
                matrix[row][col] = 'A';
            }


        }

        if (!isOfficerStillInside) {
            System.out.println("I do not need more swords!");
        } else {
            System.out.println("Very nice swords, I will come back for more!");
        }

        System.out.printf("The king paid %d gold coins.%n", moneyForged);

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


