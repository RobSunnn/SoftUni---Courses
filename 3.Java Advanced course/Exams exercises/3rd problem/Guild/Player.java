package guild;

public class Player {
    private String name;
    private String clazz;
    private String rank = "Trial";
    private String description = "n/a";

    public Player(String name, String clazz) {
        this.name = name;
        this.clazz = clazz;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Player %s: %s", this.name, this.clazz))
                .append(System.lineSeparator());
        stringBuilder.append(String.format("Rank: %s", this.rank)).append(System.lineSeparator());
        stringBuilder.append(String.format("Description: %s", this.description));

        return stringBuilder.toString().trim();
    }
}
