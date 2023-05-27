package Exams;

import java.util.*;

public class P01SantaPresentFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstInput = scanner.nextLine().split(" ");
        String[] secondInput = scanner.nextLine().split(" ");

        ArrayDeque<Integer> materialsStack = new ArrayDeque<>();
        ArrayDeque<Integer> magicLevelQueue = new ArrayDeque<>();

        for (String s : firstInput) {
            materialsStack.push(Integer.parseInt(s));
        }

        for (String s : secondInput) {
            magicLevelQueue.offer(Integer.parseInt(s));
        }

        Map<String, Integer> toys = new TreeMap<>();
        toys.put("Doll", 0);
        toys.put("Wooden train", 0);
        toys.put("Teddy bear", 0);
        toys.put("Bicycle", 0);


        while (materialsStack.size() > 0 && magicLevelQueue.size() > 0) {
            int material = materialsStack.pop();
            if (material == 0) {
                continue;
            }
            int magicLevel = magicLevelQueue.poll();

            if (magicLevel == 0) {
                materialsStack.addFirst(material);
                continue;
            }
            int totalMagicLevel = material * magicLevel;
            if (totalMagicLevel == 150) {
                toys.put("Doll", toys.get("Doll") + 1);
            } else if (totalMagicLevel == 250) {
                toys.put("Wooden train", toys.get("Wooden train") + 1);
            } else if (totalMagicLevel == 300) {
                toys.put("Teddy bear", toys.get("Teddy bear") + 1);
            } else if (totalMagicLevel == 400) {
                toys.put("Bicycle", toys.get("Bicycle") + 1);
            } else {

                if (totalMagicLevel < 0) {
                    totalMagicLevel = material + magicLevel;
                    if (totalMagicLevel > 0) {
                        materialsStack.addFirst(totalMagicLevel);
                    }
                } else {
                    material += 15;
                    materialsStack.addFirst(material);
                }
            }

        }

        if (toys.get("Doll") >= 1 && toys.get("Wooden train") >= 1
                || toys.get("Teddy bear") >= 1 && toys.get("Bicycle") >= 1) {

            System.out.println("The presents are crafted! Merry Christmas!");
        } else {

            System.out.println("No presents this Christmas!");
        }
        if (materialsStack.size() > 0) {
            List<String> materialsLeft = new ArrayList<>();
            while (materialsStack.size() > 0) {
                int current = materialsStack.pop();
                if (current != 0) {
                    materialsLeft.add(String.valueOf(current));
                }
            }
            if (materialsLeft.size() > 0) {
                System.out.printf("Materials left: %s%n", String.join(", ", materialsLeft));
            }

        }
        if (magicLevelQueue.size() > 0) {
            List<String> magicLeft = new ArrayList<>();
            while (magicLevelQueue.size() > 0) {
                int current = magicLevelQueue.poll();
                if (current != 0) {
                    magicLeft.add(String.valueOf(current));
                }
            }
            if (magicLeft.size() > 0) {
                System.out.printf("Magic left: %s%n", String.join(", ", magicLeft));
            }
        }

        for (Map.Entry<String, Integer> entry : toys.entrySet()) {

            if (entry.getValue() > 0) {

                System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
            }
        }


    }
}
