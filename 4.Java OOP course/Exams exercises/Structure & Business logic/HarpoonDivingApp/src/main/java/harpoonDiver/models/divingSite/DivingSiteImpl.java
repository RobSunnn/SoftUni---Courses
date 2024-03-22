package harpoonDiver.models.divingSite;

import java.util.ArrayList;
import java.util.Collection;

public class DivingSiteImpl implements DivingSite{

    private String name;

    private Collection<String> seaCreatures;

    public DivingSiteImpl(String name) {
        this.setName(name);
        this.seaCreatures = new ArrayList<>();
    }



    @Override
    public Collection<String> getSeaCreatures() {
        return this.seaCreatures;
    }

    @Override
    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
           throw new NullPointerException("Invalid name!");
        }
        this.name = name;
    }
}
