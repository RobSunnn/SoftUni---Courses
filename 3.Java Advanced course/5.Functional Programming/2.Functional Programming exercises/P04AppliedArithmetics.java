package P09FunctionalProgramming.lab.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P04AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        String command = scanner.nextLine();

        Function<List<Integer>, List<Integer>> addFunction = list -> list.stream().map(num -> num += 1).collect(Collectors.toList());
        Function<List<Integer>, List<Integer>> subtractFunction = list -> list.stream().map(num -> num -= 1).collect(Collectors.toList());
        Function<List<Integer>, List<Integer>> multiplyFunction = list -> list.stream().map(num -> num *= 1).collect(Collectors.toList());
        Consumer<List<Integer>> print = list -> list.forEach(num -> System.out.printf("%d ", num));


        while (!command.equals("end")) {


            switch (command) {

                case "add":
                    numbers = addFunction.apply(numbers);
                    break;
                case "subtract":
                    numbers = subtractFunction.apply(numbers);
                    break;
                case "multiply":
                    numbers = multiplyFunction.apply(numbers);
                    break;
                case "print":
                    print.accept(numbers);
                    System.out.println();
                    break;

            }

            command = scanner.nextLine();
        }
    }
}
