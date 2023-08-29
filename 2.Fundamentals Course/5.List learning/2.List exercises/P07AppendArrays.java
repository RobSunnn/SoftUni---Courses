package fundamentals.P12.Lists.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P07AppendArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> start = Arrays.stream(scanner.nextLine().split("\\|")).collect(Collectors.toList());
        List<String> finalList = new ArrayList<>();

        for (int i = start.size() - 1; i >= 0; i--) {
            String[] numbs = start.get(i).split("\\s+");
            for (String numb : numbs) {
                if (!numb.equals("")) {
                    finalList.add(numb);
                }
            }

        }

        String print = finalList.toString().trim();
        System.out.println(print.toString().replaceAll("[\\[\\],]", ""));

    }
}
