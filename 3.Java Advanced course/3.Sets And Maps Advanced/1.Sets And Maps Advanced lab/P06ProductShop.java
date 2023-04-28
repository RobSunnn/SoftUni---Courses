package P05SetsAndMapsAdvanced.lab;

import java.util.*;

public class P06ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> storesMap = new TreeMap<>();

        String input = scanner.nextLine();

        while (!input.equals("Revision")) {
            String[] inputLine = input.split(", ");
            String storeName = inputLine[0];
            String product = inputLine[1];
            String price = inputLine[2];

            if (!storesMap.containsKey(storeName)) {
                storesMap.put(storeName, new ArrayList<>());
            }
            storesMap.get(storeName).add(product);
            storesMap.get(storeName).add(price);
            input = scanner.nextLine();
        }

        for (Map.Entry<String, List<String>> entry : storesMap.entrySet()) {

            System.out.printf("%s->%n", entry.getKey());

            for (int i = 0; i <= entry.getValue().size() - 1; i += 2) {
                System.out.printf("Product: %s, Price: %.1f%n"
                        , entry.getValue().get(i), Double.parseDouble(entry.getValue().get(i + 1)));
            }
        }

    }
}
