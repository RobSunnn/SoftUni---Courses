package fundamentals.P11.Lists.lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03MergingLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstOne = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondOne = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> resultList = new ArrayList<>();

        int minList = Math.min(firstOne.size(), secondOne.size());

        for (int i = 0; i < minList; i++) {
            int firstNum = firstOne.get(i);
            int secondNum = secondOne.get(i);
            resultList.add(firstNum);
            resultList.add(secondNum);
        }

        if (firstOne.size() > secondOne.size()) {
            resultList.addAll(firstOne.subList(minList, firstOne.size()));
        } else {
            resultList.addAll(secondOne.subList(minList, secondOne.size()));
        }

        System.out.println(resultList.toString().replaceAll("[\\[\\],]", ""));
    }
}
