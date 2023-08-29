package fundamentals.exams;

import java.util.*;

public class Pirates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<Integer>> cities = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("Sail")) {
            String[] data = input.split("\\|");
            String city = data[0];
            int population = Integer.parseInt(data[2]);
            int gold = Integer.parseInt(data[4]);

            if (!cities.containsKey(city)) {
                cities.put(city, new ArrayList<>());
                cities.get(city).add(0, 0);
                cities.get(city).add(1, 0);
            }
            int currentPopulation = cities.get(city).get(0);
            int currentGold = cities.get(city).get(1);
            List<Integer> list = cities.get(city);
            list.set(0, currentPopulation + population);
            list.set(1, currentGold + gold);

            cities.put(city, list);

            input = scanner.nextLine();
        }

        String event = scanner.nextLine();

        while (!event.equals("End")) {
            String[] data = event.split("=>");
            String action = data[0];
            String town = data[1];

            switch (action) {
                case "Plunder":
                    int people = Integer.parseInt(data[2]);
                    int gold = Integer.parseInt(data[3]);

                    List<Integer> list = cities.get(town);
                    list.set(0, list.get(0) - people);
                    list.set(1, list.get(1) - gold);
                    cities.put(town, list);
                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", town, gold, people);

                    if (list.get(0) <= 0 || list.get(1) <= 0) {
                        System.out.printf("%s has been wiped off the map!%n", town);
                        cities.remove(town);
                    }

                    break;
                case "Prosper":
                    int goldToAdd = Integer.parseInt(data[2]);
                    if (goldToAdd < 0) {
                        System.out.println("Gold added cannot be a negative number!");
                        break;
                    }
                    cities.get(town).set(1, cities.get(town).get(1) + goldToAdd);
                    int totalGold = cities.get(town).get(1);
                    System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n", goldToAdd, town, totalGold);
                    break;
            }


            event = scanner.nextLine();
        }

        if (cities.isEmpty()) {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        } else {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", cities.size());
            for (Map.Entry<String, List<Integer>> entry : cities.entrySet()) {
                System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n", entry.getKey(), entry.getValue().get(0), entry.getValue().get(1));
            }

        }


    }
}
