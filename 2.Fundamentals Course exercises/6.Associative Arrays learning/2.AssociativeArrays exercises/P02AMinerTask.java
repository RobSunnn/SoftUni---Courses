package fundamentals.P14.AssociativeArrays.exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P02AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        Map<String, Long> map = new LinkedHashMap<>();

        while (!command.equals("stop")) {
            String resource = command;
            long quantity = Long.parseLong(scanner.nextLine());

            if (!map.containsKey(resource)) {
                map.put(resource, 0L);
            }

            map.put(resource, map.get(resource) + quantity);

            command = scanner.nextLine();
        }
        for (Map.Entry<String, Long> entry : map.entrySet()) {
            System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
        }

    }
}
