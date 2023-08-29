package fundamentals.exams;

import java.util.Scanner;

public class SecretChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();
        StringBuilder builder = new StringBuilder(message);

        String input = scanner.nextLine();

        while (!input.equals("Reveal")) {
            String[] commandInput = input.split(":\\|:");
            String command = commandInput[0];

            if (command.equals("InsertSpace")) {
                int index = Integer.parseInt(commandInput[1]);
                builder.insert(index, " ");
                System.out.println(builder);

            } else if (command.equals("Reverse")) {
                String sub = commandInput[1];
                if (builder.toString().contains(sub)) {
                    int index = builder.indexOf(sub);
                    int subLength = index + sub.length();
                    String toReverse = builder.substring(index, subLength);
                    StringBuilder toReverseBuilder = new StringBuilder(toReverse).reverse();
                    builder.delete(index, subLength);
                    builder.append(toReverseBuilder.toString());

                } else {
                    System.out.println("error");
                    input = scanner.nextLine();
                    continue;
                }
                System.out.println(builder);
            } else if (command.equals("ChangeAll")) {
                String substring = commandInput[1];
                String replacement = commandInput[2];
                if (!substring.equals(replacement)) {
                    while (builder.toString().contains(substring)) {
                        builder = new StringBuilder(builder.toString().replace(substring, replacement));
                    }
                }
                System.out.println(builder);
            }

            input = scanner.nextLine();
        }
        System.out.printf("You have a new text message: %s", builder);


    }
}
