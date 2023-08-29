package fundamentals.exams;

import java.util.*;
import java.util.stream.Collectors;

public class ThePianist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<String>> mapSongs = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] inputLine = scanner.nextLine().split("\\|");
            String piece = inputLine[0];
            String composer = inputLine[1];
            String key = inputLine[2];

            mapSongs.put(piece, new ArrayList<>());
            mapSongs.get(piece).add(0, composer);
            mapSongs.get(piece).add(1, key);
        }
        String input = scanner.nextLine();

        while (!input.equals("Stop")) {
            String command = input.split("\\|")[0];
            String piece = input.split("\\|")[1];

            if (command.equals("Add")) {
                String composer = input.split("\\|")[2];
                String key = input.split("\\|")[3];

                if (mapSongs.containsKey(piece)) {
                    System.out.printf("%s is already in the collection!%n", piece);
                } else {
                    mapSongs.put(piece, new ArrayList<>());
                    mapSongs.get(piece).add(0, composer);
                    mapSongs.get(piece).add(1, key);
                    System.out.printf("%s by %s in %s added to the collection!%n", piece, composer, key);
                }

            } else if (command.equals("Remove")) {
                if (mapSongs.containsKey(piece)) {
                    mapSongs.remove(piece);
                    System.out.printf("Successfully removed %s!%n", piece);
                } else {
                    System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                }
            } else if (command.equals("ChangeKey")) {
                String newKey = input.split("\\|")[2];
                if (mapSongs.containsKey(piece)) {
                    mapSongs.get(piece).set(1, newKey);
                    System.out.printf("Changed the key of %s to %s!%n", piece, newKey);
                } else {
                    System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                }

            }


            input = scanner.nextLine();
        }

        for (Map.Entry<String, List<String>> entry : mapSongs.entrySet()) {
            System.out.printf("%s -> Composer: %s, Key: %s%n", entry.getKey(), entry.getValue().get(0), entry.getValue().get(1));
        }

    }
}
