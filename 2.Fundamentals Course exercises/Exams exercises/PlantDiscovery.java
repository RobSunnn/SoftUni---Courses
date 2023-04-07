package fundamentals.exams;

import java.util.*;

public class PlantDiscovery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPlants = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> plants = new LinkedHashMap<>();

        for (int i = 0; i < numberOfPlants; i++) {
            String[] data = scanner.nextLine().split("<->");
            String plantName = data[0];
            double rarity = Double.parseDouble(data[1]);

            if (!plants.containsKey(plantName)) {
                plants.put(plantName, new ArrayList<>());
                plants.get(plantName).add(0, 0.0);
                plants.get(plantName).add(1, 0.0);
            }
            double currentRarity = plants.get(plantName).get(0);
            plants.get(plantName).add(0, currentRarity + rarity);

        }

        String input = scanner.nextLine();

        while (!input.equals("Exhibition")) {
            String[] data = input.split(": ");
            String command = data[0];
            String plantInfo = data[1];
            String[] plantNameAndPlantNum = plantInfo.split(" - ");
            String plantName = plantNameAndPlantNum[0];

            switch (command) {
                case "Rate":
                    double newRating = Double.parseDouble(plantNameAndPlantNum[1]);
                    if (!plants.containsKey(plantName)) {
                        System.out.println("error");
                        break;
                    }
                    double oldRating = plants.get(plantName).get(1);
                    if (oldRating == 0.0) {
                        plants.get(plantName).set(1, (oldRating + newRating));
                    } else {
                        plants.get(plantName).set(1, (oldRating + newRating) / 2);
                    }

                    break;
                case "Update":
                    double newRarity = Double.parseDouble(plantNameAndPlantNum[1]);
                    if (!plants.containsKey(plantName)) {
                        System.out.println("error");
                        break;
                    }
                    plants.get(plantName).set(0, newRarity);
                    break;
                case "Reset":
                    if (!plants.containsKey(plantName)) {
                        System.out.println("error");
                        break;
                    }
                    plants.get(plantName).set(1, 0.0);
                    break;
            }

            input = scanner.nextLine();
        }
        System.out.println("Plants for the exhibition:");
        for (Map.Entry<String, List<Double>> entry : plants.entrySet()) {
            System.out.printf("- %s; Rarity: %.0f; Rating: %.2f%n", entry.getKey(),
                    entry.getValue().get(0), entry.getValue().get(1));
        }


    }

}
