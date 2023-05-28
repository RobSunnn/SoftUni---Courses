package Exams;

import java.util.*;


public class _01_ {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstInput = scanner.nextLine().split("\\s+");
        String[] secondInput = scanner.nextLine().split("\\s+");

        ArrayDeque<Integer> textilesQueue = new ArrayDeque<>();
        ArrayDeque<Integer> medicamentStack = new ArrayDeque<>();

        for (String s : firstInput) {
            textilesQueue.offer(Integer.parseInt(s));
        }
        for (String s : secondInput) {
            medicamentStack.push(Integer.parseInt(s));
        }

        Map<String, Integer> map = new TreeMap<>();

        map.put("Patch", 0);
        map.put("Bandage", 0);
        map.put("MedKit", 0);

        while (!textilesQueue.isEmpty() && !medicamentStack.isEmpty()) {
            int textile = textilesQueue.poll();
            int medicament = medicamentStack.pop();

            int result = textile + medicament;

            if (result == 30) {
                map.put("Patch", map.get("Patch") + 1);
            } else if (result == 40) {
                map.put("Bandage", map.get("Bandage") + 1);
            } else if (result == 100) {
                map.put("MedKit", map.get("MedKit") + 1);
            } else {
                if (result > 100) {
                    map.put("MedKit", map.get("MedKit") + 1);
                    result -= 100;
                    result += medicamentStack.pop();
                    medicamentStack.push(result);

                } else {
                    medicament += 10;
                    medicamentStack.push(medicament);
                }
            }

        }

        if (medicamentStack.isEmpty() && textilesQueue.isEmpty()) {
            System.out.println("Textiles and medicaments are both empty.");
        } else if (medicamentStack.isEmpty()) {
            System.out.println("Medicaments are empty.");
        } else if (textilesQueue.isEmpty()) {
            System.out.println("Textiles are empty.");
        }

        map.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue(Comparator.reverseOrder())).
                forEach(e ->
                {
                    if (e.getValue() > 0) {
                        System.out.println(e.getKey() + " - " + e.getValue());
                    }
                });

        if (!medicamentStack.isEmpty()) {
            List<String> list = new ArrayList<>();
            while (!medicamentStack.isEmpty()) {
                list.add(String.valueOf(medicamentStack.pop()));
            }
            System.out.printf("Medicaments left: %s%n", String.join(", ", list));
        }
        if (!textilesQueue.isEmpty()) {
            List<String> list = new ArrayList<>();
            while (!textilesQueue.isEmpty()) {
                list.add(String.valueOf(textilesQueue.poll()));
            }
            System.out.printf("Textiles left: %s%n", String.join(", ", list));
        }


    }
}
