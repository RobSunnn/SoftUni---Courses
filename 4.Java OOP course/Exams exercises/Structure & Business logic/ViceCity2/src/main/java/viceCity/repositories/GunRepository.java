package viceCity.repositories;

import viceCity.models.guns.Gun;
import viceCity.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class GunRepository implements Repository<Gun> {

    private List<Gun> models;

    public GunRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public List<Gun> getModels() {
        return Collections.unmodifiableList(this.models);
    }

    @Override
    public void add(Gun model) {
        boolean isGunInRepo = false;
        for (Gun gun : this.models) {
            if (gun.getName().equals(model.getName())) {
                isGunInRepo = true;
                break;
            }
        }
        if (!isGunInRepo) {
            this.models.add(model);
        }
    }

    @Override
    public boolean remove(Gun model) {
        return this.models.remove(model);
    }

    @Override
    public Gun find(String name) {
        return this.models.stream()
                .filter(gun -> gun.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
