package fundamentals.exams;

import java.util.*;

public class Shopping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, List<String>> products = new LinkedHashMap<>();
        List<String> importantItems = new ArrayList<>();

        while (!input.equals("Go Shopping")) {
            String[] data = input.split("->");
            String command = data[0];
            String store = data[1];

            switch (command) {
                case "Add":
                    String[] items = data[2].split(",");
                    if (!products.containsKey(store)) {
                        products.put(store, new ArrayList<>());
                    }
                    for (String item : items) {
                        boolean isItemAddedInStore = false;

                        for (Map.Entry<String, List<String>> entry : products.entrySet()) {
                            if (entry.getValue().contains(item)) {
                                isItemAddedInStore = true;
                                break;
                            }
                        }

                        if (!isItemAddedInStore) {
                            products.get(store).add(item);
                        }

                    }

                    break;
                case "Important":
                    String item = data[2];
                    boolean isItemAddedInStore = false;

                    for (Map.Entry<String, List<String>> entry : products.entrySet()) {
                        if (entry.getValue().contains(item)) {
                            isItemAddedInStore = true;
                            break;
                        }
                    }
                    if (isItemAddedInStore) {
                        break;
                    } else {
                        importantItems.add(item);
                        if (!products.containsKey(store)) {
                            products.put(store, new ArrayList<>());
                            products.get(store).add(item);

                        } else {
                            List<String> list = products.get(store);
                            list.remove(item);
                            list.add(0, item);
                            products.put(store, list);

                        }
                    }

                    break;
                case "Remove":
                    if (products.containsKey(store)) {
                        List<String> list = products.get(store);
                        boolean isThereAnImportantProduct = false;
                        for (int i = 0; i < list.size(); i++) {
                            String itemToCheck = list.get(i);
                            if (importantItems.contains(itemToCheck)) {
                                isThereAnImportantProduct = true;
                                break;
                            }
                        }
                        if (!isThereAnImportantProduct) {
                            products.remove(store);
                        }
                    }

                    break;
            }
            input = scanner.nextLine();
        }

        for (Map.Entry<String, List<String>> entry : products.entrySet()) {
            System.out.printf("%s:%n", entry.getKey());
            for (String s : entry.getValue()) {
                System.out.printf(" - %s%n", s);
            }
        }


    }
}
