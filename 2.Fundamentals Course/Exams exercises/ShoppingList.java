package fundamentals.exams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShoppingList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> shoppingList = Arrays.stream(scanner.nextLine().split("!")).collect(Collectors.toList());
        String command = scanner.nextLine();

        while (!command.equals("Go Shopping!")) {
            String input = command.split(" ")[0];

            if (input.equals("Urgent")) {
                String item = command.split(" ")[1];
                if (!shoppingList.contains(item)) {
                    shoppingList.add(0, item);
                }
            } else if (input.equals("Unnecessary")) {
                String item = command.split(" ")[1];
                shoppingList.remove(item);

            } else if (input.equals("Correct")) {
                String oldItem = command.split(" ")[1];
                String newItem = command.split(" ")[2];
                int index = 0;
                if (shoppingList.contains(oldItem)) {
                    for (int i = 0; i < shoppingList.size(); i++) {
                        if (shoppingList.get(i).equals(oldItem)) {
                            index = i;
                        }
                    }
                    shoppingList.set(index, newItem);
                }
            } else if (input.equals("Rearrange")) {
                String item = command.split(" ")[1];
                if (shoppingList.contains(item)) {
                    shoppingList.remove(item);
                    shoppingList.add(item);
                }
            }

            command = scanner.nextLine();
        }
        String list = String.join(", ", shoppingList);
        System.out.println(list);

    }
}
