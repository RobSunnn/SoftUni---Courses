package fundamentals.P12.Lists.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> wagons = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        int maxCapacity = Integer.parseInt(scanner.nextLine());

        String command = scanner.nextLine();

        while (!command.equals("end")) {
            String[] commandInput = command.split(" ");

            if (command.contains("Add")) {

                int passengers = Integer.parseInt(commandInput[1]);
                if (passengers <= maxCapacity) {
                    wagons.add(Integer.parseInt(String.valueOf(passengers)));
                }

            } else {

                int passengers = Integer.parseInt(commandInput[0]);
                for (int i = 0; i < wagons.size(); i++) {
                    int currentWagon = wagons.get(i);
                    if (currentWagon + passengers <= maxCapacity) {
                        wagons.set(i, currentWagon + passengers);
                        break;
                    }

                }
            }

            command = scanner.nextLine();
        }
        System.out.println(wagons.toString().replaceAll("[\\[\\],]", ""));
    }
}
