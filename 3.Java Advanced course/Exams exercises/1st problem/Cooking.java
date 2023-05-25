package Exams;

import java.util.*;

public class P01Cooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] first = scanner.nextLine().split(" ");
        String[] second = scanner.nextLine().split(" ");

        ArrayDeque<Integer> liquids = new ArrayDeque<>();
        ArrayDeque<Integer> ingredients = new ArrayDeque<>();

        Map<String, Integer> map = new TreeMap<>();
        map.put("Bread", 0);
        map.put("Cake", 0);
        map.put("Pastry", 0);
        map.put("Fruit Pie", 0);

        for (int i = 0; i < first.length; i++) {

            liquids.offer(Integer.parseInt(first[i]));
        }

        for (int i = 0; i < second.length; i++) {

            ingredients.push(Integer.parseInt(second[i]));
        }

        while (liquids.size() > 0 && ingredients.size() > 0) {

            int liquid = liquids.poll();
            int ingredient = ingredients.pop();
            int result = liquid + ingredient;

            if (result == 25) {
                map.put("Bread", map.get("Bread") + 1);

            } else if (result == 50) {
                map.put("Cake", map.get("Cake") + 1);

            } else if (result == 75) {
                map.put("Pastry", map.get("Pastry") + 1);

            } else if (result == 100) {
                map.put("Fruit Pie", map.get("Fruit Pie") + 1);

            } else {
                ingredient += 3;
                ingredients.addFirst(ingredient);
            }

        }
        int countFood = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {

            if (entry.getValue() > 0) {
                countFood++;
            }
        }
        if (countFood == 4) {

            System.out.println("Wohoo! You succeeded in cooking all the food!");

        } else {

            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }
        if (liquids.size() > 0) {
            List<String> liquidsLeft = new ArrayList<>();
            while (liquids.size() > 0) {
                liquidsLeft.add(String.valueOf(liquids.poll()));
            }
            System.out.printf("Liquids left: %s%n", String.join(", ", liquidsLeft));

        } else {

            System.out.println("Liquids left: none");
        }
        if (ingredients.size() > 0) {
            List<String> ingredientsLeft = new ArrayList<>();
            while (ingredients.size() > 0) {
                ingredientsLeft.add(String.valueOf(ingredients.pop()));
            }
            System.out.printf("Ingredients left: %s%n", String.join(", ", ingredientsLeft));

        } else {

            System.out.println("Ingredients left: none");
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {

            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
        }


    }
}
