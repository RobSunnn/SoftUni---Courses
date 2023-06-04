package Exams;

import java.util.*;


public class P02PawnWars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] chessboard = new char[8][8];
        fillingMatrix(chessboard, scanner);


        int rowWhite = -1;
        int colWhite = -1;
        int rowBlack = -1;
        int colBlack = -1;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessboard[i][j] == 'w') {
                    rowWhite = i;
                    colWhite = j;
                }
                if (chessboard[i][j] == 'b') {
                    rowBlack = i;
                    colBlack = j;
                }
            }
        }

        while (true) {
            chessboard[rowWhite][colWhite] = '-';
            if (lookingDiagonalsWhite(rowWhite, colWhite, rowBlack, colBlack)) {
                rowWhite = rowBlack;
                colWhite = colBlack;
                char symbol = (char) (colWhite + 97);
                System.out.printf("Game over! White capture on %c%d.%n", symbol, 8 - rowWhite);
                break;
            } else {
                rowWhite--;
                chessboard[rowWhite][colWhite] = 'w';

                if (rowWhite == 0) {
                    char symbol = (char) (colWhite + 97);
                    System.out.printf("Game over! White pawn is promoted to a queen at %c8.", symbol);
                    break;
                }
            }

            chessboard[rowBlack][colBlack] = '-';

            if (lookingDiagonalsBlack(rowBlack, colBlack, rowWhite, colWhite)) {
                rowBlack = rowWhite;
                colBlack = colWhite;
                char symbol = (char) (colBlack + 97);
                System.out.printf("Game over! Black capture on %c%d.%n", symbol, 8 - rowBlack);
                break;

            } else {

                rowBlack++;
                chessboard[rowBlack][colBlack] = 'b';
                if (rowBlack == 7) {
                    char symbol = (char) (colBlack + 97);
                    System.out.printf("Game over! Black pawn is promoted to a queen at %c1.", symbol);
                    break;
                }
            }

        }

    }

    private static void fillingMatrix(char[][] table, Scanner scanner) {
        for (int row = 0; row < table.length; row++) {
            char[] input = scanner.nextLine().toCharArray();
            table[row] = input;
        }
    }

    private static boolean lookingDiagonalsWhite(int rW, int cW, int rB, int cB) {
        return rW - 1 == rB && (cW - 1 == cB || cW + 1 == cB);
    }

    private static boolean lookingDiagonalsBlack(int rB, int cB, int rW, int cW) {
        return rB + 1 == rW && (cB + 1 == cW || cB - 1 == cW);

    }


}


