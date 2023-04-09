package fundamentals.exams;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String message = scanner.nextLine();
        StringBuilder messageBuilder = new StringBuilder(message);

        String input = scanner.nextLine();

        while (!input.equals("Decode")) {
            String command = input.split("\\|")[0];


            switch (command) {
                case "Move":
                    int numberOfLetters = Integer.parseInt(input.split("\\|")[1]);
                    String substring = messageBuilder.substring(0, numberOfLetters);

                    messageBuilder.delete(0, numberOfLetters);
                    messageBuilder.append(substring);
                    break;
                case "Insert":

                    int indexToInsert = Integer.parseInt(input.split("\\|")[1]);
                    String valueToInsert = input.split("\\|")[2];

                    messageBuilder.insert(indexToInsert, valueToInsert);
                    break;
                case "ChangeAll":
                    String substringToChange = input.split("\\|")[1];
                    String replacement = input.split("\\|")[2];

                    if (!substringToChange.equals(replacement)) {
                        while (messageBuilder.toString().contains(substringToChange)) {
                            messageBuilder = new StringBuilder(messageBuilder.toString().replace(substringToChange, replacement));

                        }

                    }

                    break;
            }


            input = scanner.nextLine();
        }
        System.out.printf("The decrypted message is: %s", messageBuilder);
    }


}
