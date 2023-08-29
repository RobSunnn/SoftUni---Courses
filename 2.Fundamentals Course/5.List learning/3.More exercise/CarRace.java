package More.ExerciseList;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CarRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> list = Arrays.stream(scanner.nextLine().split(" ")).map(Double::parseDouble).collect(Collectors.toList());
        int finishLine = list.size() / 2;
        double left = 0.0;
        double right = 0.0;

        for (int i = 0; i < finishLine; i++) {
            left += list.get(i);
            if (list.get(i) == 0) {
                left = left * 0.8;
            }

        }
        for (int i = list.size() - 1; i > finishLine; i--) {
            right += list.get(i);
            if (list.get(i) == 0) {
                right = right * 0.8;
            }
        }
        if (left > right) {
            System.out.printf("The winner is right with total time: %.1f%n", right);
        } else if (right > left) {
            System.out.printf("The winner is left with total time: %.1f%n", left);
        }

    }
}
