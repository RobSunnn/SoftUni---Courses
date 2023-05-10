package P09FunctionalProgramming.lab.exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P07FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> list = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        Function<List<Integer>, Integer> findsLastIndexOfSmallestElement = num -> list.lastIndexOf(Collections.min(list));
        System.out.println(findsLastIndexOfSmallestElement.apply(list));
    }
}
