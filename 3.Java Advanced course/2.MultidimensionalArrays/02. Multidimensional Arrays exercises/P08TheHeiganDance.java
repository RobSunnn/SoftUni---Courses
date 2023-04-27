package P04MultidimensionalArrays.exercise;

import java.util.Scanner;

public class P08TheHeiganDance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int player = 18500;
        double heigan = 3000000;
        int playerPositionRow = 7;
        int playerPositionCol = 7;
        double damage = Double.parseDouble(scanner.nextLine());
        String lastSpell = "";


        boolean isPlayerHit = false;


        while (player > 0 && heigan > 0) {
            heigan -= damage;

            if (isPlayerHit) {
                player -= 3500;
                isPlayerHit = false;
                if (player < 0) {
                    break;
                }

            }

            if (heigan < 0) {
                break;
            }
            String[] input = scanner.nextLine().split("\\s+");
            String magic = input[0];
            int row = Integer.parseInt(input[1]);
            int col = Integer.parseInt(input[2]);


            int[][] matrix = new int[15][15];

            for (int i = row - 1; i <= row + 1; i++) {
                if (i >= 0 && i < matrix.length) {

                    for (int j = col - 1; j <= col + 1; j++) {

                        if (j >= 0 && j < matrix[i].length) {

                            matrix[i][j] = 1;
                        }
                    }
                }

            }
            if (matrix[playerPositionRow][playerPositionCol] == 1) {

                if (isRowValid(matrix, playerPositionRow - 1) && matrix[playerPositionRow - 1][playerPositionCol] != 1) {
                    playerPositionRow -= 1;

                } else if (isColValid(matrix, playerPositionCol + 1) && matrix[playerPositionRow][playerPositionCol + 1] != 1) {

                    playerPositionCol += 1;

                } else if (isRowValid(matrix, playerPositionRow + 1) && matrix[playerPositionRow + 1][playerPositionCol] != 1) {

                    playerPositionRow += 1;

                } else if (isColValid(matrix, playerPositionCol - 1) && matrix[playerPositionRow][playerPositionCol - 1] != 1) {

                    playerPositionCol -= 1;

                }
                if (matrix[playerPositionRow][playerPositionCol] == 1) {

                    if (magic.equals("Cloud")) {

                        player -= 3500;
                        isPlayerHit = true;
                        lastSpell = "Plague Cloud";

                    } else if (magic.equals("Eruption")) {

                        player -= 6000;
                        lastSpell = magic;
                    }
                }
            }
        }
        if (heigan > 0) {

            System.out.printf("Heigan: %.2f%n", heigan);
        } else {

            System.out.println("Heigan: Defeated!");
        }
        if (player > 0) {
            System.out.printf("Player: %d%n", player);

        } else {
            System.out.printf("Player: Killed by %s%n", lastSpell);
        }

        System.out.printf("Final position: %d, %d%n", playerPositionRow, playerPositionCol);
    }

    private static boolean isRowValid(int[][] table, int r) {

        return r >= 0 && r < table[r].length;
    }

    private static boolean isColValid(int[][] table, int c) {
        return c >= 0 && c < table.length;
    }
}
