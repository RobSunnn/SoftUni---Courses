package P09FunctionalProgramming.lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbs = Arrays.stream(scanner.nextLine().split(", ")).map(elem -> Integer.parseInt(elem)).collect(Collectors.toList());

        numbs.removeIf(num -> num % 2 != 0);
        printNumbs(numbs);


        numbs = numbs.stream().sorted((e1, e2) -> e1.compareTo(e2)).collect(Collectors.toList());

        printNumbs(numbs);

    }

    private static void printNumbs(List<Integer> numbs) {
        if (numbs.size() > 0) {
            for (int i = 0; i < numbs.size() - 1; i++) {

                System.out.printf("%d, ", numbs.get(i));
            }
            System.out.println(numbs.get(numbs.size() - 1));
        }
    }
}
