package P04MultidimensionalArrays.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P06StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<String> wordsList = new ArrayList<>();
        String rotationInput = scanner.nextLine();
        StringBuilder builder = new StringBuilder();


        for (int i = 0; i < rotationInput.length(); i++) {
            char current = rotationInput.charAt(i);

            if (Character.isDigit(current)) {
                builder.append(current);
            }

        }
        String rotation = builder.toString();
        int degreesToRotate = Integer.parseInt(rotation);
        int biggerDegrees = degreesToRotate / 90;
        int degrees = biggerDegrees % 4;

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            wordsList.add(input);

            input = scanner.nextLine();
        }
        int maxLength = 0;
        for (int i = 0; i < wordsList.size(); i++) {
            String currentWord = wordsList.get(i);

            if (currentWord.length() > maxLength) {
                maxLength = currentWord.length();
            }

        }

        char[][] matrix = new char[wordsList.size()][maxLength];

        for (int row = 0; row < wordsList.size(); row++) {
            char[] wordToChar = wordsList.get(row).toCharArray();

            for (int col = 0; col < maxLength; col++) {

                if (col >= wordToChar.length) {

                    matrix[row][col] = ' ';

                } else {

                    matrix[row][col] = wordToChar[col];
                }
            }

            System.out.println();
        }

        if (degreesToRotate == 0 || degreesToRotate == 360 || degrees == 0) {

            for (int row = 0; row < matrix.length; row++) {

                for (int col = 0; col < matrix[row].length; col++) {

                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        } else if (degreesToRotate == 90 || degrees == 1) {
            char[][] rotateMatrix = new char[maxLength][wordsList.size()];

            for (int row = wordsList.size() - 1; row >= 0; row--) {

                for (int col = 0; col < maxLength; col++) {
                    char current = matrix[row][col];
                    rotateMatrix[col][row] = current;

                }

            }

            for (int row = 0; row < rotateMatrix.length; row++) {

                for (int col = rotateMatrix[row].length - 1; col >= 0; col--) {

                    System.out.print(rotateMatrix[row][col]);
                }
                System.out.println();
            }


        } else if (degreesToRotate == 180 || degrees == 2) {

            for (int row = matrix.length - 1; row >= 0; row--) {

                for (int col = matrix[row].length - 1; col >= 0; col--) {

                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }

        } else if (degreesToRotate == 270 || degrees == 3) {

            char[][] rotateMatrix = new char[maxLength][wordsList.size()];

            for (int row = wordsList.size() - 1; row >= 0; row--) {

                for (int col = 0; col < maxLength; col++) {
                    char current = matrix[row][col];
                    rotateMatrix[col][row] = current;

                }

            }

            for (int row = rotateMatrix.length - 1; row >= 0; row--) {

                for (int col = 0; col < rotateMatrix[row].length; col++) {

                    System.out.print(rotateMatrix[row][col]);
                }
                System.out.println();
            }

        }
    }
}
