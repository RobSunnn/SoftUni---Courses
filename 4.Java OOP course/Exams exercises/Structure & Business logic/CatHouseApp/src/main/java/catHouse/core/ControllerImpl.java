package catHouse.core;

import catHouse.common.ConstantMessages;
import catHouse.common.ExceptionMessages;
import catHouse.entities.cat.Cat;
import catHouse.entities.cat.LonghairCat;
import catHouse.entities.cat.ShorthairCat;
import catHouse.entities.houses.House;
import catHouse.entities.houses.LongHouse;
import catHouse.entities.houses.ShortHouse;
import catHouse.entities.toys.Ball;
import catHouse.entities.toys.Mouse;
import catHouse.entities.toys.Toy;
import catHouse.repositories.ToyRepository;

import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller {

    private ToyRepository toys;
    private Collection<House> houses;

    public ControllerImpl() {
        this.toys = new ToyRepository();
        this.houses = new ArrayList<>();
    }

    @Override
    public String addHouse(String type, String name) {
        House house;
        if (type.equals("LongHouse")) {
            house = new LongHouse(name);
        } else if (type.equals("ShortHouse")) {
            house = new ShortHouse(name);
        } else {
            throw new NullPointerException(ExceptionMessages.INVALID_HOUSE_TYPE);
        }

        this.houses.add(house);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_HOUSE_TYPE, type);
    }

    @Override
    public String buyToy(String type) {
        Toy toy;
        if (type.equals("Ball")) {
            toy = new Ball();
        } else if (type.equals("Mouse")) {
            toy = new Mouse();
        } else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_TOY_TYPE);
        }

        this.toys.buyToy(toy);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_TOY_TYPE, type);
    }

    @Override
    public String toyForHouse(String houseName, String toyType) {
        Toy toy = this.toys.findFirst(toyType);
        if (toy == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_TOY_FOUND, toyType));
        }
        House house = findHouse(houseName);
        house.buyToy(toy);
        this.toys.removeToy(toy);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_TOY_IN_HOUSE, toyType, houseName);
    }

    private House findHouse(String houseName) {
        return this.houses.stream().filter(house1 -> house1.getName().equals(houseName))
                .findFirst().orElse(null);
    }

    @Override
    public String addCat(String houseName, String catType, String catName, String catBreed, double price) {
        Cat cat;
        if (catType.equals("LonghairCat")) {
            cat = new LonghairCat(catName, catBreed, price);
        } else if (catType.equals("ShorthairCat")) {
            cat = new ShorthairCat(catName, catBreed, price);
        } else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_CAT_TYPE);
        }
        House house = findHouse(houseName);
        if (!canCatLiveInHouse(cat, house)) {
            return ConstantMessages.UNSUITABLE_HOUSE;
        }
        house.addCat(cat);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_CAT_IN_HOUSE, catType, houseName);
    }

    private boolean canCatLiveInHouse(Cat cat, House house) {
        boolean canLive = cat.getClass().getSimpleName().equals("ShorthairCat") &&
                house.getClass().getSimpleName().equals("ShortHouse");
        if (!canLive) {
            canLive = cat.getClass().getSimpleName().equals("LonghairCat") &&
                    house.getClass().getSimpleName().equals("LongHouse");
        }
        return canLive;
    }

    @Override
    public String feedingCat(String houseName) {
        House house = findHouse(houseName);
        house.getCats().stream().forEach(Cat::eating);

        return String.format(ConstantMessages.FEEDING_CAT, house.getCats().size());
    }

    @Override
    public String sumOfAll(String houseName) {
        House house = findHouse(houseName);
        double value = house.getCats().stream().mapToDouble(Cat::getPrice).sum() +
                house.getToys().stream().mapToDouble(Toy::getPrice).sum();

        return String.format(ConstantMessages.VALUE_HOUSE, houseName, value);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        for (House house : this.houses) {
            sb.append(house.getStatistics())
                    .append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
