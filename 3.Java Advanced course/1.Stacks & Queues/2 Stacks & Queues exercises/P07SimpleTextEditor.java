package P02StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P07SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfOperations = Integer.parseInt(scanner.nextLine());
        StringBuilder textBuilder = new StringBuilder();
        ArrayDeque<String> textBeforeCommand = new ArrayDeque<>();

        for (int i = 0; i < numberOfOperations; i++) {
            String command = scanner.nextLine();

            if (command.startsWith("1")) {

                String textToAdd = command.split("\\s+")[1];

                textBeforeCommand.push(textBuilder.toString());
                textBuilder.append(textToAdd);

            } else if (command.startsWith("2")) {
                int count = Integer.parseInt(command.split("\\s+")[1]);

                textBeforeCommand.push(textBuilder.toString());
                textBuilder.delete(textBuilder.length() - count, textBuilder.length());

            } else if (command.startsWith("3")) {
                int indexOfElement = Integer.parseInt(command.split("\\s+")[1]);

                System.out.println(textBuilder.toString().charAt(indexOfElement - 1));

            } else if (command.startsWith("4")) {

                if (!textBeforeCommand.isEmpty()) {

                    String textToRestore = textBeforeCommand.pop();

                    textBuilder = new StringBuilder(textToRestore);

                }

            }

        }
    }
}
