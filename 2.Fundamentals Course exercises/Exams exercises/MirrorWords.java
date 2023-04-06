package fundamentals.exams;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String regex = "([\\#|\\@])(?<first>[A-Za-z]{3,})\\1\\1(?<sec>[A-Za-z]{3,})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        List<String> pairs = new ArrayList<>();
        int count = 0;

        while (matcher.find()) {
            count++;
            String firstWord = matcher.group("first");
            String secondWord = matcher.group("sec");
            StringBuilder sb = new StringBuilder(secondWord);
            sb.reverse();
            if (firstWord.equals(sb.toString())) {
                pairs.add(String.format("%s <=> %s", firstWord, secondWord));
            }

        }
        if (count == 0) {
            System.out.println("No word pairs found!");
        } else {
            System.out.printf("%d word pairs found!%n", count);
        }
        if (pairs.isEmpty()) {
            System.out.println("No mirror words!");
        } else {
            System.out.println("The mirror words are:");
            System.out.printf("%s", String.join(", ", pairs));
        }

    }
}
