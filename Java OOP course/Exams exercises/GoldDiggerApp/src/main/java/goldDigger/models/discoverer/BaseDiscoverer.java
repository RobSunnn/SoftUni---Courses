package goldDigger.models.discoverer;

import goldDigger.common.ConstantMessages;
import goldDigger.common.ExceptionMessages;
import goldDigger.models.museum.BaseMuseum;
import goldDigger.models.museum.Museum;

public abstract class BaseDiscoverer implements Discoverer {

    private String name;
    private double energy;
    private Museum museum;

    protected BaseDiscoverer(String name, double energy) {
        this.setName(name);
        this.setEnergy(energy);
        this.museum = new BaseMuseum();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.DISCOVERER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public void setEnergy(double energy) {
        if (energy < 0) {
            throw new IllegalArgumentException(ExceptionMessages.DISCOVERER_ENERGY_LESS_THAN_ZERO);
        }
        this.energy = energy;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getEnergy() {
        return this.energy;
    }

    @Override
    public boolean canDig() {
        return this.energy > 0;
    }

    @Override
    public Museum getMuseum() {
        return this.museum;
    }

    @Override
    public void dig() {
        double newEnergy = this.energy - 15;
        if (newEnergy < 0) {
            this.energy = 0;
        } else {
            this.energy = newEnergy;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(ConstantMessages.FINAL_DISCOVERER_NAME, this.name))
                .append(System.lineSeparator())
                .append(String.format(ConstantMessages.FINAL_DISCOVERER_ENERGY, this.energy))
                .append(System.lineSeparator());
        if (this.museum.getExhibits().isEmpty()) {
            sb.append(String.format(ConstantMessages.FINAL_DISCOVERER_MUSEUM_EXHIBITS, "None"))
                    .append(System.lineSeparator());
        } else {
            sb.append(String.format(ConstantMessages.FINAL_DISCOVERER_MUSEUM_EXHIBITS,
                            String.join(ConstantMessages.FINAL_DISCOVERER_MUSEUM_EXHIBITS_DELIMITER, this.museum.getExhibits())))
                    .append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
