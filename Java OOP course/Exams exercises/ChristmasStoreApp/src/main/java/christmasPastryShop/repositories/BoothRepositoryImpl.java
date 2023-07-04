package christmasPastryShop.repositories;

import christmasPastryShop.common.enums.BoothType;
import christmasPastryShop.entities.booths.BaseBooth;
import christmasPastryShop.repositories.interfaces.BoothRepository;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;


public class BoothRepositoryImpl<Booth> implements BoothRepository<BaseBooth> {

    Map<Integer, BaseBooth> boothTypeMap;

    public BoothRepositoryImpl() {
        this.boothTypeMap = new LinkedHashMap<>();
    }

    @Override
    public BaseBooth getByNumber(int number) {
        return this.boothTypeMap.get(number);
    }

    @Override
    public Collection<BaseBooth> getAll() {
        return this.boothTypeMap.values();
    }

    @Override
    public void add(BaseBooth baseBooth) {
        this.boothTypeMap.put(baseBooth.getBoothNumber(), baseBooth);
    }
}
