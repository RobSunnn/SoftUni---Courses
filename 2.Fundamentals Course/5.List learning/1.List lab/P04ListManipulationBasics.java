package fundamentals.P11.Lists.lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P04ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> listOfIntegers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] command = input.split(" ");

            switch (command[0]) {

                case "Add":
                    int numberToAdd = Integer.parseInt(command[1]);
                    listOfIntegers.add(numberToAdd);
                    break;
                case "Remove":
                    int numberToRemove = Integer.parseInt(command[1]);
                    listOfIntegers.remove(Integer.valueOf(numberToRemove));
                    break;
                case "RemoveAt":
                    int indexToRemove = Integer.parseInt(command[1]);
                    listOfIntegers.remove(indexToRemove);
                    break;
                case "Insert":
                    int digitToInsert = Integer.parseInt(command[1]);
                    int indexToInsert = Integer.parseInt(command[2]);
                    listOfIntegers.add(indexToInsert, digitToInsert);
                    break;

            }


            input = scanner.nextLine();
        }
        System.out.println(listOfIntegers.toString().replaceAll("[\\[\\],]", ""));
    }
}
