package glacialExpedition.models.mission;

import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.states.State;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MissionImpl implements Mission {

    private int retiredExplorers;

    public int getRetiredExplorers() {
        return retiredExplorers;
    }

    private void setRetiredExplorers(int retiredExplorers) {
        this.retiredExplorers = retiredExplorers;
    }

    @Override
    public void explore(State state, Collection<Explorer> explorers) {

        List<Explorer> explorerList = explorers.stream()
                .filter(e -> e.getEnergy() > 0)
                .collect(Collectors.toList());


        for (Explorer explorer : explorerList) {

            while (explorer.canSearch()) {
                if (state.getExhibits().isEmpty()) {
                    return;
                }

                String st = null;
                for (String exhibit : state.getExhibits()) {
                    st = exhibit;
                    break;
                }

                if (!st.equals("null")) {
                    explorer.search();
                    explorer.getSuitcase().getExhibits().add(st);
                    state.getExhibits().remove(st);
                }
                if (!explorer.canSearch()) {
                    setRetiredExplorers(getRetiredExplorers() + 1);

                }
            }

        }

    }
}
