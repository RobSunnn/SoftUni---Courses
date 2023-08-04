package football.core;


import football.common.ConstantMessages;
import football.common.ExceptionMessages;
import football.entities.field.ArtificialTurf;
import football.entities.field.Field;
import football.entities.field.NaturalGrass;
import football.entities.player.Men;
import football.entities.player.Player;
import football.entities.player.Women;
import football.entities.supplement.Liquid;
import football.entities.supplement.Powdered;
import football.entities.supplement.Supplement;
import football.repositories.SupplementRepository;
import football.repositories.SupplementRepositoryImpl;

import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller {

    private SupplementRepository supplements;
    private Collection<Field> fields;

    public ControllerImpl() {
        this.supplements = new SupplementRepositoryImpl();
        this.fields = new ArrayList<>();
    }

    @Override
    public String addField(String fieldType, String fieldName) {
        Field field;
        if (fieldType.equals("ArtificialTurf")) {
            field = new ArtificialTurf(fieldName);
        } else if (fieldType.equals("NaturalGrass")) {
            field = new NaturalGrass(fieldName);
        } else {
            throw new NullPointerException(ExceptionMessages.INVALID_FIELD_TYPE);
        }

        this.fields.add(field);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FIELD_TYPE, fieldType);
    }

    @Override
    public String deliverySupplement(String type) {
        Supplement supplement;
        if (type.equals("Powdered")) {
            supplement = new Powdered();
        } else if (type.equals("Liquid")) {
            supplement = new Liquid();
        } else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_SUPPLEMENT_TYPE);
        }
        this.supplements.add(supplement);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE, type);
    }

    private Field getField(String fieldName) {
        return this.fields.stream().filter(field -> field.getName().equals(fieldName))
                .findFirst()
                .orElse(null);
    }

    @Override
    public String supplementForField(String fieldName, String supplementType) {
        Supplement supplement = this.supplements.findByType(supplementType);
        if (supplement == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_SUPPLEMENT_FOUND, supplementType));
        }
        Field field = getField(fieldName);
        field.addSupplement(supplement);
        this.supplements.remove(supplement);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_SUPPLEMENT_IN_FIELD, supplementType, fieldName);
    }

    @Override
    public String addPlayer(String fieldName, String playerType, String playerName, String nationality, int strength) {
        Player player;
        if (playerType.equals("Women")) {
            player = new Women(playerName, nationality, strength);
        } else if (playerType.equals("Men")) {
            player = new Men(playerName, nationality, strength);
        } else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_PLAYER_TYPE);
        }
        Field field = getField(fieldName);
        if (!canPlayerPlayOnField(field, player)) {
            return ConstantMessages.FIELD_NOT_SUITABLE;
        }

        field.addPlayer(player);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_PLAYER_IN_FIELD, playerType, fieldName);
    }

    private boolean canPlayerPlayOnField(Field field, Player player) {
        boolean canPlay = player.getClass().getSimpleName().equals("Women") &&
                field.getClass().getSimpleName().equals("ArtificialTurf");
        if (!canPlay) {

            canPlay = player.getClass().getSimpleName().equals("Men") &&
                    field.getClass().getSimpleName().equals("NaturalGrass");
        }
        return canPlay;
    }

    @Override
    public String dragPlayer(String fieldName) {
        Field field = getField(fieldName);
        field.getPlayers().forEach(Player::stimulation);
        return String.format(ConstantMessages.PLAYER_DRAG, field.getPlayers().size());
    }

    @Override
    public String calculateStrength(String fieldName) {
        Field field = getField(fieldName);
        int value = field.getPlayers().stream().mapToInt(Player::getStrength).sum();
        return String.format(ConstantMessages.STRENGTH_FIELD, fieldName, value);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();

        for (Field field : this.fields) {
            sb.append(field.getInfo())
                    .append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
