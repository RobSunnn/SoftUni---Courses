package P05SetsAndMapsAdvanced.lab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P03Voina {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstInput = scanner.nextLine().split(" ");
        String[] secondInput = scanner.nextLine().split(" ");

        Set<Integer> firstPlayer = new LinkedHashSet<>();
        Set<Integer> secondPlayer = new LinkedHashSet<>();

        for (int i = 0; i < firstInput.length; i++) {

            firstPlayer.add(Integer.parseInt(firstInput[i]));
        }

        for (int i = 0; i < secondInput.length; i++) {

            secondPlayer.add(Integer.parseInt(secondInput[i]));
        }

        for (int i = 0; i < 50; i++) {
            if (firstPlayer.isEmpty()) {
                break;
            }
            if (secondPlayer.isEmpty()) {
                break;
            }

            int firstCard = returnsFirstCardOfDeck(firstPlayer);
            firstPlayer.remove(firstCard);

            int secondCard = returnsFirstCardOfDeck(secondPlayer);
            secondPlayer.remove(secondCard);

            if (firstCard > secondCard) {
                firstPlayer.add(firstCard);
                firstPlayer.add(secondCard);

            } else if (secondCard > firstCard) {

                secondPlayer.add(firstCard);
                secondPlayer.add(secondCard);
            }
        }

        if (firstPlayer.size() > secondPlayer.size()) {

            System.out.println("First player win!");
        } else if (secondPlayer.size() > firstPlayer.size()) {

            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }


    }

    private static int returnsFirstCardOfDeck(Set<Integer> set) {
        int num = 0;
        for (int number : set) {
            num = number;
            return num;
        }
        return num;
    }
}
