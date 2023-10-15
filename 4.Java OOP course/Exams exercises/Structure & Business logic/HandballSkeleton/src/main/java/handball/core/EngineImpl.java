package handball.core;

import handball.common.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EngineImpl implements Engine {
    private Controller controller;
    private BufferedReader reader;

    public EngineImpl() {
        this.controller = new ControllerImpl();
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {
        while (true) {
            String result = null;
            try {
                result = processInput();

                if (result.equals("Exit")) {
                    break;
                }
            } catch (NullPointerException | IllegalArgumentException | IllegalStateException | IOException e) {
                result = e.getMessage();
            }

            System.out.println(result);
        }
    }

    private String processInput() throws IOException {
        String input = this.reader.readLine();
        String[] tokens = input.split("\\s+");

        Command command = Command.valueOf(tokens[0]);
        String result = null;
        String[] data = Arrays.stream(tokens).skip(1).toArray(String[]::new);

        switch (command) {
            case AddGameplay:
                result = addGameplay(data);
                break;
            case AddTeam:
                result = addTeam(data);
                break;
            case AddEquipment:
                result = addEquipment(data);
                break;
            case EquipmentRequirement:
                result = equipmentRequirement(data);
                break;
            case PlayInGameplay:
                result = playInGameplay(data);
                break;
            case PercentAdvantage:
                result = percentAdvantage(data);
                break;
            case GetStatistics:
                result = getStatistics();
                break;
            case Exit:
                result = Command.Exit.name();
                break;
        }
        return result;
    }

    private String addGameplay(String[] data) {

        return this.controller.addGameplay(data[0], data[1]);
    }

    private String addEquipment(String[] data) {

        return this.controller.addEquipment(data[0]);
    }

    private String equipmentRequirement(String[] data) {

        return this.controller.equipmentRequirement(data[0], data[1]);
    }

    private String addTeam(String[] data) {

        return this.controller.addTeam(data[0], data[1], data[2], data[3], Integer.parseInt(data[4]));
    }

    private String playInGameplay(String[] data) {

        return this.controller.playInGameplay(data[0]);
    }

    private String percentAdvantage(String[] data) {

        return this.controller.percentAdvantage(data[0]);
    }

    private String getStatistics() {
        return controller.getStatistics();
    }
}
