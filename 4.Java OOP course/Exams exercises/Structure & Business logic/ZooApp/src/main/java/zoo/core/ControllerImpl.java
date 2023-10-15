package zoo.core;

import zoo.common.ConstantMessages;
import zoo.common.ExceptionMessages;
import zoo.entities.animals.Animal;
import zoo.entities.animals.AquaticAnimal;
import zoo.entities.animals.TerrestrialAnimal;
import zoo.entities.areas.Area;
import zoo.entities.areas.LandArea;
import zoo.entities.areas.WaterArea;
import zoo.entities.foods.Food;
import zoo.entities.foods.Meat;
import zoo.entities.foods.Vegetable;
import zoo.repositories.FoodRepository;
import zoo.repositories.FoodRepositoryImpl;

import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller {

    private FoodRepository foodRepository;
    private Collection<Area> areas;

    public ControllerImpl() {
        this.foodRepository = new FoodRepositoryImpl();
        this.areas = new ArrayList<>();
    }

    @Override
    public String addArea(String areaType, String areaName) {
        Area area;
        if (areaType.equals("WaterArea")) {
            area = new WaterArea(areaName);
        } else if (areaType.equals("LandArea")) {
            area = new LandArea(areaName);
        } else {
            throw new NullPointerException(ExceptionMessages.INVALID_AREA_TYPE);
        }
        this.areas.add(area);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_AREA_TYPE, areaType);
    }

    @Override
    public String buyFood(String foodType) {
        Food food;
        if (foodType.equals("Meat")) {
            food = new Meat();
        } else if (foodType.equals("Vegetable")) {
            food = new Vegetable();
        } else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_FOOD_TYPE);
        }
        foodRepository.add(food);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FOOD_TYPE, foodType);
    }

    @Override
    public String foodForArea(String areaName, String foodType) {
        Food food = this.foodRepository.findByType(foodType);

        if (food == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_FOOD_FOUND, foodType));
        }
        for (Area area : this.areas) {
            if (area.getName().equals(areaName)) {
                area.addFood(food);
                this.foodRepository.remove(food);
                break;
            }
        }

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FOOD_IN_AREA, foodType, areaName);
    }

    @Override
    public String addAnimal(String areaName, String animalType, String animalName, String kind, double price) {
        Animal animal;
        if (animalType.equals("TerrestrialAnimal")) {
            animal = new TerrestrialAnimal(animalName, kind, price);
        } else if (animalType.equals("AquaticAnimal")) {
            animal = new AquaticAnimal(animalName, kind, price);
        } else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_ANIMAL_TYPE);
        }
        Area area = null;
        for (Area a : this.areas) {
            if (a.getName().equals(areaName)) {
                area = a;
                break;
            }
        }
        assert area != null;
        if (!canAnimalLiveInArea(animal, area)) {
            throw new IllegalStateException(ConstantMessages.AREA_NOT_SUITABLE);
        }

        area.addAnimal(animal);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_ANIMAL_IN_AREA, animalType, areaName);
    }

    private boolean canAnimalLiveInArea(Animal animal, Area area) {
        boolean canLive = animal.getClass().getSimpleName().equals("AquaticAnimal") &&
                area.getClass().getSimpleName().equals("WaterArea");
        if (!canLive) {
            canLive = animal.getClass().getSimpleName().equals("TerrestrialAnimal") &&
                    area.getClass().getSimpleName().equals("LandArea");
        }
        return canLive;
    }

    @Override
    public String feedAnimal(String areaName) {
        int countFedAnimals = 0;

        for (Area a : this.areas) {
            if (a.getName().equals(areaName)) {
                a.feed();
                countFedAnimals = a.getAnimals().size();
                break;
            }
        }

        return String.format(ConstantMessages.ANIMALS_FED, countFedAnimals);
    }

    @Override
    public String calculateKg(String areaName) {
        double totalKilograms = 0.0;

        for (Area area : this.areas) {
            if (area.getName().equals(areaName)) {
                totalKilograms = area.getAnimals().stream().mapToDouble(Animal::getKg).sum();
            }
        }

        return String.format(ConstantMessages.KILOGRAMS_AREA, areaName, totalKilograms);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();

        for (Area area : this.areas) {
            sb.append(area.getInfo());
            sb.append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
