package Exams;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P02TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);
        List<String> directions = new ArrayList<>();

        char[][] treasureMap = new char[rows][cols];

        for (int row = 0; row < treasureMap.length; row++) {
            String inputLine = scanner.nextLine().replaceAll(" ", "");
            for (int col = 0; col < treasureMap[row].length; col++) {

                treasureMap[row][col] = inputLine.charAt(col);
            }
        }
        int[] positions = new int[2];

        boolean positionFound = false;

        for (int row = 0; row < rows; row++) {

            for (int col = 0; col < cols; col++) {

                if (treasureMap[row][col] == ('Y')) {

                    positions[0] = row;
                    positions[1] = col;
                    positionFound = true;
                    break;
                }
            }
            if (positionFound) {
                break;
            }
        }
        int currentPositionRow = positions[0];
        int currentPositionCol = positions[1];

        String command = scanner.nextLine();

        while (!command.equals("Finish")) {

            switch (command) {

                case "right":

                    if (currentPositionCol + 1 < cols && treasureMap[currentPositionRow][currentPositionCol + 1] != 'T') {
                        currentPositionCol++;
                        directions.add(command);

                    }
                    break;
                case "left":

                    if (currentPositionCol - 1 >= 0 && treasureMap[currentPositionRow][currentPositionCol - 1] != 'T') {
                        currentPositionCol--;
                        directions.add(command);
                    }

                    break;
                case "up":

                    if (currentPositionRow - 1 >= 0 && treasureMap[currentPositionRow - 1][currentPositionCol] != 'T') {
                        currentPositionRow--;
                        directions.add(command);
                    }
                    break;
                case "down":

                    if (currentPositionRow + 1 < rows && treasureMap[currentPositionRow + 1][currentPositionCol] != 'T') {
                        currentPositionRow++;
                        directions.add(command);
                    }
                    break;

            }

            command = scanner.nextLine();
        }

        if (treasureMap[currentPositionRow][currentPositionCol] == 'X') {
            System.out.println("I've found the treasure!");
            System.out.printf("The right path is %s%n", String.join(", ", directions));

        } else {
            System.out.println("The map is fake!");
        }


    }


}
