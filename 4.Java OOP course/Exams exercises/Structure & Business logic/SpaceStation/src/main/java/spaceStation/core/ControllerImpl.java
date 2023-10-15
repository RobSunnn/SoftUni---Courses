package spaceStation.core;

import spaceStation.common.ConstantMessages;
import spaceStation.common.ExceptionMessages;
import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.astronauts.Biologist;
import spaceStation.models.astronauts.Geodesist;
import spaceStation.models.astronauts.Meteorologist;
import spaceStation.models.mission.MissionImpl;
import spaceStation.models.planets.Planet;
import spaceStation.models.planets.PlanetImpl;
import spaceStation.repositories.AstronautRepository;
import spaceStation.repositories.PlanetRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {

    private AstronautRepository astronautRepository;
    private PlanetRepository planetRepository;

    private int countPlanets;

    public ControllerImpl() {
        this.astronautRepository = new AstronautRepository();
        this.planetRepository = new PlanetRepository();
        this.countPlanets = 0;
    }

    @Override
    public String addAstronaut(String type, String astronautName) {
        Astronaut astronaut;
        if (type.equals("Biologist")) {
            astronaut = new Biologist(astronautName);
        } else if (type.equals("Geodesist")) {
            astronaut = new Geodesist(astronautName);
        } else if (type.equals("Meteorologist")) {
            astronaut = new Meteorologist(astronautName);
        } else {
            throw new IllegalArgumentException(ExceptionMessages.ASTRONAUT_INVALID_TYPE);
        }

        this.astronautRepository.add(astronaut);

        return String.format(ConstantMessages.ASTRONAUT_ADDED, type, astronautName);
    }

    @Override
    public String addPlanet(String planetName, String... items) {
        Planet planet = new PlanetImpl(planetName);

        for (String item : items) {
            planet.getItems().add(item);
        }


        this.planetRepository.add(planet);

        return String.format(ConstantMessages.PLANET_ADDED, planetName);
    }

    @Override
    public String retireAstronaut(String astronautName) {
        Astronaut astronaut = this.astronautRepository.findByName(astronautName);

        if (astronaut == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.ASTRONAUT_DOES_NOT_EXIST, astronautName));
        }

        //this.astronautRepository.getModels().remove(astronaut);

        return String.format(ConstantMessages.ASTRONAUT_RETIRED, astronautName);
    }

    @Override
    public String explorePlanet(String planetName) {

        List<Astronaut> list = this.astronautRepository.getModels().stream()
                .filter(a -> a.getOxygen() > 60.0)
                .collect(Collectors.toList());

        if (list.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.PLANET_ASTRONAUTS_DOES_NOT_EXISTS);
        }

        Planet planet = this.planetRepository.findByName(planetName);

        MissionImpl mission = new MissionImpl();
        mission.explore(planet, list);
        this.planetRepository.remove(planet);
        this.countPlanets++;
        int astronautsLeft = mission.getAstronautsLeft();

        return String.format(ConstantMessages.PLANET_EXPLORED, planetName, astronautsLeft);
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(ConstantMessages.REPORT_PLANET_EXPLORED, this.countPlanets));
        sb.append(System.lineSeparator());
        sb.append(ConstantMessages.REPORT_ASTRONAUT_INFO);
        sb.append(System.lineSeparator());
        for (Astronaut astronaut : this.astronautRepository.getModels()) {
            sb.append(String.format(ConstantMessages.REPORT_ASTRONAUT_NAME, astronaut.getName()));
            sb.append(System.lineSeparator());
            sb.append(String.format(ConstantMessages.REPORT_ASTRONAUT_OXYGEN, astronaut.getOxygen()));
            sb.append(System.lineSeparator());

            if (astronaut.getBag().getItems().isEmpty()) {
                sb.append(String.format(ConstantMessages.REPORT_ASTRONAUT_BAG_ITEMS, "none"));
                sb.append(System.lineSeparator());
            } else {
                sb.append(String.format(ConstantMessages.REPORT_ASTRONAUT_BAG_ITEMS,

                        String.join(ConstantMessages.REPORT_ASTRONAUT_BAG_ITEMS_DELIMITER, astronaut.getBag().getItems())));
                sb.append(System.lineSeparator());
            }
        }

        return sb.toString().trim();
    }
}
