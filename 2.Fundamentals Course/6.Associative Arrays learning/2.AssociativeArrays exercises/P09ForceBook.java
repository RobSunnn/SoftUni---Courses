package fundamentals.P14.AssociativeArrays.exercise;

import java.util.*;
import java.util.stream.Collectors;

public class P09ForceBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, List<String>> map = new LinkedHashMap<>();

        while (!input.equals("Lumpawaroo")) {

            if (input.contains(" | ")) {

                String forceSide = input.split(" \\| ")[0];
                String forceUser = input.split(" \\| ")[1];

                if (!map.containsKey(forceSide)) {
                    map.put(forceSide, new ArrayList<>());
                    map.get(forceSide).add(forceUser);
                } else {
                    List<String> currentUsers = map.get(forceSide);
                    if (!currentUsers.contains(forceUser)) {
                        currentUsers.add(forceUser);
                        map.put(forceSide, currentUsers);
                    }
                }
            } else if (input.contains("->")) {

                String forceUser = input.split(" -> ")[0];
                String forceSide = input.split(" -> ")[1];
                map.entrySet().forEach(entry -> entry.getValue().remove(forceUser));

                if (map.containsKey(forceSide)) {
                    List<String> currentUsers = map.get(forceSide);
                    currentUsers.add(forceUser);
                    map.put(forceSide, currentUsers);
                } else {
                    map.put(forceSide, new ArrayList<>());
                    map.get(forceSide).add(forceUser);
                }
                System.out.printf("%s joins the %s side!%n", forceUser, forceSide);
            }

            input = scanner.nextLine();
        }

        map.entrySet().stream().filter(e -> e.getValue().size() > 0).forEach(entry -> {
            System.out.printf("Side: %s, Members: %d%n", entry.getKey(), entry.getValue().size());
            for (String element : entry.getValue()) {
                System.out.printf("! %s%n", element);
            }
        });

    }
}
