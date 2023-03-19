package fundamentals.P12.Lists.exercise;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P09PokemonDontGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> start = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int sum = 0;
        while (start.size() > 0) {
            int indexToRemove = Integer.parseInt(scanner.nextLine());


            if (indexToRemove < 0) {

                int removedElement = start.get(0);
                sum += removedElement;
                start.set(0, start.get(start.size() - 1));

                for (int i = 0; i < start.size(); i++) {

                    int currentNumber = start.get(i);

                    if (currentNumber <= removedElement) {
                        currentNumber += removedElement;
                    } else {
                        currentNumber -= removedElement;
                    }

                    start.set(i, currentNumber);

                }

            } else if (indexToRemove > start.size() - 1) {

                int removedElement = start.get(start.size() - 1);
                sum += removedElement;
                start.set(start.size() - 1, start.get(0));

                for (int i = 0; i < start.size(); i++) {
                    int currentNumber = start.get(i);

                    if (currentNumber <= removedElement) {
                        currentNumber += removedElement;
                    } else {
                        currentNumber -= removedElement;
                    }

                    start.set(i, currentNumber);

                }
            } else {

                int currentNumberToRemove = start.get(indexToRemove);
                sum += currentNumberToRemove;
                start.remove(indexToRemove);


                for (int i = 0; i < start.size(); i++) {

                    int currentNumberFromList = start.get(i);

                    if (currentNumberFromList <= currentNumberToRemove) {
                        currentNumberFromList += currentNumberToRemove;
                    } else {
                        currentNumberFromList -= currentNumberToRemove;
                    }

                    start.set(i, currentNumberFromList);
                }

            }

        }
        System.out.println(sum);
    }
}
