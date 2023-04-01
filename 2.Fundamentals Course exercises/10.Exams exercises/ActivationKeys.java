package fundamentals.exams;

import java.util.Scanner;

public class ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String key = scanner.nextLine();
        StringBuilder keyBuilder = new StringBuilder(key);

        String input = scanner.nextLine();

        while (!input.equals("Generate")) {
            String command = input.split(">>>")[0];

            if (command.equals("Contains")) {
                String substring = input.split(">>>")[1];
                if (keyBuilder.toString().contains(substring)) {
                    System.out.printf("%s contains %s%n", keyBuilder.toString(), substring);
                } else {
                    System.out.printf("Substring not found!%n");
                }

            } else if (command.equals("Flip")) {
                String upperOrLower = input.split(">>>")[1];
                int startIndex = Integer.parseInt(input.split(">>>")[2]);
                int endIndex = Integer.parseInt(input.split(">>>")[3]);
                if (upperOrLower.equals("Upper")) {
                    String substring = keyBuilder.substring(startIndex, endIndex);
                    substring = substring.toUpperCase();
                    keyBuilder.delete(startIndex, endIndex);
                    keyBuilder.insert(startIndex, substring);
                    System.out.println(keyBuilder);
                } else if (upperOrLower.equals("Lower")) {
                    String substring = keyBuilder.substring(startIndex, endIndex);
                    substring = substring.toLowerCase();
                    keyBuilder.delete(startIndex, endIndex);
                    keyBuilder.insert(startIndex, substring);
                    System.out.println(keyBuilder);
                }

            } else if (command.equals("Slice")) {
                int startIndex = Integer.parseInt(input.split(">>>")[1]);
                int endIndex = Integer.parseInt(input.split(">>>")[2]);
                keyBuilder.delete(startIndex, endIndex);
                System.out.println(keyBuilder);

            }
            input = scanner.nextLine();
        }
        System.out.printf("Your activation key is: %s%n", keyBuilder.toString());
    }
}
