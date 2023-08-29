package fundamentals.exams;

import java.util.*;

public class HeroesOfCodeAndLogic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfHeroes = Integer.parseInt(scanner.nextLine());
        Map<String, List<Integer>> mapHeroes = new LinkedHashMap<>();

        for (int i = 0; i < numberOfHeroes; i++) {
            String input = scanner.nextLine();
            String heroName = input.split(" ")[0];
            int healthPoints = Integer.parseInt(input.split(" ")[1]);
            int manaPoints = Integer.parseInt(input.split(" ")[2]);

            mapHeroes.put(heroName, new ArrayList<>());
            mapHeroes.get(heroName).add(0, healthPoints);
            mapHeroes.get(heroName).add(1, manaPoints);
        }

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String command = input.split(" - ")[0];
            String heroName = input.split(" - ")[1];

            if (command.equals("CastSpell")) {
                int manaPointsNeeded = Integer.parseInt(input.split(" - ")[2]);
                String spellName = input.split(" - ")[3];

                if (mapHeroes.get(heroName).get(1) >= manaPointsNeeded) {
                    int currentManaPoints = mapHeroes.get(heroName).get(1);
                    int manaPointsLeft = currentManaPoints - manaPointsNeeded;
                    System.out.printf("%s has successfully cast %s and now has %d MP!%n", heroName, spellName, manaPointsLeft);
                    mapHeroes.get(heroName).set(1, manaPointsLeft);
                } else {
                    System.out.printf("%s does not have enough MP to cast %s!%n", heroName, spellName);
                }

            } else if (command.equals("TakeDamage")) {
                int damage = Integer.parseInt(input.split(" - ")[2]);
                String attacker = input.split(" - ")[3];
                int currentHealth = mapHeroes.get(heroName).get(0);
                int healthPointsLeft = currentHealth - damage;
                mapHeroes.get(heroName).set(0, healthPointsLeft);
                if (mapHeroes.get(heroName).get(0) <= 0) {
                    System.out.printf("%s has been killed by %s!%n", heroName, attacker);
                    mapHeroes.remove(heroName);
                } else {
                    System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n", heroName, damage, attacker, healthPointsLeft);
                }

            } else if (command.equals("Recharge")) {
                int amount = Integer.parseInt(input.split(" - ")[2]);
                int currentManaPoints = mapHeroes.get(heroName).get(1);
                if (currentManaPoints + amount > 200) {
                    System.out.printf("%s recharged for %d MP!%n", heroName, 200 - currentManaPoints);
                    mapHeroes.get(heroName).set(1, 200);
                } else {
                    System.out.printf("%s recharged for %d MP!%n", heroName, amount);
                    mapHeroes.get(heroName).set(1, amount + currentManaPoints);
                }
            } else if (command.equals("Heal")) {
                int amount = Integer.parseInt(input.split(" - ")[2]);
                int currentHealthPoints = mapHeroes.get(heroName).get(0);
                if (amount + currentHealthPoints > 100) {
                    System.out.printf("%s healed for %d HP!%n", heroName, 100 - currentHealthPoints);
                    mapHeroes.get(heroName).set(0, 100);
                } else {
                    System.out.printf("%s healed for %d HP!%n", heroName, amount);
                    mapHeroes.get(heroName).set(0, currentHealthPoints + amount);
                }

            }
            input = scanner.nextLine();
        }

        for (Map.Entry<String, List<Integer>> entry : mapHeroes.entrySet()) {
            System.out.printf("%s%n", entry.getKey());
            System.out.printf("  HP: %d%n", entry.getValue().get(0));
            System.out.printf("  MP: %d%n", entry.getValue().get(1));
        }

    }
}
