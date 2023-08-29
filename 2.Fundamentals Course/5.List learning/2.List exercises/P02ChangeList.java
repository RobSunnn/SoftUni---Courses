package fundamentals.P12.Lists.exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String command = scanner.nextLine();

        while (!command.equals("end")) {
            String commandName = command.split(" ")[0];
            int element = Integer.parseInt(command.split(" ")[1]);

            if (commandName.contains("Delete")) {

                numbers.removeAll(Arrays.asList(element));
            } else if (commandName.contains("Insert")) {
                int index = Integer.parseInt(command.split(" ")[2]);
                numbers.add(index, element);
            }


            command = scanner.nextLine();
        }
        System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
    }
}
