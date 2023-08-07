
package Abstraction.exercise.GreedyTimes;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long input = Long.parseLong(scanner.nextLine());
        String[] safe = scanner.nextLine().split("\\s+");

        Map<String, LinkedHashMap<String, Long>> bag = new LinkedHashMap<>();
        long gold = 0;
        long stones = 0;
        long money = 0;

        for (int i = 0; i < safe.length; i += 2) {
            String name = safe[i];
            long count = Long.parseLong(safe[i + 1]);

            String typeTreasure = "";

            if (name.length() == 3) {
                typeTreasure = "Cash";
            } else if (name.toLowerCase().endsWith("gem")) {
                typeTreasure = "Gem";
            } else if (name.toLowerCase().equals("gold")) {
                typeTreasure = "Gold";
            }

            if (typeTreasure.equals("")) {
                continue;
            } else if (input < bag.values().stream()
                    .map(Map::values).flatMap(Collection::stream).mapToLong(e -> e).sum() + count) {
                continue;
            }

            switch (typeTreasure) {
                case "Gem":
                    if (!bag.containsKey(typeTreasure)) {
                        if (bag.containsKey("Gold")) {
                            if (count > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (bag.get(typeTreasure).values().stream()
                            .mapToLong(e -> e).sum() + count > bag.get("Gold")
                            .values().stream().mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
                case "Cash":
                    if (!bag.containsKey(typeTreasure)) {
                        if (bag.containsKey("Gem")) {
                            if (count > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (bag.get(typeTreasure).values().stream()
                            .mapToLong(e -> e).sum() + count > bag.get("Gem")
                            .values().stream().mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
            }

            if (!bag.containsKey(typeTreasure)) {
                bag.put((typeTreasure), new LinkedHashMap<String, Long>());
            }

            if (!bag.get(typeTreasure).containsKey(name)) {
                bag.get(typeTreasure).put(name, 0L);
            }


            bag.get(typeTreasure).put(name, bag.get(typeTreasure).get(name) + count);
            if (typeTreasure.equals("Gold")) {
                gold += count;
            } else if (typeTreasure.equals("Gem")) {
                stones += count;
            } else if (typeTreasure.equals("Cash")) {
                money += count;
            }
        }

        for (var x : bag.entrySet()) {
            Long sumValues = x.getValue().values().stream().mapToLong(l -> l).sum();

            System.out.printf("<%s> $%s%n", x.getKey(), sumValues);

            x.getValue().entrySet().stream()
                    .sorted((e1, e2) -> e2.getKey()
                            .compareTo(e1.getKey()))
                    .forEach(i -> System.out.println("##" + i.getKey() + " - " + i.getValue()));

        }
    }
}