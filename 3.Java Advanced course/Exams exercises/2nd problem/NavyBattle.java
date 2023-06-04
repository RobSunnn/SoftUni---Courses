package Exams;

import java.util.Scanner;

public class P02NavyBattle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];
        fillingMatrix(matrix, scanner);

        int row = -1;
        int col = -1;

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix.length; j++) {

                if (matrix[i][j] == 'S') {
                    row = i;
                    col = j;
                }
            }
        }

        int battleCruisers = 0;
        int healthOfSubmarine = 0;

        while (true) {
            String command = scanner.nextLine();
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

            if (matrix[row][col] == '*') {

                healthOfSubmarine++;
                matrix[row][col] = 'S';
            } else if (matrix[row][col] == 'C') {

                battleCruisers++;
                matrix[row][col] = 'S';
            } else {
                matrix[row][col] = 'S';
            }

            if (battleCruisers == 3) {
                System.out.println("Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!");
                printMatrix(matrix);
                break;
            }
            if (healthOfSubmarine == 3) {
                System.out.printf("Mission failed, U-9 disappeared! Last known coordinates [%d, %d]!%n", row, col);
                printMatrix(matrix);
                break;
            }
        }


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


