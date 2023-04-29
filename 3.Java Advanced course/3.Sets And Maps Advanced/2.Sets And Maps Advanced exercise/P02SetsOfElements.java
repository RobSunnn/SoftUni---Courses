package P06SetsAndMapsAdvanced.exercise;

import java.util.*;

public class P02SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        Set<Integer> first = new LinkedHashSet<>();
        Set<Integer> second = new LinkedHashSet<>();
        Set<Integer> result = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            first.add(num);

        }
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            second.add(num);
        }
        for (int num : first) {

            if (second.contains(num)) {
                result.add(num);
            }
        }

        for (int num : result) {
            System.out.print(num + " ");
        }
    }

}
