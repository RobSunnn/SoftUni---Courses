package P09FunctionalProgramming.lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class P02SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numbsArr = scanner.nextLine().split(", ");

        Function<String, Integer> function = x -> Integer.valueOf(x);
        int sum = 0;

        for (int i = 0; i < numbsArr.length; i++) {
            sum += function.apply(numbsArr[i]);
        }

        System.out.printf("Count = %d%n", numbsArr.length);
        System.out.printf("Sum = %d", sum);

    }
}
