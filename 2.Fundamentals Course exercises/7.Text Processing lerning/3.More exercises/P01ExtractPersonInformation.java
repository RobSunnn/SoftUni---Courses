package MoreExercise.Text.Processing;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P01ExtractPersonInformation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String regexName = "@(?<name>[A-Za-z]+)\\|";
        Pattern patternName = Pattern.compile(regexName);
        String regexAge = "#(?<age>[0-9]+)\\*";
        Pattern patternAge = Pattern.compile(regexAge);

        for (int i = 1; i <= n; i++) {
            String text = scanner.nextLine();
            Matcher matcherName = patternName.matcher(text);
            Matcher matcherAge = patternAge.matcher(text);

            if (matcherName.find()) {
                String name = matcherName.group("name");
                String age = "";
                if (matcherAge.find()) {
                    age = matcherAge.group("age");

                }
                System.out.printf("%s is %s years old.%n", name, age);
            }

        }

    }
}
