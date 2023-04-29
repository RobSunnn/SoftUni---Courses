package P06SetsAndMapsAdvanced.exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class P03PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Set<String> periodicTable = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");

            periodicTable.addAll(Arrays.asList(input));
        }

        for (String chemical : periodicTable) {
            System.out.print(chemical + " ");
        }

    }
}
