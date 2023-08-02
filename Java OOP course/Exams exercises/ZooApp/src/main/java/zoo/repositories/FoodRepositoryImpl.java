package zoo.repositories;

import zoo.entities.foods.Food;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class FoodRepositoryImpl implements FoodRepository {

    private Map<String, Food> foods;

    public FoodRepositoryImpl() {
        this.foods = new LinkedHashMap<>();
    }

    @Override
    public void add(Food food) {
        this.foods.put(food.getClass().getSimpleName(), food);
    }

    @Override
    public boolean remove(Food food) {
        return this.foods.values().remove(food);
    }

    @Override
    public Food findByType(String type) {
        return this.foods.get(type);
    }
}
