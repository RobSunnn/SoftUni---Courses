package P05SetsAndMapsAdvanced.lab;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P08AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countStudents = Integer.parseInt(scanner.nextLine());
        Map<String, Double> map = new TreeMap<>();

        for (int i = 0; i < countStudents; i++) {
            String name = scanner.nextLine();
            double[] grades = Arrays.stream(scanner.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();

            double average = 0.0;

            for (int j = 0; j < grades.length; j++) {

                average += grades[j];
            }
            average /= grades.length;

            map.put(name, average);

        }
        DecimalFormat df = new DecimalFormat("#.#######################################");
        for (Map.Entry<String, Double> entry : map.entrySet()) {

            System.out.printf("%s is graduated with %s%n", entry.getKey(), df.format(entry.getValue()));
        }


    }
}
