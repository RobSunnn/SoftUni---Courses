package MoreExercise.Text.Processing;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P03TreasureFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbs = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String input = scanner.nextLine();

        StringBuilder treasureBuilder = new StringBuilder();


        while (!input.equals("find")) {

            int index = 0;

            for (int i = 0; i < input.length(); i++) {
                char current = input.charAt(i);

                int key = numbs[index];

                current -= key;

                index++;

                treasureBuilder.append(current);

                if (index == numbs.length) {

                    index = 0;
                }

                if (i == input.length() - 1) {

                    String regexTreasure = "&(?<treasure>[A-Za-z]+)&";
                    String regexCoordinates = "<(?<coordinates>[A-Za-z0-9]+)>";

                    Pattern patternTreasure = Pattern.compile(regexTreasure);
                    Pattern patternCoordinates = Pattern.compile(regexCoordinates);

                    Matcher matcherTreasure = patternTreasure.matcher(treasureBuilder.toString());
                    Matcher matcherCoordinates = patternCoordinates.matcher(treasureBuilder.toString());

                    String coordinates = "";

                    if (matcherCoordinates.find()) {
                        coordinates = matcherCoordinates.group("coordinates");
                    }

                    if (matcherTreasure.find()) {

                        String treasure = matcherTreasure.group("treasure");


                        System.out.printf("Found %s at %s%n", treasure, coordinates);
                    }


                }
            }

            treasureBuilder.delete(0, treasureBuilder.length());
            input = scanner.nextLine();

        }
    }
}
