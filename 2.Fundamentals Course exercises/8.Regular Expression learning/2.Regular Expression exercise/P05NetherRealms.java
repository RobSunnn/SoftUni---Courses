package fundamentals.P17.RegularExpression.Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class P05NetherRealms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split(",");
        List<String> namesToPrint = new ArrayList<>();


        for (int i = 0; i < names.length; i++) {

            int health = 0;
            double damage = 0.0;
            int countMultiply = 0;
            int countDivide = 0;
            String currentName = names[i].replaceAll(" ", "");

            for (int j = 0; j < currentName.length(); j++) {
                if (!Character.isDigit(currentName.charAt(j)) && currentName.charAt(j) != '+'
                        && currentName.charAt(j) != '-' && currentName.charAt(j) != '*' && currentName.charAt(j) != '/' && currentName.charAt(j) != '.') {
                    health += currentName.charAt(j);
                }
            }
            Pattern pattern = Pattern.compile("(?<number>-?[0-9]?[.]?[0-9]+)");
            Matcher matcher = pattern.matcher(currentName);
            while (matcher.find()) {
                double num = Double.parseDouble(matcher.group("number"));
                damage += num;

            }

            for (int j = 0; j < names.length; j++) {
                String currentNameForSymbols = names[j];
                for (int k = 0; k < currentNameForSymbols.length(); k++) {
                    if (currentNameForSymbols.charAt(k) == '*') {
                        countMultiply++;
                    } else if (currentNameForSymbols.charAt(k) == '/') {
                        countDivide++;
                    }
                }

            }

            for (int j = 0; j < countMultiply; j++) {
                damage = damage * 2;
            }

            for (int j = 0; j < countDivide; j++) {
                damage = damage / 2;
            }


            namesToPrint.add(String.format("%s - %s health, %.2f damage", currentName, health, damage));

        }
        for (String element : namesToPrint) {
            System.out.println(element);
        }

    }
}
