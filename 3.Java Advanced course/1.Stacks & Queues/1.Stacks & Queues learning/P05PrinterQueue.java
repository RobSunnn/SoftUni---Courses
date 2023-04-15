package P01StacksAndQueues.lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P05PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<String> docs = new ArrayDeque<>();


        while (!input.equals("print")) {

            if (input.equals("cancel")) {

                if (docs.isEmpty()) {
                    System.out.println("Printer is on standby");
                } else {

                    System.out.println("Canceled " + docs.poll());
                }
            } else {

                docs.offer(input);
            }

            input = scanner.nextLine();
        }

        while (!docs.isEmpty()) {
            System.out.println(docs.pollFirst());
        }

    }
}
