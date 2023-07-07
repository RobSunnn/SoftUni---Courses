package easterRaces.core;

import easterRaces.common.ExceptionMessages;
import easterRaces.common.OutputMessages;
import easterRaces.core.interfaces.Controller;
import easterRaces.entities.cars.Car;
import easterRaces.entities.cars.MuscleCar;
import easterRaces.entities.cars.SportsCar;
import easterRaces.entities.drivers.Driver;
import easterRaces.entities.drivers.DriverImpl;
import easterRaces.entities.racers.Race;
import easterRaces.entities.racers.RaceImpl;
import easterRaces.repositories.CarRepository;
import easterRaces.repositories.DriverRepository;
import easterRaces.repositories.RaceRepository;
import easterRaces.repositories.interfaces.Repository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {

    private Repository<Driver> driverRepository;
    private Repository<Car> carRepository;
    private Repository<Race> raceRepository;

    public ControllerImpl(Repository<Driver> driverRepository,
                          Repository<Car> carRepository, Repository<Race> raceRepository) {

        this.driverRepository = driverRepository;
        this.carRepository = carRepository;
        this.raceRepository = raceRepository;
    }

    @Override
    public String createDriver(String driver) {
        Driver d = this.driverRepository.getByName(driver);
        if (d != null) {
            throw new IllegalArgumentException
                    (String.format(ExceptionMessages.DRIVER_EXISTS, driver));
        }
        Driver racer = new DriverImpl(driver);

        this.driverRepository.add(racer);

        return String.format(OutputMessages.DRIVER_CREATED, driver);
    }

    @Override
    public String createCar(String type, String model, int horsePower) {
        Car car = this.carRepository.getByName(model);

        if (car != null) {
            throw new IllegalArgumentException
                    (String.format(ExceptionMessages.CAR_EXISTS, model));
        }
        if (type.equals("Sports")) {
            car = new SportsCar(model, horsePower);
        } else if (type.equals("Muscle")) {
            car = new MuscleCar(model, horsePower);
        }
        this.carRepository.add(car);

        return String.format(OutputMessages.CAR_CREATED, car.getClass().getSimpleName(), model);
    }

    @Override
    public String addCarToDriver(String driverName, String carModel) {
        Driver driver = this.driverRepository.getByName(driverName);
        if (driver == null) {
            throw new IllegalArgumentException
                    (String.format(ExceptionMessages.DRIVER_NOT_FOUND, driverName));
        }
        Car car = this.carRepository.getByName(carModel);
        if (car == null) {
            throw new IllegalArgumentException
                    (String.format(ExceptionMessages.CAR_NOT_FOUND, carModel));
        }

        driver.addCar(car);

        return String.format(OutputMessages.CAR_ADDED, driverName, carModel);
    }

    @Override
    public String addDriverToRace(String raceName, String driverName) {
        Race race = this.raceRepository.getByName(raceName);
        if (race == null) {
            throw new IllegalArgumentException
                    (String.format(ExceptionMessages.RACE_NOT_FOUND, raceName));
        }
        Driver driver = this.driverRepository.getByName(driverName);
        if (driver == null) {
            throw new IllegalArgumentException
                    (String.format(ExceptionMessages.DRIVER_NOT_FOUND, driverName));
        }
        race.addDriver(driver);

        return String.format(OutputMessages.DRIVER_ADDED, driverName, raceName);
    }

    @Override
    public String startRace(String raceName) {
        Race race = this.raceRepository.getByName(raceName);
        if (race == null) {
            throw new IllegalArgumentException
                    (String.format(ExceptionMessages.RACE_NOT_FOUND, raceName));
        }
        if (race.getDrivers().size() < 3) {
            throw new IllegalArgumentException
                    (String.format(ExceptionMessages.RACE_INVALID, raceName, 3));
        }

        List<Driver> winners = race.getDrivers().stream().sorted((d1, d2) -> Double.compare(d2.getCar().calculateRacePoints(race.getLaps()),
                        d1.getCar().calculateRacePoints(race.getLaps())))
                .collect(Collectors.toList());
        winners.get(0).winRace();
        String sb = String.format(OutputMessages.DRIVER_FIRST_POSITION, winners.get(0).getName(), race.getName()) +
                System.lineSeparator() +
                String.format(OutputMessages.DRIVER_SECOND_POSITION, winners.get(1).getName(), race.getName()) +
                System.lineSeparator() +
                String.format(OutputMessages.DRIVER_THIRD_POSITION, winners.get(2).getName(), race.getName()) +
                System.lineSeparator();

        this.raceRepository.remove(race);

        return sb.trim();
    }

    @Override
    public String createRace(String name, int laps) {
        Race race = this.raceRepository.getByName(name);
        if (race != null) {
            throw new IllegalArgumentException
                    (String.format(ExceptionMessages.RACE_EXISTS, name));
        }
        race = new RaceImpl(name, laps);
        this.raceRepository.add(race);
        return String.format(OutputMessages.RACE_CREATED, name);
    }
}
