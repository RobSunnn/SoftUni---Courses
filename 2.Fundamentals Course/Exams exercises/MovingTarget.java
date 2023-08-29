package fundamentals.exams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MovingTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> targets = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] commandInput = input.split(" ");
            String command = commandInput[0];
            int index = Integer.parseInt(commandInput[1]);

            if (command.equals("Shoot")) {
                int power = Integer.parseInt(commandInput[2]);

                if (isIndexValid(index, targets)) {
                    int currentValue = targets.get(index);
                    targets.set(index, currentValue - power);
                    if (targets.get(index) <= 0) {
                        targets.remove(index);
                    }
                }


            } else if (command.equals("Add")) {
                int value = Integer.parseInt(commandInput[2]);
                if (isIndexValid(index, targets)) {
                    targets.add(index, value);

                } else {
                    System.out.println("Invalid placement!");
                    input = scanner.nextLine();
                    continue;
                }

            } else if (command.equals("Strike")) {
                int radius = Integer.parseInt(commandInput[2]);
                if (isIndexValid(index, targets)) {
                    int left = index - radius;
                    int right = index + radius;

                    if (isIndexValid(left, targets) && isIndexValid(right, targets)) {
                        targets.subList(left, right + 1).clear();

                    } else {
                        System.out.println("Strike missed!");
                        input = scanner.nextLine();
                        continue;
                    }

                }

            }

            input = scanner.nextLine();
        }
        // String targetsToPrint = String.join(" ",targets.toString().replaceAll("[\\[\\],]",""));
        // System.out.println(targetsToPrint.replaceAll(" ","|"));
        for (int i = 0; i < targets.size() - 1; i++) {
            System.out.printf("%d|", targets.get(i));
        }
        System.out.println(targets.get(targets.size() - 1));

    }

    private static boolean isIndexValid(int n, List<Integer> list) {
        return n >= 0 && n <= list.size() - 1;
    }
}
