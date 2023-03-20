package fundamentals.P14.AssociativeArrays.exercise;

import java.util.*;

public class P03Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        Map<String, ArrayList<Double>> map = new LinkedHashMap<>();

        while (!command.equals("buy")) {
            String productName = command.split(" ")[0];
            double price = Double.parseDouble(command.split(" ")[1]);
            double quantity = Double.parseDouble(command.split(" ")[2]);

            if (!map.containsKey(productName)) {
                map.put(productName, new ArrayList<>());
                map.get(productName).add(0, price);
                map.get(productName).add(1, quantity);
            } else {
                Double oldQuantity = map.get(productName).get(1);
                map.get(productName).remove(1);
                map.get(productName).add(1, quantity + oldQuantity);
                map.get(productName).remove(0);
                map.get(productName).add(0, price);

            }
            command = scanner.nextLine();
            
        }
        for (Map.Entry<String, ArrayList<Double>> entry : map.entrySet()) {
            double price = entry.getValue().get(0);
            double quantity = entry.getValue().get(1);
            double totalPrice = price * quantity;
            System.out.printf("%s -> %.2f%n", entry.getKey(), totalPrice);
        }


    }
}
