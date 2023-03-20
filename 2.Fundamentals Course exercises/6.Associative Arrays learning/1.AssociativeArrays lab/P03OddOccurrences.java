package fundamentals.P13.AssociativeArrays.lab;

import java.util.*;

public class P03OddOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(" ");
        LinkedHashMap<String, Integer> count = new LinkedHashMap<>();

        for (String word : words) {
            String wordInLowerCase = word.toLowerCase();
            if (count.containsKey(wordInLowerCase)) {
                count.put(wordInLowerCase, count.get(wordInLowerCase) + 1);

            } else {
                count.put(wordInLowerCase, 1);
            }
        }
        ArrayList<String> odds = new ArrayList<>();

        for (var entry : count.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                odds.add(entry.getKey());
            }
        }
        String list = String.join(", ", odds);
        System.out.println(list);


    }
}
