package fundamentals.P12.Lists.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P03HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<String> names = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String command = scanner.nextLine();
            String name = command.split(" ")[0];

            if (command.contains("is going")) {
                if (!names.contains(name)) {
                    names.add(name);

                } else {
                    System.out.printf("%s is already in the list!%n", name);
                }

            } else if (command.contains("is not going")) {
                if (names.contains(name)) {
                    names.remove(name);
                } else {
                    System.out.printf("%s is not in the list!%n", name);
                }
            }

        }
        for (String element : names) {
            System.out.println(element);
        }
    }
}

