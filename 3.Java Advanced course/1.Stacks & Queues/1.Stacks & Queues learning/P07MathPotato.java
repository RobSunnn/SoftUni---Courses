package P01StacksAndQueues.lab;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class P07MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] kidsArr = scanner.nextLine().split(" ");
        PriorityQueue<String> kids = new PriorityQueue<>();
        Collections.addAll(kids, kidsArr);

        int rolls = Integer.parseInt(scanner.nextLine());
        int index = 0;

        while (kids.size() > 1) {

            for (int i = 1; i < rolls; i++) {

                kids.offer(kids.poll());

            }
            index++;
            if (isPrime(index)) {
                System.out.println("Prime " + kids.peek());

            } else {

                System.out.println("Removed " + kids.poll());
            }

        }
        System.out.println("Last is " + kids.poll());
    }

    public static boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }

        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
