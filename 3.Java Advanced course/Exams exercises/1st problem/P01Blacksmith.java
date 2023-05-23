package Exams;

import java.util.*;

public class P01Blacksmith {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] steelInput = scanner.nextLine().split(" ");
        String[] carbonInput = scanner.nextLine().split(" ");

        ArrayDeque<Integer> steelDeque = new ArrayDeque<>();
        ArrayDeque<Integer> carbonStack = new ArrayDeque<>();

        for (int i = 0; i < steelInput.length; i++) {
            steelDeque.offer(Integer.parseInt(steelInput[i]));
        }
        for (int i = 0; i < carbonInput.length; i++) {
            carbonStack.push(Integer.parseInt(carbonInput[i]));
        }

        Map<String, Integer> swords = new TreeMap<>();
        swords.put("Gladius", 0);
        swords.put("Shamshir", 0);
        swords.put("Katana", 0);
        swords.put("Sabre", 0);

        while (steelDeque.size() > 0 && carbonStack.size() > 0) {
            int steel = steelDeque.poll();
            int carbon = carbonStack.pop();

            int result = steel + carbon;

            if (result == 70) {
                swords.put("Gladius", swords.get("Gladius") + 1);

            } else if (result == 80) {
                swords.put("Shamshir", swords.get("Shamshir") + 1);

            } else if (result == 90) {
                swords.put("Katana", swords.get("Katana") + 1);

            } else if (result == 110) {
                swords.put("Sabre", swords.get("Sabre") + 1);

            } else {

                carbon += 5;
                carbonStack.addFirst(carbon);
            }

        }

        int countSwords = 0;

        for (Map.Entry<String, Integer> entry : swords.entrySet()) {
            if (entry.getValue() > 0) {
                countSwords += entry.getValue();
            }

        }
        if (countSwords > 0) {
            System.out.printf("You have forged %d swords.%n", countSwords);

        } else {

            System.out.println("You did not have enough resources to forge a sword.");
        }

        if (steelDeque.size() > 0) {
            List<String> steelLeft = new ArrayList<>();

            while (steelDeque.size() > 0) {

                steelLeft.add(String.valueOf(steelDeque.poll()));
            }
            System.out.printf("Steel left: %s%n", String.join(", ", steelLeft));

        } else {

            System.out.println("Steel left: none");
        }

        if (carbonStack.size() > 0) {

            List<String> carbonLeft = new ArrayList<>();

            while (carbonStack.size() > 0) {

                carbonLeft.add(String.valueOf(carbonStack.pop()));
            }
            System.out.printf("Carbon left: %s%n", String.join(", ", carbonLeft));
        } else {
            System.out.println("Carbon left: none");
        }
        for (Map.Entry<String, Integer> entry : swords.entrySet()) {
            if (entry.getValue() > 0) {
                System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
            }

        }


    }


}
