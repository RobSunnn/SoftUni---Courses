package fundamentals.P12.Lists.exercise;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P08AnonymousThreat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> list = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("3:1")) {
            String command = input.split(" ")[0];

            if (command.equals("merge")) {

                int startIndex = Integer.parseInt(input.split(" ")[1]);
                int endIndex = Integer.parseInt(input.split(" ")[2]);

                if (startIndex < 0) {
                    startIndex = 0;
                }

                if (endIndex > list.size() - 1) {
                    endIndex = list.size() - 1;
                }

                boolean isValidIndex = startIndex <= list.size() - 1 && endIndex >= 0 && startIndex < endIndex;

                if (isValidIndex) {

                    String resultMerge = "";

                    for (int i = startIndex; i <= endIndex; i++) {
                        String currentText = list.get(i);
                        resultMerge += currentText;
                    }

                    list.subList(startIndex, endIndex + 1).clear();
                    list.add(startIndex, resultMerge);

                }

            } else if (command.equals("divide")) {

                int index = Integer.parseInt(input.split(" ")[1]);
                int partitions = Integer.parseInt(input.split(" ")[2]);

                String elementToDivide = list.get(index);
                list.remove(index);
                int partSize = elementToDivide.length() / partitions;
                int beginIndex = 0;

                for (int i = 1; i < partitions; i++) {
                    list.add(index, elementToDivide.substring(beginIndex, beginIndex + partSize));
                    index++;
                    beginIndex += partSize;
                }

                list.add(index, elementToDivide.substring(beginIndex));
            }

            input = scanner.nextLine();
        }
        System.out.println(String.join(" ", list).replaceAll("[\\[\\],]", ""));
    }
}

