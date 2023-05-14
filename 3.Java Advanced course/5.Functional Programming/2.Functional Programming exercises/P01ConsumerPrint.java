package P09FunctionalProgramming.lab.exercise;

import java.util.Scanner;
import java.util.function.Consumer;

public class P01ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split("\\s+");

        Consumer<String> printName = str -> System.out.println(str);

        for (String name : names) {
            printName.accept(name);
        }
    }
}
