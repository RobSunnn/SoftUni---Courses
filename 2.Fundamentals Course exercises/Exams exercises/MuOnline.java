package fundamentals.exams;

import java.util.Scanner;

public class MuOnline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int initialHealth = 100;
        int currentHealth = 100;
        int bitcoins = 0;
        int roomsCount = 1;
        boolean isDead = false;

        String[] input = scanner.nextLine().split("\\|");

        for (int i = 0; i < input.length; i++) {
            String[] commandInput = input[i].split(" ");
            String command = commandInput[0];
            int number = Integer.parseInt(commandInput[1]);
            if (command.equals("potion")) {
                if (currentHealth < 100) {

                    currentHealth += number;
                    if (currentHealth >= 100) {
                        number = 100 - currentHealth + number;
                        currentHealth = 100;

                    }
                    System.out.printf("You healed for %d hp.%n", number);
                    System.out.printf("Current health: %d hp.%n", currentHealth);

                } else {
                    currentHealth = 100;
                }
            } else if (command.equals("chest")) {
                System.out.printf("You found %d bitcoins.%n", number);
                bitcoins += number;
            } else {
                currentHealth -= number;
                if (currentHealth > 0) {
                    System.out.printf("You slayed %s.%n", command);
                } else {
                    System.out.printf("You died! Killed by %s.%n", command);
                    isDead = true;
                    break;
                }

            }
            roomsCount++;

        }
        if (!isDead) {
            System.out.println("You've made it!");
            System.out.printf("Bitcoins: %s%n", bitcoins);
            System.out.printf("Health: %d", currentHealth);
        } else {
            System.out.printf("Best room: %d", roomsCount);
        }
    }
}
