package fundamentals.P12.Lists.exercise;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P04ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        String command = scanner.nextLine();
        while (!command.equals("End")) {

            if (command.contains("Add")) {

                int numToAdd = Integer.parseInt(command.split(" ")[1]);
                numbers.add(numToAdd);

            } else if (command.contains("Insert")) {

                int numToInsert = Integer.parseInt(command.split(" ")[1]);
                int index = Integer.parseInt(command.split(" ")[2]);
                if (isIndexValid(index, numbers.size())) {
                    numbers.add(index, numToInsert);
                } else {
                    System.out.println("Invalid index");
                }

            } else if (command.contains("Remove")) {

                int index = Integer.parseInt(command.split(" ")[1]);
                if (isIndexValid(index, numbers.size())) {
                    numbers.remove(index);
                } else {
                    System.out.println("Invalid index");
                }

            } else if (command.contains("Shift left")) {

                int countTimes = Integer.parseInt(command.split(" ")[2]);
                for (int i = 0; i < countTimes; i++) {
                    int firstNum = numbers.get(0);
                    numbers.remove(0);
                    numbers.add(firstNum);

                }

            } else if (command.contains("Shift right")) {

                int countTimes = Integer.parseInt(command.split(" ")[2]);
                for (int i = 0; i < countTimes; i++) {
                    int lastNum = numbers.get(numbers.size() - 1);
                    numbers.remove(numbers.get(numbers.size() - 1));
                    numbers.add(0, lastNum);
                }

            }

            command = scanner.nextLine();
        }
        for (int numbs : numbers) {
            System.out.print(numbs + " ");
        }
    }
    public static boolean isIndexValid(int index, int size) {
        return index >= 0 && index <= size - 1;
    }
}
