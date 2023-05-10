package P09FunctionalProgramming.lab;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class P05FilterByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(", ");
            String name = input[0];
            int age = Integer.parseInt(input[1]);

            map.put(name, age);

        }

        String condition = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();
        Predicate<Integer> filter = getPredicate(condition, age);
        Consumer<Map.Entry<String, Integer>> print = getPrintConsumer(format);

        map.entrySet()
                .stream()
                .filter(entry -> filter.test(entry.getValue()))
                .forEach(entry -> print.accept(entry));
    }

    private static Consumer<Map.Entry<String, Integer>> getPrintConsumer(String format) {
        switch (format) {
            case "name":
                return e -> System.out.println(e.getKey());
            case "age":
                return e -> System.out.println(e.getValue());
            case "name age":
                return e -> System.out.printf("%s - %d%n", e.getKey(), e.getValue());
        }
        throw new RuntimeException("Bad format!");
    }

    private static Predicate<Integer> getPredicate(String condition, int age) {

        if (condition.equals("older")) {

            return x -> x >= age;
        }
        if (condition.equals("younger")) {
            return x -> x <= age;
        }
        throw new RuntimeException("Bad condition!");
    }
}
