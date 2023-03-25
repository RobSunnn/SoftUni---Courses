package fundamentals.P14.AssociativeArrays.exercise;

import java.util.*;

public class P05Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<String>> map = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("end")) {

            String[] command = input.split(" : ");
            String courseName = command[0];
            String studentName = command[1];

            if (!map.containsKey(courseName)) {
                map.put(courseName, new ArrayList<>());
            }
            map.get(courseName).add(studentName);
            input = scanner.nextLine();
        }

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            int countStudents = entry.getValue().size();
            System.out.printf("%s: %d%n", entry.getKey(), countStudents);
            for (String element : entry.getValue()) {
                System.out.printf("-- %s%n", element);
            }
        }

    }
}
