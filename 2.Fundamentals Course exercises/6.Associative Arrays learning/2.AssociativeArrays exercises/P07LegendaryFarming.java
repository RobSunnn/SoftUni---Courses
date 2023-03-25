package fundamentals.P14.AssociativeArrays.exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P07LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("shards", 0);
        map.put("fragments", 0);
        map.put("motes", 0);

        Map<String, Integer> junk = new LinkedHashMap<>();

        while (true) {

            String[] lineInput = scanner.nextLine().split(" ");
            boolean isObtained = false;

            for (int i = 0; i <= lineInput.length - 1; i += 2) {
                int quantity = Integer.parseInt(lineInput[i]);
                String material = lineInput[i + 1].toLowerCase();

                if (material.equals("shards") || material.equals("fragments") || material.equals("motes")) {
                    int currentQuantity = map.get(material);
                    map.put(material, currentQuantity + quantity);
                } else {

                    if (!junk.containsKey(material)) {
                        junk.put(material, quantity);
                    } else {
                        int currentQuantity = junk.get(material);
                        junk.put(material, quantity + currentQuantity);
                    }

                }

                if (map.get("shards") >= 250) {

                    System.out.println("Shadowmourne obtained!");
                    map.put("shards", map.get("shards") - 250);
                    isObtained = true;
                    break;

                } else if (map.get("fragments") >= 250) {

                    System.out.println("Valanyr obtained!");
                    map.put("fragments", map.get("fragments") - 250);
                    isObtained = true;
                    break;

                } else if (map.get("motes") >= 250) {

                    System.out.println("Dragonwrath obtained!");
                    map.put("motes", map.get("motes") - 250);
                    isObtained = true;
                    break;

                }

            }
            if (isObtained) {
                break;
            }

        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
        }
        for (Map.Entry<String, Integer> entry : junk.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
        }


    }
}
