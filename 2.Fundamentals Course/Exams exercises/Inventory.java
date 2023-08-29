package fundamentals.exams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> itemsList = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("Craft!")) {
            String[] commandInput = input.split(" - ");
            String command = commandInput[0];

            if (command.equals("Collect")) {
                String item = commandInput[1];
                if (!itemsList.contains(item)) {
                    itemsList.add(item);
                }

            } else if (command.equals("Drop")) {
                String item = commandInput[1];

                itemsList.remove(item);

            } else if (command.equals("Renew")) {
                String item = commandInput[1];

                if (itemsList.contains(item)) {
                    itemsList.remove(item);
                    itemsList.add(item);
                }

            } else if (command.contains("Combine")) {
                String[] items = commandInput[1].split(":");
                String oldItem = items[0];
                String newItem = items[1];


                if (itemsList.contains(oldItem)) {
                    if (!itemsList.contains(newItem)) {
                        int index = itemsList.indexOf(oldItem) + 1;

                        itemsList.add(index, newItem);
                    }

                }

            }
            input = scanner.nextLine();
        }
        for (int i = 0; i < itemsList.size() - 1; i++) {
            System.out.print(itemsList.get(i) + ", ");

        }
        System.out.println(itemsList.get(itemsList.size() - 1));


    }
}
