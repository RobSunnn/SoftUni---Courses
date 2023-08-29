package fundamentals.P14.AssociativeArrays.exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P04SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, String> map = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] commandInput = scanner.nextLine().split(" ");
            String command = commandInput[0];
            String username = commandInput[1];


            if (command.equals("register")) {

                String plateNumber = commandInput[2];
                boolean isThere = false;
                if (map.containsKey(username)) {
                    isThere = true;
                    System.out.printf("ERROR: already registered with plate number %s%n", plateNumber);
                }
                if (!isThere) {
                    map.put(username, plateNumber);
                    System.out.printf("%s registered %s successfully%n", username, plateNumber);
                }

            } else if (command.equals("unregister")) {

                boolean isNotThere = true;
                if (!map.containsKey(username)) {
                    System.out.printf("ERROR: user %s not found%n", username);
                    isNotThere = false;
                }
                if (isNotThere) {
                    map.remove(username);
                    System.out.printf("%s unregistered successfully%n", username);
                }

            }
        }

        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.printf("%s => %s%n", entry.getKey(), entry.getValue());
        }

    }
}
