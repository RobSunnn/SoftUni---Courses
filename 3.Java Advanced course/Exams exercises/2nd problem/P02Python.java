package Exams;

import java.util.*;

public class P02Python {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String[] directions = scanner.nextLine().split(",\\s+");
        char[][] matrix = new char[size][size];
        fillingMatrix(matrix, scanner);

        int row = -1;
        int col = -1;
        int foodLeft = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 's') {
                    row = i;
                    col = j;
                }
                if (matrix[i][j] == 'f') {
                    foodLeft++;
                }
            }
        }

        int python = 1;

        for (int i = 0; i < directions.length; i++) {
            String command = directions[i];

            switch (command) {
                case "up":
                    if (row - 1 >= 0) {
                        row--;
                    } else {
                        row = size - 1;
                    }
                    break;
                case "down":
                    if (row + 1 < size) {
                        row++;
                    } else {
                        row = 0;
                    }
                    break;
                case "right":
                    if (col + 1 < size) {
                        col++;
                    } else {
                        col = 0;
                    }
                    break;
                case "left":
                    if (col - 1 >= 0) {
                        col--;
                    } else {
                        col = size - 1;
                    }
                    break;
            }

            if (matrix[row][col] == 'e') {
                System.out.println("You lose! Killed by an enemy!");
                return;
            } else if (matrix[row][col] == 'f') {
                python++;
                foodLeft--;
                matrix[row][col] = '*';
            }


            if (foodLeft == 0) {
                System.out.printf("You win! Final python length is %d%n", python);
                return;
            }
        }

        System.out.printf("You lose! There is still %d food to be eaten.%n", foodLeft);


    }

    private static void fillingMatrix(char[][] table, Scanner scanner) {

        for (int row = 0; row < table.length; row++) {
            char[] input = scanner.nextLine().replaceAll(" ", "").toCharArray();
            table[row] = input;
        }
    }

}


