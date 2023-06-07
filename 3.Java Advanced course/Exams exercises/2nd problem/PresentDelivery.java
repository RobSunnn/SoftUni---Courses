package Exams;

import java.util.*;

public class P02PresentDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countPresents = Integer.parseInt(scanner.nextLine());
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


        int countHappyKids = 0;

        String command = scanner.nextLine();

        while (!command.equals("Christmas morning")) {

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

            if (matrix[row][col] == 'V') {
                countHappyKids++;
                countPresents--;
                matrix[row][col] = 'S';
            } else if (matrix[row][col] == 'C') {

                matrix[row][col] = 'S';

                if (matrix[row - 1][col] == 'V' || matrix[row - 1][col] == 'X') {
                    countPresents--;
                    countHappyKids++;
                    matrix[row - 1][col] = '-';
                }
                if (matrix[row + 1][col] == 'V' || matrix[row + 1][col] == 'X') {
                    countPresents--;
                    countHappyKids++;
                    matrix[row + 1][col] = '-';
                }
                if (matrix[row][col + 1] == 'V' || matrix[row][col + 1] == 'X') {
                    countPresents--;
                    countHappyKids++;
                    matrix[row][col + 1] = '-';
                }
                if (matrix[row][col - 1] == 'V' || matrix[row][col - 1] == 'X') {
                    countPresents--;
                    countHappyKids++;
                    matrix[row][col - 1] = '-';
                }


            } else {
                matrix[row][col] = 'S';
            }


            if (countPresents <= 0) {
                System.out.println("Santa ran out of presents!");
                break;
            }
            command = scanner.nextLine();
        }

        int kidsWithoutPresent = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 'V') {
                    kidsWithoutPresent++;
                }
            }
        }

        printMatrix(matrix);

        if (kidsWithoutPresent == 0) {
            System.out.printf("Good job, Santa! %d happy nice kid/s.", countHappyKids);
        } else {
            System.out.printf("No presents for %d nice kid/s.", kidsWithoutPresent);
        }
    }

    private static void fillingMatrix(char[][] table, Scanner scanner) {
        for (int row = 0; row < table.length; row++) {
            char[] input = scanner.nextLine().replaceAll(" ", "").toCharArray();
            table[row] = input;
        }
    }

    private static void printMatrix(char[][] table) {
        for (int row = 0; row < table.length; row++) {
            for (int col = 0; col < table[row].length; col++) {
                System.out.print(table[row][col] + " ");
            }
            System.out.println();
        }
    }

}


