package fundamentals.exams;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> listOfIntegers = Arrays.stream(scanner.nextLine()
                .split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> list = new ArrayList<>();

        int resultFromAll = 0;

        for (int num : listOfIntegers) {
            resultFromAll += num;
        }
        double average = resultFromAll * 1.0 / listOfIntegers.size();

        for (int num : listOfIntegers) {
            if (num > average) {

                list.add(num);

            }
        }
        Collections.sort(list, Collections.reverseOrder());
        list = list.stream().limit(5).collect(Collectors.toList());

        if (list.isEmpty()) {
            System.out.println("No");
        } else {
            for (int num : list) {
                System.out.print(num + " ");
            }
        }
    }


}
