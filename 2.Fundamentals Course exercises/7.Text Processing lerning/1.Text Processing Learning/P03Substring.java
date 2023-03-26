package fundamentals.P14.TextProcessing.lab;

import java.util.Scanner;

public class P03Substring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String toRemove = scanner.nextLine();
        String words = scanner.nextLine();

        int index = words.indexOf(toRemove);

        while (index != -1) {
            words = words.replace(toRemove, "");
            index = words.indexOf(toRemove);

        }
        System.out.println(words);
    }
}
