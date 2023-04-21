package P02StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P03MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> sequence = new ArrayDeque<>();
        int n = Integer.parseInt(scanner.nextLine());
        int maxNum = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            String[] commandLine = scanner.nextLine().split("\\s+");
            String command = commandLine[0];

            switch (command) {
                case "1":
                    int num = Integer.parseInt(commandLine[1]);

                    sequence.push(num);
                    break;
                case "2":

                    sequence.pop();
                    break;
                case "3":

                    for (int j = 0; j < sequence.size(); j++) {

                        int currentNum = sequence.peek();
                        sequence.add(sequence.poll());

                        if (currentNum > maxNum) {
                            maxNum = currentNum;
                        }

                    }
                    System.out.println(maxNum);
                    maxNum = Integer.MIN_VALUE;
                    break;
            }
        }
    }
}
