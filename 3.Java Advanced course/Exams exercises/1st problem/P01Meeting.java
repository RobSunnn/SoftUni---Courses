package Exams;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class P01Meeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstInput = scanner.nextLine().split(" ");
        String[] secondInput = scanner.nextLine().split(" ");

        ArrayDeque<Integer> malesStack = new ArrayDeque<>();
        ArrayDeque<Integer> femalesQueue = new ArrayDeque<>();

        for (String s : firstInput) {
            malesStack.push(Integer.parseInt(s));
        }
        for (String s : secondInput) {
            femalesQueue.offer(Integer.parseInt(s));
        }

        int matchesFound = 0;

        while (malesStack.size() > 0 && femalesQueue.size() > 0) {
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
                malesStack.push(male);
                femalesQueue.poll();
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

        if (malesStack.size() > 0) {
            List<String> malesLeftList = new ArrayList<>();
            while (malesStack.size() > 0) {
                malesLeftList.add(String.valueOf(malesStack.pop()));
            }
            System.out.printf("Males left: %s%n", String.join(", ", malesLeftList));
        } else {
            System.out.println("Males left: none");
        }

        if (femalesQueue.size() > 0) {
            List<String> femalesLeftList = new ArrayList<>();
            while (femalesQueue.size() > 0) {
                femalesLeftList.add(String.valueOf(femalesQueue.poll()));
            }
            System.out.printf("Females left: %s%n", String.join(", ", femalesLeftList));
        } else {
            System.out.println("Females left: none");
        }

    }


}


