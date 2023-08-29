package fundamentals.P17.RegularExpression.Exercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P06ExtractEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        String regex = "[\\w]+[-_\\.]?[\\w]+@[\\w]+[-\\._]?[\\w]+[\\.-_]?[\\w]+[\\.-_]?[\\w]+";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }


    }
}
