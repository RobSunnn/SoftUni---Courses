package bakery.entities.tables;

import bakery.common.ExceptionMessages;
import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.entities.drinks.interfaces.Drink;
import bakery.entities.tables.interfaces.Table;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseTable implements Table {

    private Collection<BakedFood> foodOrders;
    private Collection<Drink> drinkOrders;
    private int tableNumber;
    private int capacity;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReserved;
    private double price;

    protected BaseTable(int tableNumber, int capacity, double pricePerPerson) {
        this.tableNumber = tableNumber;
        this.setCapacity(capacity);
        this.pricePerPerson = pricePerPerson;
        this.isReserved = false;
        this.foodOrders = new ArrayList<>();
        this.drinkOrders = new ArrayList<>();
    }

    public void setCapacity(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_TABLE_CAPACITY);
        }
        this.capacity = capacity;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        if (numberOfPeople <= 0) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople = numberOfPeople;
    }

    @Override
    public int getTableNumber() {
        return this.tableNumber;
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public int getNumberOfPeople() {
        return this.numberOfPeople;
    }

    @Override
    public double getPricePerPerson() {
        return this.pricePerPerson;
    }

    @Override
    public boolean isReserved() {
        return this.numberOfPeople > 0;
    }

    @Override
    public double getPrice() {
        this.price = this.numberOfPeople * this.pricePerPerson;
        return this.price;
    }

    @Override
    public void reserve(int numberOfPeople) {
        this.isReserved = true;
        this.setNumberOfPeople(numberOfPeople);
    }

    @Override
    public void orderFood(BakedFood food) {
        this.foodOrders.add(food);
    }

    @Override
    public void orderDrink(Drink drink) {
        this.drinkOrders.add(drink);
    }

    @Override
    public double getBill() {
        double bill = 0.0;
        if (!this.foodOrders.isEmpty()) {
            bill += this.foodOrders.stream().mapToDouble(BakedFood::getPrice).sum();
        }
        if (!this.drinkOrders.isEmpty()) {
            bill += this.drinkOrders.stream().mapToDouble(Drink::getPrice).sum();
        }

        return bill;

    }

    @Override
    public void clear() {
        this.foodOrders.clear();
        this.drinkOrders.clear();
        this.isReserved = false;
        this.numberOfPeople = 0;
        this.price = 0.0;
    }

    @Override
    public String getFreeTableInfo() {

        //"Table: {table number}"
        //"Type: {table type}"
        //"Capacity: {table capacity}"
        //"Price per Person: {price per person for the current table}"
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Table: %d", this.tableNumber));
        sb.append(System.lineSeparator());
        sb.append(String.format("Type: %s", getClass().getSimpleName()));
        sb.append(System.lineSeparator());
        sb.append(String.format("Capacity: %d", this.capacity));
        sb.append(System.lineSeparator());
        sb.append(String.format("Price per Person: %.2f", this.pricePerPerson));


        return sb.toString().trim();
    }
}
