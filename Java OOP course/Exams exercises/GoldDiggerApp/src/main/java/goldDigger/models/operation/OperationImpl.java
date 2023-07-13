package goldDigger.models.operation;

import goldDigger.models.discoverer.Discoverer;
import goldDigger.models.spot.Spot;

import java.util.Collection;

public class OperationImpl implements Operation {

    @Override
    public void startOperation(Spot spot, Collection<Discoverer> discoverers) {

        for (Discoverer discoverer : discoverers) {

            while (discoverer.canDig()) {
                if (spot.getExhibits().isEmpty()) {
                    return;
                }
                String exhibit = null;
                for (String ex : spot.getExhibits()) {
                    exhibit = ex;
                    break;
                }

                discoverer.dig();
                discoverer.getMuseum().getExhibits().add(exhibit);
                spot.getExhibits().remove(exhibit);
            }

        }

    }
}
