package Exams;

import java.util.Scanner;


public class P02ThroneConquering {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int energyOfParis = Integer.parseInt(scanner.nextLine());
        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];

        fillingMatrix(matrix, scanner);

        int rowParis = -1;
        int colParis = -1;

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {

                if (matrix[i][j] == 'P') {
                    rowParis = i;
                    colParis = j;
                }
            }
        }

        boolean isHelenFound = false;
        boolean isParisAlive = true;

        while (energyOfParis > 0) {
            String[] commandAndSpartanRowAndCol = scanner.nextLine().split(" ");
            String command = commandAndSpartanRowAndCol[0];
            int rowSpartan = Integer.parseInt(commandAndSpartanRowAndCol[1]);
            int colSpartan = Integer.parseInt(commandAndSpartanRowAndCol[2]);

            matrix[rowSpartan][colSpartan] = 'S';
            matrix[rowParis][colParis] = '-';

            switch (command) {

                case "up":
                    energyOfParis--;
                    if (rowParis - 1 >= 0) {
                        rowParis--;
                    } else {
                        matrix[rowParis][colParis] = 'P';
                        continue;
                    }
                    break;
                case "down":
                    energyOfParis--;
                    if (rowParis + 1 < size) {
                        rowParis++;
                    } else {
                        matrix[rowParis][colParis] = 'P';
                        continue;
                    }
                    break;
                case "right":
                    energyOfParis--;
                    if (colParis + 1 < size) {
                        colParis++;
                    } else {
                        matrix[rowParis][colParis] = 'P';
                        continue;
                    }
                    break;
                case "left":
                    energyOfParis--;
                    if (colParis - 1 >= 0) {
                        colParis--;
                    } else {
                        matrix[rowParis][colParis] = 'P';
                        continue;
                    }
                    break;
            }

            if (matrix[rowParis][colParis] == 'S') {
                energyOfParis -= 2;
                if (energyOfParis <= 0) {
                    isParisAlive = false;
                    matrix[rowParis][colParis] = 'X';
                    break;
                }

                matrix[rowParis][colParis] = 'P';
            } else if (matrix[rowParis][colParis] == 'H') {
                isHelenFound = true;
                matrix[rowParis][colParis] = '-';
            } else {
                matrix[rowParis][colParis] = 'P';
            }

            if (isHelenFound) {
                break;
            }
            if (energyOfParis <= 0) {
                isParisAlive = false;
                matrix[rowParis][colParis] = 'X';
                break;
            }
        }

        if (!isParisAlive) {
            System.out.printf("Paris died at %d;%d.%n", rowParis, colParis);
        }
        if (isHelenFound) {
            System.out.printf("Paris has successfully abducted Helen! Energy left: %d%n", energyOfParis);
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


