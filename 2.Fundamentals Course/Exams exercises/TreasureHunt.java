package fundamentals.exams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> treasureChest = Arrays.stream(scanner.nextLine().split("\\|")).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("Yohoho!")) {
            String command = input.split(" ")[0];

            if (command.equals("Loot")) {
                String[] inputLine = input.split(" ");
                List<String> lootedItems = new ArrayList<>();
                for (int i = 1; i <= inputLine.length - 1; i++) {
                    if (!lootedItems.contains(inputLine[i])) {
                        lootedItems.add(inputLine[i]);
                    }
                }
                for (int i = 0; i < lootedItems.size(); i++) {
                    if (!treasureChest.contains(lootedItems.get(i))) {
                        treasureChest.add(0, lootedItems.get(i));
                    }
                }
            } else if (command.equals("Drop")) {
                int index = Integer.parseInt(input.split(" ")[1]);
                if (index >= 0 && index <= treasureChest.size() - 1) {
                    String toRemove = treasureChest.get(index);
                    treasureChest.remove(toRemove);
                    treasureChest.add(toRemove);
                }

            } else if (command.equals("Steal")) {
                int count = Integer.parseInt(input.split(" ")[1]);

                if (count >= treasureChest.size()) {
                    System.out.println(String.join(", ", treasureChest));
                    treasureChest.clear();
                } else {
                    List<String> stealedItems = new ArrayList<>();
                    for (int i = 0; i < count; i++) {
                        stealedItems.add(0, treasureChest.get(treasureChest.size() - 1));
                        treasureChest.remove(treasureChest.get(treasureChest.size() - 1));
                    }
                    System.out.println(String.join(", ", stealedItems));
                }
            }
            input = scanner.nextLine();
        }
        if (treasureChest.isEmpty()) {
            System.out.println("Failed treasure hunt.");
        } else {
            String treasure = String.join("", treasureChest);
            int counter = treasure.length();
            double average = counter * 1.0 / treasureChest.size();
            System.out.printf("Average treasure gain: %.2f pirate credits.", average);

        }
    }
}
