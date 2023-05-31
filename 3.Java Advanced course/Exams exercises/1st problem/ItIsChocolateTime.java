package Exams;

import java.util.ArrayDeque;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P01ItIsChocolateTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstInput = scanner.nextLine().split(" ");
        String[] secondInput = scanner.nextLine().split(" ");

        ArrayDeque<Double> milkQueue = new ArrayDeque<>();
        ArrayDeque<Double> cacaoStack = new ArrayDeque<>();

        for (String s : firstInput) {
            milkQueue.offer(Double.parseDouble(s));
        }
        for (String s : secondInput) {
            cacaoStack.push(Double.parseDouble(s));
        }

        Map<String, Integer> map = new TreeMap<>();
        map.put("Milk Chocolate", 0);
        map.put("Dark Chocolate", 0);
        map.put("Baking Chocolate", 0);

        while (milkQueue.size() > 0 && cacaoStack.size() > 0) {
            double milk = milkQueue.poll();
            double cacao = cacaoStack.pop();

            double formula = (cacao / (milk + cacao)) * 100;

            if (formula == 30.0) {
                map.put("Milk Chocolate", map.get("Milk Chocolate") + 1);
            } else if (formula == 50.0) {
                map.put("Dark Chocolate", map.get("Dark Chocolate") + 1);
            } else if (formula == 100.0) {
                map.put("Baking Chocolate", map.get("Baking Chocolate") + 1);
            } else {
                milk += 10.0;
                milkQueue.addLast(milk);
            }


        }

        int countChocolates = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 0) {
                countChocolates++;
            }
        }

        if (countChocolates == 3) {
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        } else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 0) {
                System.out.printf("# %s --> %d%n", entry.getKey(), entry.getValue());
            }
        }


    }


}


