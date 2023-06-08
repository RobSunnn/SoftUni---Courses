package Exams;

import java.util.Scanner;


public class P02StickyFingers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(",");
        char[][] matrix = new char[size][size];
        fillingMatrix(matrix, scanner);

        int row = -1;
        int col = -1;

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 'D') {
                    row = i;
                    col = j;
                    break;
                }
            }
        }
        int moneyStolen = 0;
        boolean isDillingerCaught = false;

        for (int i = 0; i < commands.length; i++) {
            String command = commands[i];
            matrix[row][col] = '+';
            switch (command) {

                case "up":
                    if (row - 1 >= 0) {
                        row--;
                    } else {
                        System.out.println("You cannot leave the town, there is police outside!");
                        matrix[row][col] = 'D';
                        continue;
                    }
                    break;
                case "down":
                    if (row + 1 < size) {
                        row++;
                    } else {
                        System.out.println("You cannot leave the town, there is police outside!");
                        matrix[row][col] = 'D';
                        continue;
                    }
                    break;
                case "right":
                    if (col + 1 < size) {
                        col++;
                    } else {
                        System.out.println("You cannot leave the town, there is police outside!");
                        matrix[row][col] = 'D';
                        continue;
                    }
                    break;
                case "left":
                    if (col - 1 >= 0) {
                        col--;
                    } else {
                        System.out.println("You cannot leave the town, there is police outside!");
                        matrix[row][col] = 'D';
                        continue;
                    }
                    break;

            }
            if (matrix[row][col] == '$') {
                int currentMoneyStolen = row * col;
                matrix[row][col] = 'D';
                moneyStolen += currentMoneyStolen;
                System.out.printf("You successfully stole %d$.%n", currentMoneyStolen);
            } else if (matrix[row][col] == 'P') {
                isDillingerCaught = true;
                matrix[row][col] = '#';
            } else {
                matrix[row][col] = 'D';
            }

            if (isDillingerCaught) {
                break;
            }

        }

        if (isDillingerCaught) {
            System.out.printf("You got caught with %d$, and you are going to jail.%n", moneyStolen);
        } else {
            System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n", moneyStolen);
        }

        printMatrix(matrix);


    }

    private static void fillingMatrix(char[][] table, Scanner scanner) {
        for (int i = 0; i < table.length; i++) {
            char[] input = scanner.nextLine().replaceAll(" ", "").toCharArray();
            table[i] = input;
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


