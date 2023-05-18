package Exams;

import java.util.*;

public class P01AutumnCocktails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstInput = scanner.nextLine().split(" ");
        String[] secondInput = scanner.nextLine().split(" ");

        ArrayDeque<Integer> ingredientQueue = new ArrayDeque<>();
        ArrayDeque<Integer> freshnessLevelStack = new ArrayDeque<>();

        Map<String, Integer> cocktails = new TreeMap<>();
        cocktails.put("Pear Sour", 0);
        cocktails.put("The Harvest", 0);
        cocktails.put("Apple Hinny", 0);
        cocktails.put("High Fashion", 0);

        for (String s : firstInput) {

            ingredientQueue.offer(Integer.parseInt(s));
        }
        for (String s : secondInput) {

            freshnessLevelStack.push(Integer.parseInt(s));
        }

        while (ingredientQueue.size() > 0 && freshnessLevelStack.size() > 0) {
            int ingredient = ingredientQueue.poll();
            if (ingredient == 0) {
                continue;
            }
            int freshnessLevel = freshnessLevelStack.pop();

            int result = ingredient * freshnessLevel;

            if (result == 150) {

                cocktails.put("Pear Sour", cocktails.get("Pear Sour") + 1);
            } else if (result == 250) {

                cocktails.put("The Harvest", cocktails.get("The Harvest") + 1);
            } else if (result == 300) {

                cocktails.put("Apple Hinny", cocktails.get("Apple Hinny") + 1);
            } else if (result == 400) {

                cocktails.put("High Fashion", cocktails.get("High Fashion") + 1);
            } else {

                ingredient += 5;
                ingredientQueue.addLast(ingredient);
            }

        }

        int countCocktails = 0;

        for (Map.Entry<String, Integer> entry : cocktails.entrySet()) {

            if (entry.getValue() > 0) {

                countCocktails++;
            }
        }
        int sum = 0;
        if (ingredientQueue.size() > 0) {

            while (ingredientQueue.size() > 0) {
                sum += ingredientQueue.poll();
            }
        }
        if (freshnessLevelStack.size() > 0) {

            while (freshnessLevelStack.size() > 0) {
                sum += freshnessLevelStack.pop();
            }
        }

        if (countCocktails == 4) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }
        if (sum > 0) {
            System.out.printf("Ingredients left: %d%n", sum);
        }

        for (Map.Entry<String, Integer> entry : cocktails.entrySet()) {

            if (entry.getValue() > 0) {

                System.out.printf(" # %s --> %d%n", entry.getKey(), entry.getValue());
            }
        }


    }


}


