package P04MultidimensionalArrays.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P07CrossFire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] rowsAndCols = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(rowsAndCols[0]);
        int cols = Integer.parseInt(rowsAndCols[1]);
        List<List<Integer>> table = new ArrayList<>();
        int filling = 1;


        for (int row = 0; row < rows; row++) {
            table.add(new ArrayList<>());
            for (int col = 0; col < cols; col++) {

                table.get(row).add(filling++);
            }
        }


        String input = scanner.nextLine();

        while (!input.equals("Nuke it from orbit")) {
            String[] coordinates = input.split("\\s+");
            int row = Integer.parseInt(coordinates[0]);
            int col = Integer.parseInt(coordinates[1]);
            int radius = Integer.parseInt(coordinates[2]);

            for (int i = row - radius; i <= row + radius; i++) {

                if (isInRange(i, col, table) && i != row) {

                    table.get(i).remove(col);
                }
            }
            for (int i = col + radius; i >= col - radius; i--) {

                if (isInRange(row, i, table)) {

                    table.get(row).remove(i);
                }

            }
            table.removeIf(List::isEmpty);
            input = scanner.nextLine();
        }

        for (List<Integer> numbs : table) {

            for (Integer num : numbs) {

                System.out.print(num + " ");
            }
            System.out.println();
        }

    }

    private static boolean isInRange(int row, int col, List<List<Integer>> matrix) {
        return row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size();
    }
}
