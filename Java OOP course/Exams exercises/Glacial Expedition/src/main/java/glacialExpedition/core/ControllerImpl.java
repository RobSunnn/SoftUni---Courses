package glacialExpedition.core;

import glacialExpedition.common.ConstantMessages;
import glacialExpedition.common.ExceptionMessages;
import glacialExpedition.models.explorers.AnimalExplorer;
import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.explorers.GlacierExplorer;
import glacialExpedition.models.explorers.NaturalExplorer;
import glacialExpedition.models.mission.Mission;
import glacialExpedition.models.mission.MissionImpl;
import glacialExpedition.models.states.State;
import glacialExpedition.models.states.StateImpl;
import glacialExpedition.repositories.ExplorerRepository;
import glacialExpedition.repositories.StateRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {

    private ExplorerRepository explorerRepository;
    private StateRepository stateRepository;
    private int statesExplored;

    public ControllerImpl() {
        this.explorerRepository = new ExplorerRepository();
        this.stateRepository = new StateRepository();
        this.statesExplored = 0;
    }

    @Override
    public String addExplorer(String type, String explorerName) {
        Explorer explorer;
        if (type.equals("AnimalExplorer")) {
            explorer = new AnimalExplorer(explorerName);
        } else if (type.equals("GlacierExplorer")) {
            explorer = new GlacierExplorer(explorerName);
        } else if (type.equals("NaturalExplorer")) {
            explorer = new NaturalExplorer(explorerName);
        } else {
            throw new IllegalArgumentException(ExceptionMessages.EXPLORER_INVALID_TYPE);
        }

        this.explorerRepository.add(explorer);

        return String.format(ConstantMessages.EXPLORER_ADDED, type, explorerName);
    }

    @Override
    public String addState(String stateName, String... exhibits) {
        State state = new StateImpl(stateName);
        for (String exhibit : exhibits) {
            state.getExhibits().add(exhibit);
        }

        this.stateRepository.add(state);

        return String.format(ConstantMessages.STATE_ADDED, stateName);
    }

    @Override
    public String retireExplorer(String explorerName) {
        Explorer explorer = this.explorerRepository.byName(explorerName);

        if (explorer == null) {
            throw new IllegalArgumentException
                    (String.format(ExceptionMessages.EXPLORER_DOES_NOT_EXIST, explorerName));
        }

        this.explorerRepository.remove(explorer);

        return String.format(ConstantMessages.EXPLORER_RETIRED, explorerName);
    }

    @Override
    public String exploreState(String stateName) {
        List<Explorer> explorers = this.explorerRepository.getCollection()
                .stream().filter(e -> e.getEnergy() > 50)
                .collect(Collectors.toList());

        if (explorers.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.STATE_EXPLORERS_DOES_NOT_EXISTS);
        }
        State state = this.stateRepository.byName(stateName);
        int retiredExplorers = 0;
        if (state != null) {
            MissionImpl mission = new MissionImpl();
            mission.explore(state, explorers);
            retiredExplorers = mission.getRetiredExplorers();
            this.statesExplored++;
        }
        this.stateRepository.remove(state);

        return String.format(ConstantMessages.STATE_EXPLORER, stateName, retiredExplorers);
    }

    @Override
    public String finalResult() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(ConstantMessages.FINAL_STATE_EXPLORED, this.statesExplored));
        sb.append(System.lineSeparator());
        sb.append(ConstantMessages.FINAL_EXPLORER_INFO);
        sb.append(System.lineSeparator());
        for (Explorer explorer : this.explorerRepository.getCollection()) {
            sb.append(String.format(ConstantMessages.FINAL_EXPLORER_NAME, explorer.getName()));
            sb.append(System.lineSeparator());
            sb.append(String.format(ConstantMessages.FINAL_EXPLORER_ENERGY, explorer.getEnergy()));
            sb.append(System.lineSeparator());
            if (explorer.getSuitcase().getExhibits().isEmpty()) {
                sb.append(String.format(ConstantMessages.FINAL_EXPLORER_SUITCASE_EXHIBITS, "None"));
                sb.append(System.lineSeparator());
            } else {
                sb.append(String.format(ConstantMessages.FINAL_EXPLORER_SUITCASE_EXHIBITS,
                        String.join(ConstantMessages.FINAL_EXPLORER_SUITCASE_EXHIBITS_DELIMITER, explorer.getSuitcase().getExhibits())));
                sb.append(System.lineSeparator());
            }

        }

        return sb.toString().trim();
    }
}
