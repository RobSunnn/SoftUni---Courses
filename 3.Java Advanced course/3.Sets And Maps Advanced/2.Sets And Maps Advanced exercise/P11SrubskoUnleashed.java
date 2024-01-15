import java.util.*;
import java.util.stream.Collectors;


public class P10SrubskoUnleashed {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Map<String, Long>> singersMap = new LinkedHashMap<>();

        while (!input.equals("End")) {

            if (!isValidFormat(input)) {
                input = scanner.nextLine();
                continue;
            }
            String singerName = input.split("@")[0].trim();


            int ticketPrice = 0;

            String[] ticketCountString = input.split(" ");
            int ticketCount = Integer.parseInt(ticketCountString[ticketCountString.length - 1]);

            String searchForVenue = input.split("@")[1];
            StringBuilder venueToAdd = new StringBuilder();

            for (int i = 0; i < searchForVenue.length(); i++) {

                if (Character.isDigit(searchForVenue.charAt(i))) {

                    StringBuilder getTicketPrice = new StringBuilder();

                    for (int j = 0; j < 10; j++) {
                        getTicketPrice.append(searchForVenue.charAt(i));
                        i++;
                        if (searchForVenue.charAt(i) == 32) {
                            break;
                        }
                    }


                    ticketPrice = Integer.parseInt(getTicketPrice.toString());
                    break;
                }
                venueToAdd.append(searchForVenue.charAt(i));
            }
            long totalProfit = (long) ticketCount * ticketPrice;

            if (!singersMap.containsKey(venueToAdd.toString())) {
                singersMap.put(venueToAdd.toString(), new LinkedHashMap<>());
            }
            if (!singersMap.get(venueToAdd.toString()).containsKey(singerName)) {
                singersMap.get(venueToAdd.toString()).put(singerName, 0L);
            }

            singersMap.get(venueToAdd.toString()).put(singerName, singersMap.get(venueToAdd.toString()).get(singerName) + totalProfit);
            input = scanner.nextLine();
        }


        Map<String, Map<String, Long>> sortedMap = new LinkedHashMap<>();

        for (Map.Entry<String, Map<String, Long>> e : singersMap.entrySet()) {
            sortedMap.putIfAbsent(e.getKey(), new LinkedHashMap<>());

            Map<String, Long> sortTheMapInside = e.getValue().entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

            sortedMap.put(e.getKey(), sortTheMapInside);

        }

        for (Map.Entry<String, Map<String, Long>> e : sortedMap.entrySet()) {
            System.out.println(e.getKey().trim());

            for (Map.Entry<String, Long> entry : e.getValue().entrySet()) {
                System.out.printf("#  %s -> %d%n", entry.getKey().trim(), entry.getValue());
            }

        }


    }

    private static boolean isValidFormat(String line) {
        return line.matches("[A-Za-z]+ ?[A-Za-z]+? ?[A-Za-z]+? @[A-Za-z]+ ?[A-Za-z]+? ?[A-Za-z]+? [0-9]+ [0-9]+");
    }


}

