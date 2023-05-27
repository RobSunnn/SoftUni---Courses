package Exams;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P01MagicBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] first = scanner.nextLine().split(" ");
        String[] second = scanner.nextLine().split(" ");

        ArrayDeque<Integer> firstItems = new ArrayDeque<>();
        ArrayDeque<Integer> secondItems = new ArrayDeque<>();

        for (int i = 0; i < first.length; i++) {

            firstItems.offer(Integer.parseInt(first[i]));
        }

        for (int i = 0; i < second.length; i++) {

            secondItems.push(Integer.valueOf(second[i]));
        }
        int total = 0;

        while (firstItems.size() > 0 && secondItems.size() > 0) {

            int firstItem = firstItems.pop();
            int lastItem = secondItems.poll();

            int result = firstItem + lastItem;

            if (result % 2 == 0) {
                total += result;

            } else {
                firstItems.addLast(lastItem);
                firstItems.addFirst(firstItem);

            }


            if (firstItems.size() == 0) {

                System.out.println("First magic box is empty.");
                break;
            }
            if (secondItems.size() == 0) {

                System.out.println("Second magic box is empty.");
                break;
            }


        }

        if (total >= 90) {

            System.out.printf("Wow, your prey was epic! Value: %d", total);
        } else {

            System.out.printf("Poor prey... Value: %d", total);
        }
    }
}
