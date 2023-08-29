package fundamentals.exams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class friendListMaintenance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> friendListNames = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        String input = scanner.nextLine();
        int blacklistedCounter = 0;
        int lostCounter = 0;

        while (!input.equals("Report")) {
            String command = input.split(" ")[0];

            switch (command) {
                case "Blacklist":
                    String name = input.split(" ")[1];
                    if (!friendListNames.contains(name)) {
                        System.out.printf("%s was not found.%n", name);
                    } else {
                        System.out.printf("%s was blacklisted.%n", name);
                        friendListNames.set(friendListNames.indexOf(name), "Blacklisted");
                        blacklistedCounter++;
                    }
                    break;
                case "Error":
                    int index = Integer.parseInt(input.split(" ")[1]);
                    if (index >= 0 && index <= friendListNames.size() - 1) {
                        if (!friendListNames.get(index).equals("Blacklisted") && !friendListNames.get(index).equals("Lost")) {
                            System.out.printf("%s wast lost due to an error.%n", friendListNames.get(index));
                            friendListNames.set(index, "Lost");
                            lostCounter++;
                        }
                    }
                    break;
                case "Change":
                    int indexToChange = Integer.parseInt(input.split(" ")[1]);
                    String newName = input.split(" ")[2];
                    if (indexToChange >= 0 && indexToChange <= friendListNames.size() - 1) {
                        System.out.printf("%s changed his username to %s%n", friendListNames.get(indexToChange), newName);
                        friendListNames.set(indexToChange, newName);
                    }
                    break;
            }


            input = scanner.nextLine();
        }
        System.out.printf("Blacklisted names: %d%n", blacklistedCounter);
        System.out.printf("Lost names: %d%n", lostCounter);
        System.out.println(String.join(" ", friendListNames));

    }
}
