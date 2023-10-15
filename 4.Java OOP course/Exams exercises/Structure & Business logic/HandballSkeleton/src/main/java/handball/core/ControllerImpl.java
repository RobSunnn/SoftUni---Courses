package handball.core;

import handball.common.ConstantMessages;
import handball.common.ExceptionMessages;
import handball.entities.equipment.ElbowPad;
import handball.entities.equipment.Equipment;
import handball.entities.equipment.Kneepad;
import handball.entities.gameplay.Gameplay;
import handball.entities.gameplay.Indoor;
import handball.entities.gameplay.Outdoor;
import handball.entities.team.Bulgaria;
import handball.entities.team.Germany;
import handball.entities.team.Team;
import handball.repositories.EquipmentRepository;

import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller {

    private EquipmentRepository equipment;

    private Collection<Gameplay> gameplays;

    public ControllerImpl() {
        this.equipment = new EquipmentRepository();
        this.gameplays = new ArrayList<>();
    }

    @Override
    public String addGameplay(String gameplayType, String gameplayName) {
        Gameplay gameplay = null;

        switch (gameplayType) {
            case "Indoor":
                gameplay = new Indoor(gameplayName);
                break;
            case "Outdoor":
                gameplay = new Outdoor(gameplayName);
                break;
            default:
                throw new NullPointerException(ExceptionMessages.INVALID_GAMEPLAY_TYPE);
        }

        this.gameplays.add(gameplay);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_GAMEPLAY_TYPE, gameplayType);
    }

    @Override
    public String addEquipment(String equipmentType) {
        Equipment equipment = null;

        switch (equipmentType) {
            case "Kneepad":
                equipment = new Kneepad();
                break;
            case "ElbowPad":
                equipment = new ElbowPad();
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_EQUIPMENT_TYPE);
        }

        this.equipment.add(equipment);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_EQUIPMENT_TYPE, equipmentType);
    }

    @Override
    public String equipmentRequirement(String gameplayName, String equipmentType) {
        Equipment equipment = this.equipment.findByType(equipmentType);
        if (equipment == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_EQUIPMENT_FOUND, equipmentType));
        }

        Gameplay gameplay = findGameplay(gameplayName);

        if (gameplay != null) {
            gameplay.addEquipment(equipment);
            this.equipment.remove(equipment);

        } else {
            throw new NullPointerException("No gameplay found!");
        }

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_EQUIPMENT_IN_GAMEPLAY, equipmentType, gameplayName);
    }

    private Gameplay findGameplay(String gameplayName) {
        return this.gameplays.stream().filter(gameplay -> gameplay.getName().equals(gameplayName)).findFirst().orElse(null);
    }

    @Override
    public String addTeam(String gameplayName, String teamType, String teamName, String country, int advantage) {
        Team team = null;

        switch (teamType) {
            case "Bulgaria":
                team = new Bulgaria(teamName, country, advantage);
                break;
            case "Germany":
                team = new Germany(teamName, country, advantage);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_TEAM_TYPE);
        }

        Gameplay gameplay = findGameplay(gameplayName);

        if (gameplay != null) {
            if (!isTerrainSuitableForTeam(team, gameplay)) {
                return ConstantMessages.GAMEPLAY_NOT_SUITABLE;
            } else {
                gameplay.addTeam(team);
            }

        } else {
            throw new NullPointerException("Gameplay name not found");
        }

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_TEAM_IN_GAMEPLAY, teamType, gameplayName);
    }

    private boolean isTerrainSuitableForTeam(Team team, Gameplay gameplay) {
        boolean checkTeam = team.getClass().getSimpleName().equals("Bulgaria") &&
                gameplay.getClass().getSimpleName().equals("Outdoor");

        if (!checkTeam) {
            checkTeam = team.getClass().getSimpleName().equals("Germany") &&
                    gameplay.getClass().getSimpleName().equals("Indoor");
        }

        return checkTeam;
    }

    @Override
    public String playInGameplay(String gameplayName) {
        Gameplay gameplay = findGameplay(gameplayName);
        gameplay.getTeam().forEach(Team::play);
        return String.format(ConstantMessages.TEAMS_PLAYED, gameplay.getTeam().size());
    }

    @Override
    public String percentAdvantage(String gameplayName) {
        Gameplay gameplay = findGameplay(gameplayName);
        int value = gameplay.getTeam().stream().mapToInt(Team::getAdvantage).sum();

        return String.format(ConstantMessages.ADVANTAGE_GAMEPLAY, gameplayName, value);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();

        for (Gameplay gameplay : this.gameplays) {
            sb.append(gameplay.toString()).append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
