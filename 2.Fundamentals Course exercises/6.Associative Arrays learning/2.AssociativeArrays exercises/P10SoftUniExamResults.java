package fundamentals.P14.AssociativeArrays.exercise;

import java.util.*;

public class P10SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        Map<String, List<String>> map = new LinkedHashMap<>();
        Map<String, Integer> submissions = new LinkedHashMap<>();


        while (!command.equals("exam finished")) {
            String[] inputLine = command.split("-");
            String username = inputLine[0];
            String language = inputLine[1];

            if (command.contains("banned")) {
                map.remove(username);
                break;
            }
            int points = Integer.parseInt(inputLine[2]);
            if (!map.containsKey(username)) {
                map.put(username, new ArrayList<>());
            }
            map.get(username).add(0, language);
            map.get(username).add(1, String.valueOf(points));

            if (!submissions.containsKey(language)) {
                submissions.put(language, 0);
                int currentValueSubmissions = submissions.get(language);
                submissions.put(language, currentValueSubmissions + 1);
            } else {
                int currentValueSubmissions = submissions.get(language);
                submissions.put(language, currentValueSubmissions + 1);
            }
            
            command = scanner.nextLine();

        }

        System.out.printf("Results:%n");
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            System.out.printf("%s | %s%n", entry.getKey(), String.join("", entry.getValue().get(1)));
        }
        System.out.printf("Submissions:%n");
        for (Map.Entry<String, Integer> entry : submissions.entrySet()) {
            System.out.printf("%s - %d%n", entry.getKey(), entry.getValue());
        }


    }
}
