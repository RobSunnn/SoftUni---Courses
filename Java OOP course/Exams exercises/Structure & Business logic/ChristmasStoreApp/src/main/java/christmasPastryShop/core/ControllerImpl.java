package christmasPastryShop.core;

import christmasPastryShop.common.ExceptionMessages;
import christmasPastryShop.common.OutputMessages;
import christmasPastryShop.core.interfaces.Controller;
import christmasPastryShop.entities.booths.OpenBooth;
import christmasPastryShop.entities.booths.PrivateBooth;
import christmasPastryShop.entities.cocktails.Hibernation;
import christmasPastryShop.entities.cocktails.MulledWine;
import christmasPastryShop.entities.delicacies.Gingerbread;
import christmasPastryShop.entities.delicacies.Stolen;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;
import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.entities.booths.interfaces.Booth;
import christmasPastryShop.repositories.interfaces.BoothRepository;
import christmasPastryShop.repositories.interfaces.CocktailRepository;
import christmasPastryShop.repositories.interfaces.DelicacyRepository;


public class ControllerImpl implements Controller {

    private final DelicacyRepository<Delicacy> delicacyRepository;
    private final CocktailRepository<Cocktail> cocktailRepository;
    private final BoothRepository<Booth> boothRepository;

    double totalStoreIncome = 0.0;

    public ControllerImpl(DelicacyRepository<Delicacy> delicacyRepository,
                          CocktailRepository<Cocktail> cocktailRepository,
                          BoothRepository<Booth> boothRepository) {

        this.delicacyRepository = delicacyRepository;
        this.cocktailRepository = cocktailRepository;
        this.boothRepository = boothRepository;
    }


    @Override
    public String addDelicacy(String type, String name, double price) {

        for (Delicacy delicacy : this.delicacyRepository.getAll()) {
            if (delicacy.getName().equals(name)) {
                throw new IllegalArgumentException(String.format(ExceptionMessages.FOOD_OR_DRINK_EXIST, type, name));

            }
        }

        Delicacy delicacy = null;
        if (type.equals("Gingerbread")) {
            delicacy = new Gingerbread(name, price);
        } else if (type.equals("Stolen")) {
            delicacy = new Stolen(name, price);
        }


        this.delicacyRepository.add(delicacy);

        return String.format(OutputMessages.DELICACY_ADDED, name, type);
    }

    @Override
    public String addCocktail(String type, String name, int size, String brand) {

        for (Cocktail cocktail : this.cocktailRepository.getAll()) {
            if (cocktail.getName().equals(name)) {
                throw new IllegalArgumentException(String.format(ExceptionMessages.FOOD_OR_DRINK_EXIST, type, name));
            }
        }

        Cocktail cocktail = null;

        if (type.equals("Hibernation")) {
            cocktail = new Hibernation(name, size, brand);
        } else if (type.equals("MulledWine")) {
            cocktail = new MulledWine(name, size, brand);
        }

        this.cocktailRepository.add(cocktail);

        return String.format(OutputMessages.COCKTAIL_ADDED, name, brand);
    }

    @Override
    public String addBooth(String type, int boothNumber, int capacity) {

        for (Booth booth : this.boothRepository.getAll()) {
            if (booth.getBoothNumber() == boothNumber) {
                throw new IllegalArgumentException(String.format(ExceptionMessages.BOOTH_EXIST, boothNumber));
            }
        }

        Booth booth = null;
        if (type.equals("OpenBooth")) {
            booth = new OpenBooth(boothNumber, capacity);
        } else if (type.equals("PrivateBooth")) {
            booth = new PrivateBooth(boothNumber, capacity);
        }

        this.boothRepository.add(booth);

        return String.format(OutputMessages.BOOTH_ADDED, boothNumber);
    }

    @Override
    public String reserveBooth(int numberOfPeople) {

        for (Booth booth : this.boothRepository.getAll()) {
            if (!booth.isReserved() && booth.getCapacity() >= numberOfPeople) {
                booth.reserve(numberOfPeople);
                return String.format(OutputMessages.BOOTH_RESERVED, booth.getBoothNumber(), numberOfPeople);
            }
        }

        return (String.format(OutputMessages.RESERVATION_NOT_POSSIBLE, numberOfPeople));

    }

    @Override
    public String leaveBooth(int boothNumber) {
        Booth toLeave = this.boothRepository.getByNumber(boothNumber);

        double bill = toLeave.getBill() + toLeave.getPrice();
        totalStoreIncome += bill;
        toLeave.clear();

        return String.format(OutputMessages.BILL, toLeave.getBoothNumber(), bill);
    }

    @Override
    public String getIncome() {
        return String.format(OutputMessages.TOTAL_INCOME, totalStoreIncome);
    }
}
