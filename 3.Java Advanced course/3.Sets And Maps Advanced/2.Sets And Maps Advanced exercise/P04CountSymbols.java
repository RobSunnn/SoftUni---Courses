package P06SetsAndMapsAdvanced.exercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P04CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<Character, Integer> map = new TreeMap<>();
        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);

            if (!map.containsKey(symbol)) {
                map.put(symbol, 0);
            }
            map.put(symbol, map.get(symbol) + 1);

        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.printf("%c: %d time/s%n", entry.getKey(), entry.getValue());
        }

    }
}
