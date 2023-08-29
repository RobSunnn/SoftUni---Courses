package fundamentals.exams;

import com.sun.security.jgss.GSSUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MemoryGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> theGame = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        String input = scanner.nextLine();
        int moves = 0;

        while (!input.equals("end")) {
            moves++;
            int firstIndex = Integer.parseInt(input.split(" ")[0]);
            int secondIndex = Integer.parseInt(input.split(" ")[1]);
            if (firstIndex == secondIndex || firstIndex < 0 || secondIndex >= theGame.size()
                    || firstIndex >= theGame.size() || secondIndex < 0) {

                int middleIndex = theGame.size() / 2;
                theGame.add(middleIndex, "" + "-" + moves + "a");
                theGame.add(middleIndex, "" + "-" + moves + "a");
                System.out.println("Invalid input! Adding additional elements to the board");
            } else {
                if (theGame.get(firstIndex).equals(theGame.get(secondIndex))) {

                    System.out.printf("Congrats! You have found matching elements - %s!%n", theGame.get(firstIndex));
                    String elementOne = theGame.get(firstIndex);
                    String elementTwo = theGame.get(secondIndex);
                    theGame.remove(elementOne);
                    theGame.remove(elementTwo);

                } else {
                    System.out.println("Try again!");
                }

            }
            if (theGame.isEmpty()) {
                System.out.printf("You have won in %d turns!%n", moves);
                break;
            }

            input = scanner.nextLine();
        }
        if (theGame.size() > 0) {
            System.out.printf("Sorry you lose :(%n");
            for (String element : theGame) {
                System.out.print(element + " ");
            }
        }


    }
}
