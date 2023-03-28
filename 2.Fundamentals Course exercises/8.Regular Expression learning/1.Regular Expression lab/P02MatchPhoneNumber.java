package fundamentals.P16.RegularExpression.lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02MatchPhoneNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String phoneNumbers = scanner.nextLine();
        Pattern pattern = Pattern.compile("\\+359([- ])2\\1\\w{3}\\1\\w{4}\\b");
        Matcher matcher = pattern.matcher(phoneNumbers);
        List<String> list = new ArrayList<>();

        while (matcher.find()) {
            String phoneNumber = matcher.group();
            list.add(phoneNumber);
        }
        System.out.println(String.join(", ", list));
    }
}
