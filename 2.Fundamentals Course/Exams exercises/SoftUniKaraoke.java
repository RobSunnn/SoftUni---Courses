package fundamentals.exams;

import java.util.*;
import java.util.stream.Collectors;

public class SoftUniKaraoke {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> peopleList = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        List<String> songList = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        Map<String, List<String>> map = new TreeMap<>();

        String input = scanner.nextLine();

        while (!input.equals("dawn")) {
            String participant = input.split(",")[0];
            String song = input.split(", ")[1];
            String award = input.split(", ")[2];

            if (peopleList.contains(participant)) {

                if (songList.contains(song)) {

                    if (!map.containsKey(participant)) {
                        map.put(participant, new ArrayList<>());
                    }
                    map.get(participant).add(award);

                }
            }

            input = scanner.nextLine();
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            List<String> correctList = new ArrayList<>();

            for (int i = 0; i < entry.getValue().size(); i++) {

                String song = entry.getValue().get(i);
                if (!correctList.contains(song)) {

                    correctList.add(song);
                }
            }
            Collections.sort(correctList);
            map.get(entry.getKey()).subList(0, entry.getValue().size()).clear();
            map.put(entry.getKey(), correctList);
        }

        Map<String, List<String>> newMap = map.entrySet().stream().sorted(Map.Entry.<String, List<String>>comparingByKey().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));


        if (newMap.isEmpty()) {
            System.out.println("No awards");
        } else {

            for (Map.Entry<String, List<String>> entry : newMap.entrySet()) {
                System.out.printf("%s: %d awards%n", entry.getKey(), entry.getValue().size());
                for (String element : entry.getValue()) {
                    System.out.printf("--%s%n", element);
                }
            }
        }


    }
}
