package Exams;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P01ClimbThePeaks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] stackInput = scanner.nextLine().split(",\\s+");
        String[] queueInput = scanner.nextLine().split(",\\s+");

        ArrayDeque<Integer> foodSuppliesStack = new ArrayDeque<>();
        ArrayDeque<Integer> dailyStaminaQueue = new ArrayDeque<>();
        ArrayDeque<String> peaks = new ArrayDeque<>();
        ArrayDeque<Integer> difficulty = new ArrayDeque<>();
        List<String> conqueredPeaks = new ArrayList<>();

        for (int i = 0; i < stackInput.length; i++) {

            foodSuppliesStack.push(Integer.parseInt(stackInput[i]));
        }

        for (int i = 0; i < queueInput.length; i++) {

            dailyStaminaQueue.offer(Integer.parseInt(queueInput[i]));
            ;
        }

        peaks.push("Kamenitza");
        peaks.push("Polezhan");
        peaks.push("Banski Suhodol");
        peaks.push("Kutelo");
        peaks.push("Vihren");
        difficulty.push(70);
        difficulty.push(60);
        difficulty.push(100);
        difficulty.push(90);
        difficulty.push(80);

        while (foodSuppliesStack.size() > 0 && dailyStaminaQueue.size() > 0) {

            int food = foodSuppliesStack.pop();
            int stamina = dailyStaminaQueue.poll();
            int difficultyOfPeak = difficulty.peek();

            if (food + stamina >= difficultyOfPeak) {

                conqueredPeaks.add(peaks.pop());
                difficulty.pop();

            }

            if (conqueredPeaks.size() == 5) {

                System.out.println("Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK");
                break;
            }
        }

        if (conqueredPeaks.size() < 5) {

            System.out.println("Alex failed! He has to organize his journey better next time -> @PIRINWINS");
        }


        if (conqueredPeaks.size() > 0) {
            System.out.println("Conquered peaks:");
            for (int i = 0; i < conqueredPeaks.size(); i++) {

                System.out.println(conqueredPeaks.get(i));
            }
        }


    }
}
