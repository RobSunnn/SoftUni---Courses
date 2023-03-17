package fundamentals.P11.Lists.lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P05ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> integerList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("end")) {

            List<String> command = Arrays.stream(input.split(" ")).collect(Collectors.toList());

            if (input.equals("Print even")) {
                for (int currentNum : integerList) {
                    if (currentNum % 2 == 0) {
                        System.out.print(currentNum + " ");

                    }

                }
                System.out.println();
            } else if (input.equals("Print odd")) {
                for (int currentNum : integerList) {
                    if (currentNum % 2 == 1) {
                        System.out.print(currentNum + " ");
                    }
                }
                System.out.println();
            }
            if (input.equals("Get sum")) {
                int sum = 0;
                for (int currentNum : integerList) {
                    sum += currentNum;
                }
                System.out.println(sum);
            }

            switch (command.get(0)) {
                case "Contains":
                    int containedNumber = Integer.parseInt(command.get(1));
                    if (integerList.contains(containedNumber)) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No such number");
                    }
                    break;
                case "Filter":

                    String element = command.get(1);
                    int numberToFilter = Integer.parseInt(command.get(2));

                    if (element.equals(">")) {

                        for (int currentNum : integerList) {
                            if (currentNum > numberToFilter) {
                                System.out.print(currentNum + " ");

                            }
                        }
                        System.out.println();
                    } else if (element.equals("<")) {

                        for (int currentNum : integerList) {
                            if (numberToFilter > currentNum) {
                                System.out.print(currentNum + " ");

                            }
                        }
                        System.out.println();
                    } else if (element.equals(">=")) {

                        for (int currentNum : integerList) {
                            if (currentNum >= numberToFilter) {
                                System.out.print(currentNum + " ");

                            }
                        }
                        System.out.println();
                    } else if (element.equals("<=")) {

                        for (int currentNum : integerList) {
                            if (currentNum <= numberToFilter) {
                                System.out.print(currentNum + " ");
                            }
                        }
                    }
                    break;
            }
            input = scanner.nextLine();
        }
    }
}
