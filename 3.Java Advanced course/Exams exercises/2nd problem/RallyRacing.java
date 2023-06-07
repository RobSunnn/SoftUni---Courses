package Exams;

import java.util.Scanner;

public class P02RallyRacing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String racingNumber = scanner.nextLine();
        char[][] matrix = new char[size][size];
        fillingMatrix(matrix, scanner);

        int row = 0;
        int col = 0;

        int distancePassed = 0;

        String command = scanner.nextLine();
        boolean isFinishFound = false;

        while (!command.equals("End")) {

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

            if (matrix[row][col] == '.') {
                distancePassed += 10;
                matrix[row][col] = 'C';
            } else if (matrix[row][col] == 'T') {
                matrix[row][col] = '.';

                for (int i = 0; i < matrix.length; i++) {

                    for (int j = 0; j < matrix[i].length; j++) {

                        if (matrix[i][j] == 'T') {
                            matrix[i][j] = 'C';
                            row = i;
                            col = j;
                            distancePassed += 30;
                            break;
                        }
                    }
                }
            } else if (matrix[row][col] == 'F') {
                isFinishFound = true;
                distancePassed += 10;
                matrix[row][col] = 'C';
            }

            if (isFinishFound) {
                break;
            }
            command = scanner.nextLine();
        }


        if (isFinishFound) {
            System.out.printf("Racing car %s finished the stage!%n", racingNumber);
        } else {
            System.out.printf("Racing car %s DNF.%n", racingNumber);
        }

        System.out.printf("Distance covered %d km.%n", distancePassed);

        matrix[row][col] = 'C';

        printMatrix(matrix);
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

                System.out.print(table[row][col]);
            }
            System.out.println();
        }
    }

}


