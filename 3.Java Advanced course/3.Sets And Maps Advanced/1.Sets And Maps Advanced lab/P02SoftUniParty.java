package P05SetsAndMapsAdvanced.lab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class P02SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Set<String> vipGuests = new TreeSet<>();
        Set<String> guests = new TreeSet<>();

        while (!input.equals("PARTY")) {
            if (Character.isDigit(input.charAt(0))) {
                vipGuests.add(input);

            } else {

                guests.add(input);
            }

            input = scanner.nextLine();
        }

        String command = scanner.nextLine();

        while (!command.equals("END")) {

            if (Character.isDigit(command.charAt(0))) {
                vipGuests.remove(command);

            } else {

                guests.remove(command);
            }

            command = scanner.nextLine();
        }
        int guestThatDidNotCame = vipGuests.size() + guests.size();

        System.out.println(guestThatDidNotCame);
        for (String guest : vipGuests) {

            System.out.println(guest);
        }
        for (String guest : guests) {

            System.out.println(guest);
        }

    }
}
