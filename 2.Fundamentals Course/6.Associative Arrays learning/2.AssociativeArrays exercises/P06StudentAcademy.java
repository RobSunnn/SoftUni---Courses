package fundamentals.P14.AssociativeArrays.exercise;

import java.util.*;

public class P06StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> map = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String studentName = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());
            if (!map.containsKey(studentName)) {
                map.put(studentName, new ArrayList<>());
            }
            map.get(studentName).add(grade);


        }

        for (Map.Entry<String, List<Double>> entry : map.entrySet()) {
            double average = entry.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble();
            if (average >= 4.50) {
                System.out.printf("%s -> %.2f%n", entry.getKey(), average);
            }
        }


    }
}
