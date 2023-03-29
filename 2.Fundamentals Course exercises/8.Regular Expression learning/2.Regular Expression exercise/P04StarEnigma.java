package fundamentals.P17.RegularExpression.Exercise;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P04StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfMessages = Integer.parseInt(scanner.nextLine());
        String regex = "@(?<planetName>[A-Z][a-z]+)[^@\\-!:>]*:(?<population>[0-9]+)[^@\\-!:>]*!(?<attackType>[A-D])![^@\\-!:>]*->(?<soldiers>[0-9]+)";
        Pattern pattern = Pattern.compile(regex);
        List<String> attackingPlanet = new ArrayList<>();
        List<String> destroyedPlanets = new ArrayList<>();

        for (int messages = 1; messages <= numberOfMessages; messages++) {
            String input = scanner.nextLine();
            String decryptedMessage = decryptedMessage(input);
            Matcher matcher = pattern.matcher(decryptedMessage);

            while (matcher.find()) {

                String planet = matcher.group("planetName");
                String attackType = matcher.group("attackType");
                if (attackType.equals("A")) {
                    attackingPlanet.add(planet);
                } else if (attackType.equals("D")) {
                    destroyedPlanets.add(planet);
                }

            }

        }

        Collections.sort(attackingPlanet);
        Collections.sort(destroyedPlanets);
        System.out.printf("Attacked planets: %d%n", attackingPlanet.size());

        for (String element : attackingPlanet) {
            System.out.printf("-> %s%n", element);
        }
        System.out.printf("Destroyed planets: %d%n", destroyedPlanets.size());
        for (String element : destroyedPlanets) {
            System.out.printf("-> %s%n", element);
        }

    }

    private static String decryptedMessage(String text) {
        int lettersCount = countLetters(text);
        StringBuilder sb = new StringBuilder();
        for (char symbol : text.toCharArray()) {
            symbol = (char) (symbol - lettersCount);
            sb.append(symbol);
        }
        return sb.toString();
    }

    private static int countLetters(String text) {
        int counterForLetters = 0;
        for (char symbol : text.toCharArray()) {
            if (symbol == 's' || symbol == 'S' || symbol == 't' || symbol == 'T' || symbol == 'a' || symbol == 'A' || symbol == 'r' || symbol == 'R') {
                counterForLetters++;
            }
        }
        return counterForLetters;
    }
}
