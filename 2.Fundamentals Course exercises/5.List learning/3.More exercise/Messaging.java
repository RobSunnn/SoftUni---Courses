package More.ExerciseList;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Messaging {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String message = scanner.nextLine().trim();
        StringBuilder messageBuilder = new StringBuilder(message);
        StringBuilder theMessage = new StringBuilder();
        int sumOfCurrentElement = 0;

        for (int currentNumFromList : list) {
            while (currentNumFromList > 0) {
                int currentNum = currentNumFromList % 10;
                sumOfCurrentElement += currentNum;
                currentNumFromList = currentNumFromList / 10;
            }
            if (sumOfCurrentElement > message.length()) {
                sumOfCurrentElement = sumOfCurrentElement - message.length();
            }
            char symbol = messageBuilder.charAt(sumOfCurrentElement);
            theMessage.append(symbol);
            messageBuilder.deleteCharAt(sumOfCurrentElement);

            sumOfCurrentElement = 0;

        }
        System.out.println(theMessage);
    }
}
