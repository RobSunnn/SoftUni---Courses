package zoo.entities.areas;

import zoo.common.ExceptionMessages;
import zoo.entities.animals.Animal;
import zoo.entities.foods.Food;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public abstract class BaseArea implements Area {

    private String name;
    private int capacity;
    private Collection<Food> foods;
    private Collection<Animal> animals;

    protected BaseArea(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        this.foods = new ArrayList<>();
        this.animals = new ArrayList<>();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.AREA_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public Collection<Animal> getAnimals() {
        return animals;
    }

    @Override
    public Collection<Food> getFoods() {
        return foods;
    }

    @Override
    public int sumCalories() {
        return this.foods.stream().mapToInt(Food::getCalories).sum();
    }

    @Override
    public void addAnimal(Animal animal) {
        if (this.animals.size() == this.capacity) {
            throw new IllegalStateException(ExceptionMessages.NOT_ENOUGH_CAPACITY);
        }
        this.animals.add(animal);
    }

    @Override
    public void removeAnimal(Animal animal) {
        this.animals.remove(animal);
    }

    @Override
    public void addFood(Food food) {
        this.foods.add(food);
    }

    @Override
    public void feed() {
        this.animals.stream().forEach(Animal::eat);
    }

    @Override
    public String getInfo() {
        // "{areaName} ({areaType}):
        // Animals: {animalName1} {animalName2} {animalName3} (…) / Animals: none
        // Foods: {foodsCount}
        // Calories: {sumCalories}"
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s (%s):", this.name, getClass().getSimpleName()));
        sb.append(System.lineSeparator());
        if (this.animals.isEmpty()) {
            sb.append("Animals: none");
        } else {
            sb.append(String.format("Animals: %s", this.animals.stream()
                    .map(Animal::getName)
                    .collect(Collectors.joining(" "))));
        }
        sb.append(System.lineSeparator());
        sb.append(String.format("Foods: %d", this.foods.size()));
        sb.append(System.lineSeparator());
        sb.append(String.format("Calories: %d", sumCalories()));
        sb.append(System.lineSeparator());

        return sb.toString().trim();
    }
}
