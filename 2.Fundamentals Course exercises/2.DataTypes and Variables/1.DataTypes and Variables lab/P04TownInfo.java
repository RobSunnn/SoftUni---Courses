package fundamentals.P04.dataTypesAndVariables.lab;

import java.util.Scanner;

public class P04TownInfo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String town = scanner.nextLine();
        int population = Integer.parseInt(scanner.nextLine());
        int size = Integer.parseInt(scanner.nextLine());

        String all = String.format("Town %s has population of %d and area %d square km.", town, population, size);

        System.out.println(all);
    }
}
