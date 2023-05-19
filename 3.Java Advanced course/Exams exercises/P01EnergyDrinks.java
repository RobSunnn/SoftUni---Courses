package Exams;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P01EnergyDrinks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstInput = scanner.nextLine().split(", ");
        String[] secondInput = scanner.nextLine().split(", ");

        int caffeineInTheBlood = 0;

        ArrayDeque<Integer> milligramsOfCaffeineStack = new ArrayDeque<>();
        ArrayDeque<Integer> energyDrinksQueue = new ArrayDeque<>();

        for (String s : firstInput) {
            milligramsOfCaffeineStack.push(Integer.parseInt(s));
        }
        for (String s : secondInput) {
            energyDrinksQueue.offer(Integer.parseInt(s));
        }


        while (milligramsOfCaffeineStack.size() > 0 && energyDrinksQueue.size() > 0) {

            int milligramsOfCaffeine = milligramsOfCaffeineStack.pop();
            int energyDrink = energyDrinksQueue.poll();

            int result = milligramsOfCaffeine * energyDrink;

            if (result <= 300 - caffeineInTheBlood) {
                caffeineInTheBlood += result;
            } else {
                energyDrinksQueue.addLast(energyDrink);
                caffeineInTheBlood -= 30;

                if (caffeineInTheBlood < 0) {
                    caffeineInTheBlood = 0;
                }
            }
        }

        if (energyDrinksQueue.size() > 0) {
            List<String> energyDrinksList = new ArrayList<>();
            while (energyDrinksQueue.size() > 0) {
                energyDrinksList.add(String.valueOf(energyDrinksQueue.poll()));
            }
            System.out.printf("Drinks left: %s%n", String.join(", ", energyDrinksList));
        } else {

            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        }

        System.out.printf("Stamat is going to sleep with %d mg caffeine.%n", caffeineInTheBlood);

    }


}


