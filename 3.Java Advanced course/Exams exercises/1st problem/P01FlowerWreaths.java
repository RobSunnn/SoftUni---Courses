package Exams;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P01FlowerWreaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstInput = scanner.nextLine().split(", ");
        String[] secondInput = scanner.nextLine().split(", ");

        ArrayDeque<Integer> rosesQueue = new ArrayDeque<>();
        ArrayDeque<Integer> liliesStack = new ArrayDeque<>();

        for (String s : firstInput) {
            rosesQueue.offer(Integer.parseInt(s));
        }
        for (String s : secondInput) {
            liliesStack.push(Integer.parseInt(s));
        }

        int wreathsMade = 0;

        ArrayDeque<Integer> flowersLeft = new ArrayDeque<>();

        while (!rosesQueue.isEmpty() && !liliesStack.isEmpty()) {
            int rose = rosesQueue.poll();
            int lilly = liliesStack.pop();

            int result = rose + lilly;

            if (result == 15) {
                wreathsMade++;
            } else if (result > 15) {
                lilly -= 2;
                rosesQueue.addFirst(rose);
                liliesStack.push(lilly);
            } else {
                flowersLeft.add(rose);
                flowersLeft.add(lilly);
            }

        }

        if (!flowersLeft.isEmpty()) {
            int sum = 0;
            while (!flowersLeft.isEmpty()) {
                sum += flowersLeft.pop();
            }
            wreathsMade += sum / 15;
        }

        if (wreathsMade >= 5) {
            System.out.printf("You made it, you are going to the competition with %d wreaths!%n", wreathsMade);
        } else {
            System.out.printf("You didn't make it, you need %d wreaths more!%n", 5 - wreathsMade);
        }

    }


}


