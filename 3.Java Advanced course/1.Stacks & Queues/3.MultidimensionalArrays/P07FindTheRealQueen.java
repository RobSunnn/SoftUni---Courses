package P03MultidimensionalArrays.lab;

import java.util.Scanner;

public class P07FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] chessboard = new String[8][8];

        for (int row = 0; row < chessboard.length; row++) {

            String[] input = scanner.nextLine().split("\\s+");
            chessboard[row] = input;
        }

        int rowPosition = 0;
        int colPosition = 0;
        boolean isRealQueen = false;

        for (int row = 0; row < chessboard.length; row++) {

            for (int col = 0; col < chessboard[row].length; col++) {

                String queen = chessboard[row][col];

                if (queen.equals("q")) {

                    rowPosition = row;
                    colPosition = col;

                    if (lookingUp(row, col, chessboard) && lookingDown(row, col, chessboard) &&
                            lookingLeft(row, col, chessboard) && lookingRight(row, col, chessboard) &&
                            lookingDiagonalRightTop(row, col, chessboard) &&
                            lookingDiagonalRightBottom(row, col, chessboard) &&
                            lookingLeftDiagonalBottom(row, col, chessboard) &&
                            lookingDiagonalLeftTop(row, col, chessboard)) {

                        isRealQueen = true;

                        System.out.print("" + rowPosition + " " + colPosition);
                    }

                }
            }
        }


    }

    private static boolean lookingUp(int row, int col, String[][] board) {

        while (row > 0) {

            String current = board[row - 1][col];

            if (current.equals("q")) {

                return false;
            }

            row--;

        }


        return true;
    }

    private static boolean lookingDown(int row, int col, String[][] board) {

        while (row < board.length - 1) {

            String current = board[row + 1][col];

            if (current.equals("q")) {
                return false;
            }
            row++;

        }

        return true;
    }

    private static boolean lookingRight(int row, int col, String[][] board) {

        while (col < board.length - 1) {
            String current = board[row][col + 1];
            if (current.equals("q")) {

                return false;
            }
            col++;
        }


        return true;
    }

    private static boolean lookingLeft(int row, int col, String[][] board) {

        while (col > 0) {
            String current = board[row][col - 1];

            if (current.equals("q")) {
                return false;
            }
            col--;

        }


        return true;
    }

    private static boolean lookingDiagonalRightTop(int row, int col, String[][] board) {

        while (row > 0 && col < board.length - 1) {

            String current = board[row - 1][col + 1];
            if (current.equals("q")) {

                return false;
            }
            row--;
            col++;
        }


        return true;
    }

    private static boolean lookingDiagonalRightBottom(int row, int col, String[][] board) {

        while (row < board.length - 1 && col < board.length - 1) {
            String current = board[row + 1][col + 1];
            if (current.equals("q")) {
                return false;
            }
            row++;
            col++;
        }


        return true;
    }

    private static boolean lookingDiagonalLeftTop(int row, int col, String[][] board) {

        while (row > 0 && col > 0) {
            String current = board[row - 1][col - 1];
            if (current.equals("q")) {

                return false;
            }
            row--;
            col--;
        }


        return true;
    }

    private static boolean lookingLeftDiagonalBottom(int row, int col, String[][] board) {

        while (row < board.length - 1 && col > 0) {
            String current = board[row + 1][col - 1];
            if (current.equals("q")) {
                return false;
            }
            row++;
            col--;

        }


        return true;
    }
}
