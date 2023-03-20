package fundamentals.P14.AssociativeArrays.exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P01CountCharsInaString {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String word=scanner.nextLine();
        Map<Character,Integer> map=new LinkedHashMap<>();
        char[] symbols=word.toCharArray();

        for (char currentSymbol : symbols) {

            if (currentSymbol == 32) {
                continue;
            }
            if (!map.containsKey(currentSymbol)) {
                map.put(currentSymbol, 0);
            }
            map.put(currentSymbol, map.get(currentSymbol) + 1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.printf("%c -> %d%n",entry.getKey(),entry.getValue());
        }


    }
}
