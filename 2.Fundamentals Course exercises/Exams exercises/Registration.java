package fundamentals.exams;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Registration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "U\\$(?<username>[A-Z][a-z]{2,})U\\$P@\\$(?<password>[A-Za-z]{5,}[0-9]+)P@\\$";
        List<String> usernames = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            String text = scanner.nextLine();
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(text);

            if (matcher.find()) {
                String username = matcher.group("username");
                String password = matcher.group("password");
                usernames.add(username);
                System.out.println("Registration was successful");
                System.out.printf("Username: %s, Password: %s%n",
                        username, password);
            } else {
                System.out.println("Invalid username or password");
            }

        }

        System.out.println("Successful registrations: " + usernames.size());

    }
}
