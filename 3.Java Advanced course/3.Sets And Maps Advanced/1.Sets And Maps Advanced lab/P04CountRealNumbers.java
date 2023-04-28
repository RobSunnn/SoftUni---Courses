package P05SetsAndMapsAdvanced.lab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P04CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        Map<Double, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < input.length; i++) {

            double current = Double.parseDouble(input[i]);

            if (!map.containsKey(current)) {

                map.put(current, 1);

            } else {
                int currentValue = map.get(current);
                map.put(current, currentValue + 1);
            }
        }

        for (Map.Entry<Double, Integer> entry : map.entrySet()) {

            System.out.printf("%.1f -> %d%n", entry.getKey(), entry.getValue());
        }

    }
}
