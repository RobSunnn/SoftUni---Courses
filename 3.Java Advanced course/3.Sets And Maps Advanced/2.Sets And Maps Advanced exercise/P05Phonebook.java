package P06SetsAndMapsAdvanced.exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P05Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> phonebook = new HashMap<>();


        String input = scanner.nextLine();
        while (!input.equals("search")) {
            String[] inputLineArr = input.split("-");
            String name = inputLineArr[0];
            String phoneNumber = inputLineArr[1];

            phonebook.put(name, phoneNumber);
            input = scanner.nextLine();
        }

        String name = scanner.nextLine();

        while (!name.equals("stop")) {


            if (phonebook.containsKey(name)) {
                System.out.printf("%s -> %s%n", name, phonebook.get(name));
            } else {
                System.out.printf("Contact %s does not exist.%n", name);
            }
            name = scanner.nextLine();
        }

    }
}
