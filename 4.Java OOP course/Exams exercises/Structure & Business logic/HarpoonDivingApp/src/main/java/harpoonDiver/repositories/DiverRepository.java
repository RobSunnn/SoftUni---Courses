package harpoonDiver.repositories;

import harpoonDiver.models.diver.Diver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class DiverRepository implements Repository<Diver> {

    private Collection<Diver> divers;

    public DiverRepository() {
        this.divers = new ArrayList<>();
    }

    @Override
    public Collection<Diver> getCollection() {
        return Collections.unmodifiableCollection(this.divers);
    }

    @Override
    public void add(Diver entity) {
        this.divers.add(entity);
    }

    @Override
    public boolean remove(Diver entity) {
        return this.divers.remove(entity);
    }

    @Override
    public Diver byName(String name) {

        return this.divers
                .stream()
                .filter(diver -> diver.getName().equals(name))
                .findFirst().orElse(null);
    }
}
