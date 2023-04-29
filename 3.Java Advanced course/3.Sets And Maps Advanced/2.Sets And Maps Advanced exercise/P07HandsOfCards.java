package P06SetsAndMapsAdvanced.exercise;

import java.util.*;

public class P07HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Set<String>> map = new LinkedHashMap<>();
        Map<String, Integer> resultMap = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("JOKER")) {
            String[] inputLine = input.split(": ");
            String name = inputLine[0];
            String[] cardsArr = inputLine[1].split(", ");

            if (!map.containsKey(name)) {

                map.put(name, new LinkedHashSet<>());
                resultMap.put(name, 0);

                for (String s : cardsArr) {
                    map.get(name).add(s);
                }

            } else {

                for (String s : cardsArr) {
                    map.get(name).add(s);
                }
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, Set<String>> entry : map.entrySet()) {

            String[] cards = entry.getValue().toString().replaceAll("[\\[\\]]", "").split(", ");

            for (int i = 0; i < cards.length; i++) {
                String currentCard = cards[i];

                if (currentCard.startsWith("2") || currentCard.startsWith("3") || currentCard.startsWith("4")
                        || currentCard.startsWith("5") || currentCard.startsWith("6") || currentCard.startsWith("7")
                        || currentCard.startsWith("8") || currentCard.startsWith("9")) {

                    int num = currentCard.charAt(0) - 48;
                    char symbol = currentCard.charAt(currentCard.length() - 1);

                    if (symbol == 'C') {
                        resultMap.put(entry.getKey(), resultMap.get(entry.getKey()) + num);

                    } else if (symbol == 'D') {
                        num *= 2;
                        resultMap.put(entry.getKey(), resultMap.get(entry.getKey()) + num);
                    } else if (symbol == 'H') {
                        num *= 3;
                        resultMap.put(entry.getKey(), resultMap.get(entry.getKey()) + num);
                    } else if (symbol == 'S') {
                        num *= 4;
                        resultMap.put(entry.getKey(), resultMap.get(entry.getKey()) + num);
                    }

                } else if (currentCard.startsWith("10")) {
                    int num = 10;
                    char symbol = currentCard.charAt(currentCard.length() - 1);

                    if (symbol == 'C') {
                        resultMap.put(entry.getKey(), resultMap.get(entry.getKey()) + num);

                    } else if (symbol == 'D') {
                        num *= 2;
                        resultMap.put(entry.getKey(), resultMap.get(entry.getKey()) + num);
                    } else if (symbol == 'H') {
                        num *= 3;
                        resultMap.put(entry.getKey(), resultMap.get(entry.getKey()) + num);
                    } else if (symbol == 'S') {
                        num *= 4;
                        resultMap.put(entry.getKey(), resultMap.get(entry.getKey()) + num);
                    }

                } else if (currentCard.startsWith("J")) {

                    int num = 11;
                    char symbol = currentCard.charAt(currentCard.length() - 1);

                    if (symbol == 'C') {
                        resultMap.put(entry.getKey(), resultMap.get(entry.getKey()) + num);

                    } else if (symbol == 'D') {
                        num *= 2;
                        resultMap.put(entry.getKey(), resultMap.get(entry.getKey()) + num);
                    } else if (symbol == 'H') {
                        num *= 3;
                        resultMap.put(entry.getKey(), resultMap.get(entry.getKey()) + num);
                    } else if (symbol == 'S') {
                        num *= 4;
                        resultMap.put(entry.getKey(), resultMap.get(entry.getKey()) + num);
                    }
                } else if (currentCard.startsWith("Q")) {

                    int num = 12;
                    char symbol = currentCard.charAt(currentCard.length() - 1);

                    if (symbol == 'C') {
                        resultMap.put(entry.getKey(), resultMap.get(entry.getKey()) + num);

                    } else if (symbol == 'D') {
                        num *= 2;
                        resultMap.put(entry.getKey(), resultMap.get(entry.getKey()) + num);
                    } else if (symbol == 'H') {
                        num *= 3;
                        resultMap.put(entry.getKey(), resultMap.get(entry.getKey()) + num);
                    } else if (symbol == 'S') {
                        num *= 4;
                        resultMap.put(entry.getKey(), resultMap.get(entry.getKey()) + num);
                    }
                } else if (currentCard.startsWith("K")) {

                    int num = 13;
                    char symbol = currentCard.charAt(currentCard.length() - 1);

                    if (symbol == 'C') {
                        resultMap.put(entry.getKey(), resultMap.get(entry.getKey()) + num);

                    } else if (symbol == 'D') {
                        num *= 2;
                        resultMap.put(entry.getKey(), resultMap.get(entry.getKey()) + num);
                    } else if (symbol == 'H') {
                        num *= 3;
                        resultMap.put(entry.getKey(), resultMap.get(entry.getKey()) + num);
                    } else if (symbol == 'S') {
                        num *= 4;
                        resultMap.put(entry.getKey(), resultMap.get(entry.getKey()) + num);
                    }
                } else if (currentCard.startsWith("A")) {
                    int num = 14;
                    char symbol = currentCard.charAt(currentCard.length() - 1);

                    if (symbol == 'C') {
                        resultMap.put(entry.getKey(), resultMap.get(entry.getKey()) + num);

                    } else if (symbol == 'D') {
                        num *= 2;
                        resultMap.put(entry.getKey(), resultMap.get(entry.getKey()) + num);
                    } else if (symbol == 'H') {
                        num *= 3;
                        resultMap.put(entry.getKey(), resultMap.get(entry.getKey()) + num);
                    } else if (symbol == 'S') {
                        num *= 4;
                        resultMap.put(entry.getKey(), resultMap.get(entry.getKey()) + num);
                    }
                }

            }

        }

        for (Map.Entry<String, Integer> entry : resultMap.entrySet()) {

            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
        }

    }
}
