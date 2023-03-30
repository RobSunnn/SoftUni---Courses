package fundamentals.P18.ObjectsAndClasses;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01RandomizeWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> text = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        while (!text.isEmpty()) {
            Random rnd = new Random();
            int n = rnd.nextInt(text.size());

            System.out.println(text.get(n));
            text.remove(n);

        }
    }
}
