package Exams;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P01DatingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstInput = scanner.nextLine().split("\\s+");
        String[] secondInput = scanner.nextLine().split("\\s+");


        ArrayDeque<Integer> malesStack = new ArrayDeque<>();
        ArrayDeque<Integer> femalesQueue = new ArrayDeque<>();

        for (String s : firstInput) {
            malesStack.push(Integer.parseInt(s));
        }
        for (String s : secondInput) {
            femalesQueue.offer(Integer.parseInt(s));
        }

        int matchesFound = 0;

        while (!malesStack.isEmpty() && !femalesQueue.isEmpty()) {

            int male = malesStack.pop();
            if (male <= 0) {
                continue;
            }
            if (male % 25 == 0) {
                malesStack.pop();
                continue;
            }

            int female = femalesQueue.poll();
            if (female <= 0) {
                malesStack.push(male);
                continue;
            }
            if (female % 25 == 0) {
                femalesQueue.poll();
                malesStack.push(male);
                continue;
            }

            if (male == female) {
                matchesFound++;
            } else {
                male -= 2;
                malesStack.push(male);
            }


        }

        System.out.printf("Matches: %d%n", matchesFound);

        if (malesStack.isEmpty()) {
            System.out.println("Males left: none");
        } else {
            List<String> malesLeft = new ArrayList<>();
            while (!malesStack.isEmpty()) {
                malesLeft.add(String.valueOf(malesStack.pop()));
            }
            System.out.printf("Males left: %s%n", String.join(", ", malesLeft));
        }

        if (femalesQueue.isEmpty()) {
            System.out.println("Females left: none");
        } else {
            List<String> femalesLeft = new ArrayList<>();
            while (!femalesQueue.isEmpty()) {
                femalesLeft.add(String.valueOf(femalesQueue.poll()));
            }
            System.out.printf("Females left: %s%n", String.join(", ", femalesLeft));
        }


    }
}
