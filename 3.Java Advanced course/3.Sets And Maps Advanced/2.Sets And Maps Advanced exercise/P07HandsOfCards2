
import java.util.*;


public class Exercise {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Set<String>> players = new LinkedHashMap<>();

        while (!input.equals("JOKER")) {
            String player = input.split(": ")[0];
            String cards = input.split(": ")[1];
            String[] cardsSeparated = cards.split(", ");

            if (!players.containsKey(player)) {
                players.put(player, new LinkedHashSet<>());
            }

            for (String card : cardsSeparated) {
                players.get(player).add(card);
            }

            input = scanner.nextLine();
        }

        Map<String, Integer> results = new LinkedHashMap<>();

        for (Map.Entry<String, Set<String>> e : players.entrySet()) {
            int power = 0;

            if (!results.containsKey(e.getKey())) {
                results.put(e.getKey(), 0);
            }
            
            for (int i = 0; i < e.getValue().size(); i++) {
                List<String> cardsOfPlayer = List.copyOf(e.getValue());

                char card = cardsOfPlayer.get(i).charAt(0);
                char type = cardsOfPlayer.get(i).charAt(cardsOfPlayer.get(i).length() - 1);

                if (Character.isDigit(card)) {
                    if (card == '1') {
                        if (type == 'S') {
                            power += Integer.parseInt(String.valueOf(card)) * 4 * 10;
                        } else if (type == 'H') {
                            power += Integer.parseInt(String.valueOf(card)) * 3 * 10;
                        } else if (type == 'D') {
                            power += Integer.parseInt(String.valueOf(card)) * 2 * 10;
                        } else if (type == 'C') {
                            power += Integer.parseInt(String.valueOf(card)) * 10;
                        }
                    } else {
                        if (type == 'S') {
                            power += Integer.parseInt(String.valueOf(card)) * 4;
                        } else if (type == 'H') {
                            power += Integer.parseInt(String.valueOf(card)) * 3;
                        } else if (type == 'D') {
                            power += Integer.parseInt(String.valueOf(card)) * 2;
                        } else if (type == 'C') {
                            power += Integer.parseInt(String.valueOf(card));
                        }
                    }

                } else {
                    if (card == 'J') {
                        if (type == 'S') {
                            power += 11 * 4;
                        } else if (type == 'H') {
                            power += 11 * 3;
                        } else if (type == 'D') {
                            power += 11 * 2;
                        } else if (type == 'C') {
                            power += 11;
                        }
                    } else if (card == 'Q') {
                        if (type == 'S') {
                            power += 12 * 4;
                        } else if (type == 'H') {
                            power += 12 * 3;
                        } else if (type == 'D') {
                            power += 12 * 2;
                        } else if (type == 'C') {
                            power += 12;
                        }
                    } else if (card == 'K') {
                        if (type == 'S') {
                            power += 13 * 4;
                        } else if (type == 'H') {
                            power += 13 * 3;
                        } else if (type == 'D') {
                            power += 13 * 2;
                        } else if (type == 'C') {
                            power += 13;
                        }
                    } else if (card == 'A') {
                        if (type == 'S') {
                            power += 14 * 4;
                        } else if (type == 'H') {
                            power += 14 * 3;
                        } else if (type == 'D') {
                            power += 14 * 2;
                        } else if (type == 'C') {
                            power += 14;
                        }
                    }
                }


            }

            results.put(e.getKey(), power);
        }

        for (Map.Entry<String, Integer> entry : results.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
        }


    }
}
