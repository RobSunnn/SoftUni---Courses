package spaceStation.models.mission;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.planets.Planet;

import java.util.Collection;

public class MissionImpl implements Mission {

    private int astronautsLeft;

    public int getAstronautsLeft() {
        return this.astronautsLeft;
    }

    public void setAstronautsLeft(int astronautsLeft) {
        this.astronautsLeft = astronautsLeft;
    }

    @Override
    public void explore(Planet planet, Collection<Astronaut> astronauts) {

        for (Astronaut astronaut : astronauts) {
            if (planet.getItems().isEmpty()) {
                break;
            }
            while (astronaut.canBreath() && !planet.getItems().isEmpty()) {

                while (!planet.getItems().isEmpty()) {
                    for (int i = 0; i < planet.getItems().size(); i++) {
                        if (!astronaut.canBreath()) {
                            this.astronautsLeft++;
                            break;
                        }
                        String item = planet.getItems().get(0);
                        astronaut.getBag().getItems().add(item);
                        astronaut.breath();
                        planet.getItems().remove(item);
                        i--;

                    }
                    if (planet.getItems().isEmpty() || !astronaut.canBreath()) {
                        break;
                    }
                }

            }

        }
    }
}
