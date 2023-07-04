package christmasPastryShop.repositories;


import christmasPastryShop.entities.cocktails.BaseCocktail;
import christmasPastryShop.repositories.interfaces.CocktailRepository;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class CocktailRepositoryImpl<Cocktail> implements CocktailRepository<BaseCocktail> {

    Map<String, BaseCocktail> cocktailTypeMap;

    public CocktailRepositoryImpl() {
        this.cocktailTypeMap = new LinkedHashMap<>();
    }

    @Override
    public BaseCocktail getByName(String name) {
        return this.cocktailTypeMap.get(name);
    }

    @Override
    public Collection<BaseCocktail> getAll() {
        return this.cocktailTypeMap.values();
    }

    @Override
    public void add(BaseCocktail baseCocktail) {
        this.cocktailTypeMap.put(baseCocktail.getName(), baseCocktail);
    }
}
