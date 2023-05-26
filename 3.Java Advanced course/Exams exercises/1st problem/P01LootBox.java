package Exams;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P01LootBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstInput = scanner.nextLine().split(" ");
        String[] secondInput = scanner.nextLine().split(" ");

        ArrayDeque<Integer> firstItemsBox = new ArrayDeque<>();
        ArrayDeque<Integer> secondItemsBox = new ArrayDeque<>();

        for (String s : firstInput) {

            firstItemsBox.offer(Integer.parseInt(s));
        }
        for (String s : secondInput) {

            secondItemsBox.push(Integer.parseInt(s));
        }

        int value = 0;

        while (firstItemsBox.size() > 0 && secondItemsBox.size() > 0) {
            int first = firstItemsBox.poll();
            int second = secondItemsBox.pop();

            int result = first + second;

            if (result % 2 == 0) {
                value += result;

            } else {
                firstItemsBox.addFirst(first);
                firstItemsBox.addLast(second);

            }

            if (firstItemsBox.size() == 0) {

                System.out.println("First lootbox is empty");
                break;
            }
            if (secondItemsBox.size() == 0) {

                System.out.println("Second lootbox is empty");
                break;
            }


        }

        if (value >= 100) {

            System.out.printf("Your loot was epic! Value: %d%n", value);
        } else {

            System.out.printf("Your loot was poor... Value: %d%n", value);
        }

    }
}
