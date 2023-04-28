package P05SetsAndMapsAdvanced.lab;

import java.util.*;

public class P05AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countStudents = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> studentsMap = new TreeMap<>();

        for (int i = 0; i < countStudents; i++) {

            String[] studentInfo = scanner.nextLine().split(" ");
            String studentName = studentInfo[0];
            double grade = Double.parseDouble(studentInfo[1]);

            if (!studentsMap.containsKey(studentName)) {
                studentsMap.put(studentName, new ArrayList<>());
                studentsMap.get(studentName).add(grade);

            } else {

                studentsMap.get(studentName).add(grade);
            }

        }


        for (Map.Entry<String, List<Double>> entry : studentsMap.entrySet()) {
            double average = 0.0;
            for (Double grade : entry.getValue()) {
                average += grade;
            }
            average /= entry.getValue().size();

            System.out.printf("%s -> ", entry.getKey());
            for (Double grade : entry.getValue()) {

                System.out.printf("%.2f ", grade);
            }
            System.out.printf("(avg: %.2f)", average);
            System.out.println();
        }


    }
}
