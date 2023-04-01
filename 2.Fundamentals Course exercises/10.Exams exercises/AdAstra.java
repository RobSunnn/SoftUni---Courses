package fundamentals.exams;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class AdAstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        Pattern pattern = Pattern.compile("(#|\\|)(?<itemName>[A-Za-z ]+)\\1(?<expDate>[0-9]{2}\\/[0-9]{2}\\/[0-9]{2})\\1(?<cal>[0-9]{1,5})\\1");
        Matcher matcher = pattern.matcher(text);
        int totalCalories = 0;
        List<String> listOfProducts = new ArrayList<>();

        while (matcher.find()) {
            String product = matcher.group("itemName");
            String expirationDate = matcher.group("expDate");
            int calories = Integer.parseInt(matcher.group("cal"));
            totalCalories += calories;

            listOfProducts.add(String.format("Item: %s, Best before: %s, Nutrition: %s", product, expirationDate, calories));


        }
        System.out.printf("You have food to last you for: %d days!%n", totalCalories / 2000);
        for (String element : listOfProducts) {
            System.out.println(element);
        }

    }


}
