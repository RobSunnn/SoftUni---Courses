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

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {

    private Repository<Car> carRepository;
    private Repository<Race> raceRepository;
    private Repository<Driver> driverRepository;

    public ControllerImpl(Repository<Driver> driverRepository,
                          Repository<Car> carRepository,
                          Repository<Race> raceRepository) {
        this.carRepository = carRepository;
        this.raceRepository = raceRepository;
        this.driverRepository = driverRepository;
    }

    @Override
    public String createDriver(String driver) {
        Driver d = this.driverRepository.getByName(driver);
        if (d != null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.DRIVER_EXISTS, driver));
        }

        Driver racer = new DriverImpl(driver);
        this.driverRepository.add(racer);

        return String.format(OutputMessages.DRIVER_CREATED, driver);
    }

    @Override
    public String createCar(String type, String model, int horsePower) {
        Car c = this.carRepository.getByName(model);
        if (c != null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.CAR_EXISTS, model));
        }

        Car car = null;
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
            throw new IllegalArgumentException(String.format(ExceptionMessages.DRIVER_NOT_FOUND, driverName));
        }
        Car car = this.carRepository.getByName(carModel);
        if (car == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.CAR_NOT_FOUND, carModel));
        }

        driver.addCar(car);

        return String.format(OutputMessages.CAR_ADDED, driverName, carModel);
    }

    @Override
    public String addDriverToRace(String raceName, String driverName) {

        Race race = this.raceRepository.getByName(raceName);
        if (race == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.RACE_NOT_FOUND, raceName));
        }

        Driver driver = this.driverRepository.getByName(driverName);
        if (driver == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.DRIVER_NOT_FOUND, driverName));
        }
        race.addDriver(driver);


        return String.format(OutputMessages.DRIVER_ADDED, driverName, raceName);
    }

    @Override
    public String startRace(String raceName) {
        Race race = this.raceRepository.getByName(raceName);
        if (race == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.RACE_NOT_FOUND, raceName));
        }
        if (race.getDrivers().size() < 3) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.RACE_INVALID, raceName, 3));
        }
        for (Driver driver : race.getDrivers()) {
            driver.getCar().calculateRacePoints(race.getLaps());
        }

        List<Driver> drivers = race.getDrivers()
                .stream().sorted(Comparator.comparing(d -> d.getCar().getRacePoints())).collect(Collectors.toList());

        Driver winner = drivers.get(2);
        winner.winRace();
        this.raceRepository.remove(race);
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Driver %s wins %s race.", winner.getName(), raceName));
        sb.append(System.lineSeparator());
        sb.append(String.format("Driver %s is second in %s race.", drivers.get(1).getName(), raceName));
        sb.append(System.lineSeparator());
        sb.append(String.format("Driver %s is third in %s race.", drivers.get(0).getName(), raceName));

        return sb.toString().trim();
    }

    @Override
    public String createRace(String name, int laps) {
        Race r = this.raceRepository.getByName(name);
        if (r != null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.RACE_EXISTS, name));
        }
        Race race = new RaceImpl(name, laps);
        this.raceRepository.add(race);

        return String.format(OutputMessages.RACE_CREATED, name);
    }
}
