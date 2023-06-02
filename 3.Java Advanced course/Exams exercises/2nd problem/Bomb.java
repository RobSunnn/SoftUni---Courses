package Exams;

import java.util.*;

public class P02Bomb {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(",");
        char[][] matrix = new char[size][size];
        fillingMatrix(matrix, scanner);

        int countBombs = 0;
        int row = -1;
        int col = -1;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 's') {
                    row = i;
                    col = j;
                }
                if (matrix[i][j] == 'B') {
                    countBombs++;
                }
            }
        }

        for (String command : commands) {

            switch (command) {
                case "up":
                    if (row - 1 >= 0) {
                        row--;
                    } else {
                        continue;
                    }
                    break;
                case "down":
                    if (row + 1 < size) {
                        row++;
                    } else {
                        continue;
                    }
                    break;
                case "right":
                    if (col + 1 < size) {
                        col++;
                    } else {
                        continue;
                    }
                    break;
                case "left":
                    if (col - 1 >= 0) {
                        col--;
                    } else {
                        continue;
                    }
                    break;
            }

            if (matrix[row][col] == 'B') {
                System.out.println("You found a bomb!");
                countBombs--;
                matrix[row][col] = '+';
            } else if (matrix[row][col] == 'e') {
                System.out.printf("END! %d bombs left on the field%n", countBombs);
                return;
            }
            if (countBombs <= 0) {
                System.out.println("Congratulations! You found all bombs!");
                return;
            }
        }

        System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)", countBombs, row, col);


    }

    private static void fillingMatrix(char[][] table, Scanner scanner) {
        for (int row = 0; row < table.length; row++) {
            char[] input = scanner.nextLine().replaceAll(" ", "").toCharArray();
            table[row] = input;
        }
    }


}


