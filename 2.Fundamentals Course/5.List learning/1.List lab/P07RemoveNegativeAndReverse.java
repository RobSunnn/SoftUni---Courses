package fundamentals.P11.Lists.lab;

import java.util.*;
import java.util.stream.Collectors;

public class P07RemoveNegativeAndReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> integerList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        integerList.removeIf(n -> n < 0);
        Collections.reverse(integerList);

        if (integerList.isEmpty()) {
            System.out.println("empty");
        } else {
            System.out.print(integerList.toString().replaceAll("[\\[\\],]", ""));
        }
    }
}
