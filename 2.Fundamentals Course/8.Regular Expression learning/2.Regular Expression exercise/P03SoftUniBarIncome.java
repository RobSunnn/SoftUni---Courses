package fundamentals.P17.RegularExpression.Exercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P03SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String regex = "%(?<name>[A-Z][a-z]+)%[^|$%.]*?" +
                "<(?<product>\\w+)>[^|$%.]*?" +
                "\\|(?<count>[0-9]+)\\|[^|$%.]*?(?<price>[0-9]+[.]?[0-9]+)\\$";
        Pattern pattern = Pattern.compile(regex);

        double totalIncome = 0.0;

        while (!input.equals("end of shift")) {

            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {

                String user = matcher.group("name");
                String product = matcher.group("product");
                int quantity = Integer.parseInt(matcher.group("count"));
                double price = Double.parseDouble(matcher.group("price"));

                double totalPrice = quantity * price;
                totalIncome += totalPrice;

                System.out.printf("%s: %s - %.2f%n", user, product, totalPrice);

            }


            input = scanner.nextLine();
        }
        System.out.printf("Total income: %.2f%n", totalIncome);

    }
}
