package Exams;

import java.util.Scanner;

public class P02BookWorm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        StringBuilder builder = new StringBuilder(text);
        int size = Integer.parseInt(scanner.nextLine());
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

        String command = scanner.nextLine();

        while (!command.equals("end")) {

            matrix[row][col] = '-';

            switch (command) {

                case "up":
                    if (row - 1 >= 0) {
                        row--;
                    } else {
                        matrix[row][col] = 'P';

                        if (builder.length() > 0) {
                            builder.deleteCharAt(builder.length() - 1);
                        }
                        command = scanner.nextLine();
                        continue;
                    }
                    break;
                case "down":
                    if (row + 1 < size) {
                        row++;
                    } else {
                        matrix[row][col] = 'P';

                        if (builder.length() > 0) {
                            builder.deleteCharAt(builder.length() - 1);
                        }
                        command = scanner.nextLine();
                        continue;
                    }
                    break;
                case "right":
                    if (col + 1 < size) {
                        col++;
                    } else {
                        matrix[row][col] = 'P';

                        if (builder.length() > 0) {
                            builder.deleteCharAt(builder.length() - 1);
                        }
                        command = scanner.nextLine();
                        continue;
                    }
                    break;
                case "left":
                    if (col - 1 >= 0) {
                        col--;
                    } else {
                        matrix[row][col] = 'P';

                        if (builder.length() > 0) {
                            builder.deleteCharAt(builder.length() - 1);
                        }
                        command = scanner.nextLine();
                        continue;
                    }
                    break;
            }

            if (Character.isLetter(matrix[row][col])) {
                builder.append(matrix[row][col]);
            }
            matrix[row][col] = 'P';


            command = scanner.nextLine();
        }

        System.out.println(builder.toString());

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
