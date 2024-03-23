package harpoonDiver.models.diving;

import harpoonDiver.models.diver.Diver;
import harpoonDiver.models.divingSite.DivingSite;

import java.util.Collection;

public class DivingImpl implements Diving {


    @Override
    public void searching(DivingSite divingSite, Collection<Diver> divers) {

        for (Diver diver : divers) {

            for (int i = 0; i < divingSite.getSeaCreatures().size(); i++) {
                String creature = divingSite.getSeaCreatures().stream().findFirst().get();

                if (!diver.canDive()) {
                    break;
                }
                diver.shoot();
                diver.getSeaCatch().getSeaCreatures().add(creature);
                divingSite.getSeaCreatures().remove(creature);
                i--;

                if (divingSite.getSeaCreatures().isEmpty()) {
                    break;
                }
            }
            if (divingSite.getSeaCreatures().isEmpty()) {
                break;
            }

        }

    }


}
