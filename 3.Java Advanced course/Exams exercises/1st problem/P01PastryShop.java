package Exams;

import java.util.*;

public class P01PastryShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] liquidsArr = scanner.nextLine().split(" ");
        String[] ingredientsArr = scanner.nextLine().split(" ");

        ArrayDeque<Integer> liquidsStack = new ArrayDeque<>();
        ArrayDeque<Integer> ingredientsQueue = new ArrayDeque<>();

        Map<String, Integer> pastryMap = new LinkedHashMap<>();

        pastryMap.put("Biscuit", 0);
        pastryMap.put("Cake", 0);
        pastryMap.put("Pie", 0);
        pastryMap.put("Pastry", 0);

        for (int i = liquidsArr.length - 1; i >= 0; i--) {

            liquidsStack.push(Integer.parseInt(liquidsArr[i]));
        }

        for (int i = ingredientsArr.length - 1; i >= 0; i--) {

            ingredientsQueue.offer(Integer.parseInt(ingredientsArr[i]));
        }


        while (liquidsStack.size() > 0 && ingredientsQueue.size() > 0) {

            int liquid = liquidsStack.pop();
            int ingredient = ingredientsQueue.poll();

            int result = liquid + ingredient;

            if (result == 25) {
                pastryMap.put("Biscuit", pastryMap.get("Biscuit") + 1);

            } else if (result == 50) {
                pastryMap.put("Cake", pastryMap.get("Cake") + 1);

            } else if (result == 75) {
                pastryMap.put("Pastry", pastryMap.get("Pastry") + 1);

            } else if (result == 100) {
                pastryMap.put("Pie", pastryMap.get("Pie") + 1);

            } else {
                ingredient += 3;
                ingredientsQueue.addFirst(ingredient);
            }
        }

        int countProducts = 0;

        for (Map.Entry<String, Integer> entry : pastryMap.entrySet()) {

            if (entry.getValue() > 0) {
                countProducts++;
            } else {
                break;
            }
        }
        if (countProducts == 4) {

            System.out.println("Great! You succeeded in cooking all the food!");
        } else {

            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }

        if (liquidsStack.size() > 0) {
            List<String> productsLeft = new ArrayList<>();

            while (liquidsStack.size() > 0) {

                productsLeft.add(String.valueOf(liquidsStack.pop()));
            }

            System.out.printf("Liquids left: %s%n", String.join(", ", productsLeft));

        } else {
            System.out.println("Liquids left: none");
        }

        if (ingredientsQueue.size() > 0) {
            List<String> productsLeft = new ArrayList<>();

            while (ingredientsQueue.size() > 0) {
                productsLeft.add(String.valueOf(ingredientsQueue.poll()));
            }
            System.out.printf("Ingredients left: %s%n", String.join(", ", productsLeft));

        } else {
            System.out.println("Ingredients left: none");
        }

        for (Map.Entry<String, Integer> entry : pastryMap.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
        }


    }
}
