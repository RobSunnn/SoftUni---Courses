package fundamentals.P14.AssociativeArrays.exercise;


import java.util.*;


public class Exercise {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Integer> results = new LinkedHashMap<>();
        Map<String, Integer> submissions = new LinkedHashMap<>();

        while (!input.equals("exam finished")) {
            String[] info = input.split("-");
            String student = info[0];
            
            if (input.endsWith("banned")) {
                results.remove(student);
                input = scanner.nextLine();
                continue;
            }

            String language = info[1];
            int grade = Integer.parseInt(info[2]);

            if (!results.containsKey(student)) {
                results.put(student, grade);
            } else {
                int currentResult = results.get(student);

                if (currentResult < grade) {
                    results.put(student, grade);
                }
            }

            if (!submissions.containsKey(language)) {
                submissions.put(language, 0);

            }
            submissions.put(language, submissions.get(language) + 1);



            input = scanner.nextLine();
        }

        System.out.println("Results:");
        for (Map.Entry<String, Integer> entry : results.entrySet()) {
            System.out.printf("%s | %d%n", entry.getKey(), entry.getValue());
        }

        System.out.println("Submissions:");
        for (Map.Entry<String, Integer> entry : submissions.entrySet()) {
            System.out.printf("%s - %d%n", entry.getKey(), entry.getValue());
        }


    }
}
