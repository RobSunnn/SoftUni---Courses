package P05SetsAndMapsAdvanced.lab;

import java.util.*;

public class P07CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, Map<String, List<String>>> cities = new LinkedHashMap<>();

        while (count-- > 0) {
            String[] inputLine = scanner.nextLine().split("\\s+");
            String continent = inputLine[0];
            String country = inputLine[1];
            String city = inputLine[2];

            if (!cities.containsKey(continent)) {

                cities.put(continent, new LinkedHashMap<>());
                cities.get(continent).put(country, new ArrayList<>());
                cities.get(continent).get(country).add(city);

            } else {

                if (!cities.get(continent).containsKey(country)) {

                    cities.get(continent).put(country, new ArrayList<>());
                    cities.get(continent).get(country).add(city);

                } else {

                    cities.get(continent).get(country).add(city);
                }
            }

        }

        for (Map.Entry<String, Map<String, List<String>>> entry : cities.entrySet()) {

            System.out.printf("%s:%n", entry.getKey());
            for (Map.Entry<String, List<String>> listEntry : entry.getValue().entrySet()) {

                System.out.printf("  %s -> ", listEntry.getKey());
                System.out.printf("%s", String.join(", ", listEntry.getValue()));


                System.out.println();

            }


        }

    }
}
