package P09FunctionalProgramming.lab.exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P05ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        int n = Integer.parseInt(scanner.nextLine());


        Collections.reverse(numbers);

        numbers.removeIf(num -> num % n == 0);
        numbers.forEach(num -> System.out.printf("%d ",num));
    }
}
