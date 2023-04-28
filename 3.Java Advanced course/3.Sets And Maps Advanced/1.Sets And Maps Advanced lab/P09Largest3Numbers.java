package P05SetsAndMapsAdvanced.lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P09Largest3Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> list = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).sorted().collect(Collectors.toList());
        List<Integer> sortedList = new ArrayList<>();
        boolean smallerList = false;

        int count = 0;
        while (count < 3) {

            if (list.size() < 3) {
                smallerList = true;
                for (int i = list.size() - 1; i >= 0; i--) {

                    sortedList.add(list.get(i));
                }
            } else {

                sortedList.add(list.get(list.size() - 1 - count));
                count++;
            }

            if (smallerList) {

                break;
            }
        }


        for (int num : sortedList) {

            System.out.print(num + " ");
        }
    }
}
