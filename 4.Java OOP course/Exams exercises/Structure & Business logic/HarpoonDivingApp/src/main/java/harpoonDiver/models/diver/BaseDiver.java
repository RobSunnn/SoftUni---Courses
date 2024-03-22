package harpoonDiver.models.diver;

import harpoonDiver.models.seaCatch.BaseSeaCatch;
import harpoonDiver.models.seaCatch.SeaCatch;

import java.util.stream.Collectors;

public abstract class BaseDiver implements Diver{

    private String name;

    private double oxygen;

    private SeaCatch seaCatch;

    protected BaseDiver(String name, double oxygen) {
        this.setName(name);
        this.setOxygen(oxygen);
        this.seaCatch = new BaseSeaCatch();
    }


    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException("Diver name cannot be null or empty.");
        }
        this.name = name;
    }

    @Override
    public double getOxygen() {
        return this.oxygen;
    }

    public void setOxygen(double oxygen) {
        if (oxygen < 0) {
            throw new IllegalArgumentException("Cannot create Diver with negative oxygen.");
        }
        this.oxygen = oxygen;
    }

    @Override
    public boolean canDive() {
        return this.oxygen > 0;
    }

    @Override
    public SeaCatch getSeaCatch() {

        return this.seaCatch;
    }

    @Override
    public void shoot() {
        this.oxygen -= 30;
    }

    @Override
    public String toString() {
        String FORMAT = "Name: %s\nOxygen: %.0f\nDiver's catch: %s";

        if (this.seaCatch.getSeaCreatures().isEmpty()) {
            return String.format(FORMAT, this.name, this.oxygen, "None");
        }


        return String.format(FORMAT, this.name, this.oxygen,
                this.seaCatch.getSeaCreatures().stream().map(String::trim).collect(Collectors.joining(", ")));
    }
}
