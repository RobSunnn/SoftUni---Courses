package fundamentals.P12.Lists.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P06CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstPlayerCard = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondPlayerCard = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        int sum = 0;
        while (firstPlayerCard.size() > 0 && secondPlayerCard.size() > 0) {

            if (firstPlayerCard.get(0) > secondPlayerCard.get(0)) {

                int oldCardFirstPlayer = firstPlayerCard.get(0);
                int oldCardSecondPlayer = secondPlayerCard.get(0);
                firstPlayerCard.remove(firstPlayerCard.get(0));
                secondPlayerCard.remove(secondPlayerCard.get(0));
                firstPlayerCard.add(oldCardFirstPlayer);
                firstPlayerCard.add(oldCardSecondPlayer);

            } else if (secondPlayerCard.get(0) > firstPlayerCard.get(0)) {

                int oldCardFirstPlayer = firstPlayerCard.get(0);
                int oldCardSecondPlayer = secondPlayerCard.get(0);
                firstPlayerCard.remove(firstPlayerCard.get(0));
                secondPlayerCard.remove(secondPlayerCard.get(0));
                secondPlayerCard.add(oldCardSecondPlayer);
                secondPlayerCard.add(oldCardFirstPlayer);

            } else if (firstPlayerCard.get(0).equals(secondPlayerCard.get(0))) {

                firstPlayerCard.remove(firstPlayerCard.get(0));
                secondPlayerCard.remove(secondPlayerCard.get(0));

            }

        }
        for (Integer integer : firstPlayerCard) {
            sum += integer;

        }
        for (Integer integer : secondPlayerCard) {
            sum += integer;
        }

        if (firstPlayerCard.size() > secondPlayerCard.size()) {
            System.out.printf("First player wins! Sum: %d", sum);
        } else {
            System.out.printf("Second player wins! Sum: %d", sum);
        }

    }
}
