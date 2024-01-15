import java.util.*;
import java.util.stream.Collectors;


public class P12DragonArmy {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countCommands = Integer.parseInt(scanner.nextLine());
        Map<String, List<Dragon>> dragonsMap = new LinkedHashMap<>();

        for (int i = 0; i < countCommands; i++) {

            String[] inputLine = scanner.nextLine().split(" ");
            String dragonType = inputLine[0];
            String dragonName = inputLine[1];



            Integer damage = null;
            if (!inputLine[2].equals("null")) {
                damage = Integer.parseInt(inputLine[2]);
            }

            Integer health = null;
            if (!inputLine[3].equals("null")) {
                health = Integer.parseInt(inputLine[3]);
            }

            Integer armor = null;
            if (!inputLine[4].equals("null")) {
                armor = Integer.parseInt(inputLine[4]);
            }

            Dragon dragon = new Dragon(dragonName, damage, health, armor);

            if (!dragonsMap.containsKey(dragonType)) {
                dragonsMap.put(dragonType, new ArrayList<>());
                dragonsMap.get(dragonType).add(dragon);
            } else {
                Dragon checkingDragon = null;
                for (Dragon d : dragonsMap.get(dragonType)) {
                    if (d.getName().equals(dragonName)) {
                        checkingDragon = d;
                    }
                }
                if (checkingDragon == null) {
                    dragonsMap.get(dragonType).add(dragon);
                } else {
                    Integer finalHealth = health;
                    Integer finalDamage = damage;
                    Integer finalArmor = armor;
                    dragonsMap.get(dragonType).forEach(dragon1 -> {
                        for (int j = 0; j < dragonsMap.get(dragonType).size(); j++) {
                            if (dragonsMap.get(dragonType).get(j).getName().equals(dragonName)) {
                                dragonsMap.get(dragonType).get(j).setHealth(finalHealth);
                                dragonsMap.get(dragonType).get(j).setDamage(finalDamage);
                                dragonsMap.get(dragonType).get(j).setArmor(finalArmor);
                            }
                        }
                    });

                }

            }
        }

        List<Dragon> sortedDragons = new ArrayList<>();
        Map<String, List<Dragon>> sortedMapWithDragons = new LinkedHashMap<>();

        for (Map.Entry<String, List<Dragon>> e : dragonsMap.entrySet()) {

            sortedDragons = e.getValue().stream()
                    .sorted(Comparator.comparing(Dragon::getName)).collect(Collectors.toList());

            sortedMapWithDragons.putIfAbsent(e.getKey(), sortedDragons);
        }


        for (Map.Entry<String, List<Dragon>> e : sortedMapWithDragons.entrySet()) {

            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", e.getKey(), e.getValue().stream().mapToDouble(Dragon::getDamage).average().getAsDouble(),
                    e.getValue().stream().mapToDouble(Dragon::getHealth).average().getAsDouble(),
                    e.getValue().stream().mapToDouble(Dragon::getArmor).average().getAsDouble());

            e.getValue().forEach(dragon -> System.out.println(dragon.toString()));

        }

    }


}

class Dragon {
    private String name;
    private Integer damage;
    private Integer health;
    private Integer armor;

    public Dragon(String name, Integer damage, Integer health, Integer armor) {
        this.name = name;
        setDamage(damage);
        setHealth(health);
        setArmor(armor);
    }

    public String getName() {
        return this.name;
    }

    public Integer getDamage() {
        return damage;
    }

    public Integer getHealth() {
        return health;
    }

    public Integer getArmor() {
        return armor;
    }

    public void setDamage(Integer damage) {
        if (damage == null) {
            damage = 45;
        }
        this.damage = damage;
    }

    public void setHealth(Integer health) {
        if (health == null) {
            health = 250;
        }
        this.health = health;
    }

    public void setArmor(Integer armor) {
        if (armor == null) {
            armor = 10;
        }
        this.armor = armor;
    }

    @Override
    public String toString() {
        String FORMAT = "-%s -> damage: %d, health: %d, armor: %d";
        return String.format(FORMAT, this.name, this.damage, this.health, this.armor);
    }
}