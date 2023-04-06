package fundamentals.exams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ManOWar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> pirateShip = Arrays.stream(scanner.nextLine().split(">")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> warShip = Arrays.stream(scanner.nextLine().split(">")).map(Integer::parseInt).collect(Collectors.toList());
        int maxHealth = Integer.parseInt(scanner.nextLine());

        String input = scanner.nextLine();
        while (!input.equals("Retire")) {
            String command = input.split(" ")[0];

            if (command.equals("Fire")) {
                int index = Integer.parseInt(input.split(" ")[1]);
                int damage = Integer.parseInt(input.split(" ")[2]);
                if (isIndexValid(index, warShip)) {
                    int currentHealth = warShip.get(index);
                    warShip.set(index, currentHealth - damage);
                    if (warShip.get(index) <= 0) {
                        System.out.println("You won! The enemy ship has sunken.");
                        return;
                    }
                }
            } else if (command.equals("Defend")) {
                int startIndex = Integer.parseInt(input.split(" ")[1]);
                int endIndex = Integer.parseInt(input.split(" ")[2]);
                int damage = Integer.parseInt(input.split(" ")[3]);
                if (isIndexValid(startIndex, pirateShip) && isIndexValid(endIndex, pirateShip)) {
                    for (int i = startIndex; i <= endIndex; i++) {
                        int currentHealth = pirateShip.get(i);
                        pirateShip.set(i, currentHealth - damage);
                        if (pirateShip.get(i) <= 0) {
                            System.out.println("You lost! The pirate ship has sunken.");
                            return;
                        }
                    }
                }

            } else if (command.equals("Repair")) {
                int index = Integer.parseInt(input.split(" ")[1]);
                int health = Integer.parseInt(input.split(" ")[2]);
                if (isIndexValid(index, pirateShip)) {
                    int currentHealth = pirateShip.get(index);
                    if (currentHealth + health <= maxHealth) {
                        pirateShip.set(index, currentHealth + health);
                    } else {
                        pirateShip.set(index, maxHealth);
                    }
                }
            } else if (command.equals("Status")) {
                double percent = maxHealth - maxHealth * 0.8;
                byte counter = 0;
                for (int i = 0; i < pirateShip.size(); i++) {
                    if (pirateShip.get(i) < percent) {
                        counter++;
                    }
                }
                if (counter > 0) {
                    System.out.printf("%d sections need repair.%n", counter);
                } else {
                    input = scanner.nextLine();
                    continue;
                }

            }
            input = scanner.nextLine();
        }
        int sumPirateShip = 0;
        for (int i = 0; i < pirateShip.size(); i++) {
            sumPirateShip += pirateShip.get(i);
        }
        int sumWarShip = 0;
        for (int i = 0; i < warShip.size(); i++) {
            sumWarShip += warShip.get(i);
        }

        System.out.printf("Pirate ship status: %d%n", sumPirateShip);
        System.out.printf("Warship status: %d%n", sumWarShip);

    }

    private static boolean isIndexValid(int num, List<Integer> list) {
        return num >= 0 && num <= list.size() - 1;
    }
}
