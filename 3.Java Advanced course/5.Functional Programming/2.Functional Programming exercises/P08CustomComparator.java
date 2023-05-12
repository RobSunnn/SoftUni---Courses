package P09FunctionalProgramming.lab.exercise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P08CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine()
                .split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] second = numbers.clone();


        numbers = Arrays.stream(numbers).filter(num -> num % 2 == 0).toArray();
        second = Arrays.stream(second).filter(num -> num % 2 != 0).toArray();
        Arrays.sort(numbers);
        Arrays.sort(second);
        int[] result = new int[numbers.length + second.length];
        int index = 0;
        for (int i = 0; i < numbers.length; i++) {
            result[i] = numbers[i];
            index++;
        }

        for (int i = 0; i < second.length; i++) {
            result[index] = second[i];
            index++;

        }

        Arrays.stream(result).forEach(num -> System.out.printf("%d ", num));


    }
}
