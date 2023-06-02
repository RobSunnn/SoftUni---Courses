package Exams;

import java.util.Scanner;

public class P02Bee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];
        fillingMatrix(matrix, scanner);

        int row = -1;
        int col = -1;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                if (matrix[i][j] == 'B') {
                    row = i;
                    col = j;
                    break;
                }
            }
        }

        int pollinatedFlowers = 0;
        boolean isBeeStillInside = true;

        String command = scanner.nextLine();

        while (!command.equals("End")) {

            matrix[row][col] = '.';

            switch (command) {

                case "up":
                    if (row - 1 >= 0) {
                        row--;
                    } else {
                        isBeeStillInside = false;
                    }
                    break;
                case "down":
                    if (row + 1 < size) {
                        row++;
                    } else {
                        isBeeStillInside = false;
                    }
                    break;
                case "right":
                    if (col + 1 < size) {
                        col++;
                    } else {
                        isBeeStillInside = false;
                    }
                    break;
                case "left":
                    if (col - 1 >= 0) {
                        col--;
                    } else {
                        isBeeStillInside = false;
                    }
                    break;
            }

            if (!isBeeStillInside) {
                break;
            }


            if (matrix[row][col] == 'f') {
                pollinatedFlowers++;
                matrix[row][col] = 'B';
            } else if (matrix[row][col] == 'O') {
                matrix[row][col] = '.';

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
                if (matrix[row][col] == 'f') {
                    pollinatedFlowers++;

                }
                matrix[row][col] = 'B';

            } else {

                matrix[row][col] = 'B';
            }


            command = scanner.nextLine();
        }

        if (!isBeeStillInside) {
            System.out.println("The bee got lost!");
        }

        if (pollinatedFlowers >= 5) {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", pollinatedFlowers);
        } else {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5 - pollinatedFlowers);
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


