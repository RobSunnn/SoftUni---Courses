package handball.entities.team;

import handball.common.ExceptionMessages;

public abstract class BaseTeam implements Team {

    private String name;

    private String country;

    private int advantage;

    protected BaseTeam(String name, String country, int advantage) {
        this.setName(name);
        this.setCountry(country);
        this.setAdvantage(advantage);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.TEAM_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public int getAdvantage() {
        return this.advantage;
    }

    public void setAdvantage(int advantage) {
        if (advantage <= 0) {
            throw new IllegalArgumentException(ExceptionMessages.TEAM_ADVANTAGE_BELOW_OR_EQUAL_ZERO);
        }
        this.advantage = advantage;
    }

    public void setCountry(String country) {
        if (country == null || country.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.TEAM_COUNTRY_NULL_OR_EMPTY);
        }
        this.country = country;
    }

    @Override
    public abstract void play();

}
