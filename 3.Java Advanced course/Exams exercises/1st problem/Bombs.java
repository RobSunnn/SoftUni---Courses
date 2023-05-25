package Exams;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P01Bombs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstInput = scanner.nextLine().split(",\\s+");
        String[] secondInput = scanner.nextLine().split(",\\s+");

        ArrayDeque<Integer> bombEffectQueue = new ArrayDeque<>();
        ArrayDeque<Integer> bombCasingStack = new ArrayDeque<>();

        for (String s : firstInput) {
            bombEffectQueue.offer(Integer.parseInt(s));
        }
        for (String s : secondInput) {
            bombCasingStack.push(Integer.parseInt(s));
        }

        Map<String, Integer> bombsMade = new TreeMap<>();
        bombsMade.put("Datura Bombs", 0);
        bombsMade.put("Cherry Bombs", 0);
        bombsMade.put("Smoke Decoy Bombs", 0);

        boolean isBombPouchFull = false;

        while (!bombEffectQueue.isEmpty() && !bombCasingStack.isEmpty()) {

            int bombEffect = bombEffectQueue.poll();
            int bombCasing = bombCasingStack.pop();

            int result = bombEffect + bombCasing;

            if (result == 40) {
                bombsMade.put("Datura Bombs", bombsMade.get("Datura Bombs") + 1);
            } else if (result == 60) {
                bombsMade.put("Cherry Bombs", bombsMade.get("Cherry Bombs") + 1);
            } else if (result == 120) {
                bombsMade.put("Smoke Decoy Bombs", bombsMade.get("Smoke Decoy Bombs") + 1);
            } else {
                bombCasing -= 5;
                bombCasingStack.push(bombCasing);
                bombEffectQueue.addFirst(bombEffect);
            }

            for (Map.Entry<String, Integer> entry : bombsMade.entrySet()) {
                if (entry.getValue() >= 3) {
                    isBombPouchFull = true;
                } else {
                    isBombPouchFull = false;
                    break;
                }
            }

            if (isBombPouchFull) {
                break;
            }


        }

        if (isBombPouchFull) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        if (bombEffectQueue.isEmpty()) {
            System.out.println("Bomb Effects: empty");
        } else {
            List<String> bombEffectsLeft = new ArrayList<>();
            while (!bombEffectQueue.isEmpty()) {
                bombEffectsLeft.add(String.valueOf(bombEffectQueue.poll()));
            }
            System.out.printf("Bomb Effects: %s%n", String.join(", ", bombEffectsLeft));
        }

        if (bombCasingStack.isEmpty()) {
            System.out.println("Bomb Casings: empty");
        } else {
            List<String> bombCasingsLeft = new ArrayList<>();
            while (!bombCasingStack.isEmpty()) {
                bombCasingsLeft.add(String.valueOf(bombCasingStack.pop()));
            }
            System.out.printf("Bomb Casings: %s%n", String.join(", ", bombCasingsLeft));
        }

        for (Map.Entry<String, Integer> entry : bombsMade.entrySet()) {

            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
        }


    }


}


