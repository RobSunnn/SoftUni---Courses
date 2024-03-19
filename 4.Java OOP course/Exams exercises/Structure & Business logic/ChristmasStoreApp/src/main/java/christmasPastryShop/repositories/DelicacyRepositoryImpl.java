package christmasPastryShop.repositories;

import christmasPastryShop.entities.delicacies.BaseDelicacy;
import christmasPastryShop.repositories.interfaces.DelicacyRepository;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class DelicacyRepositoryImpl<Delicacy> implements DelicacyRepository<BaseDelicacy> {

    private Map<String, BaseDelicacy> delicacyMap;

    public DelicacyRepositoryImpl() {
        this.delicacyMap = new LinkedHashMap<>();
    }

    @Override
    public BaseDelicacy getByName(String name) {
        return this.delicacyMap.get(name);
    }

    @Override
    public Collection<BaseDelicacy> getAll() {
        return this.delicacyMap.values();
    }

    @Override
    public void add(BaseDelicacy baseDelicacy) {
        this.delicacyMap.put(baseDelicacy.getName(), baseDelicacy);
    }
}
