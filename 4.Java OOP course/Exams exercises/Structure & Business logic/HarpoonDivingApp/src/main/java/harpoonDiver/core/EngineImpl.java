package harpoonDiver.core;

import harpoonDiver.common.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class EngineImpl implements Engine {
    private final Controller controller;
    private final Scanner scanner;

    public EngineImpl(Controller controller) {
        this.controller = controller; //TODO implement first ControllerImpl class
        this.scanner = new Scanner(System.in);
    }


    @Override
    public void run() {
        while (true) {
            String result = null;
            try {
                result = processInput();

                if (result.equals(Command.Exit.name())) {
                    break;
                }
            } catch (NullPointerException | IllegalArgumentException | IOException e) {
                result = e.getMessage();
            }

            System.out.println(result);
        }

    }

    private String processInput() throws IOException {
        String input = this.scanner.nextLine();
        String[] tokens = input.split("\\s+");

        Command command = Command.valueOf(tokens[0]);
        String result = null;
        String[] data = Arrays.stream(tokens).skip(1).toArray(String[]::new);

        switch (command) {
            case AddDiver:
                result = addDiver(data);
                break;
            case AddDivingSite:
                result = addDivingSite(data);
                break;
            case RemoveDiver:
                result = removeDiver(data);
                break;
            case StartDiving:
                result = startDiving(data);
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


    private String addDiver(String[] data) {
        String diverType = data[0];
        String diverName = data[1];

        return this.controller.addDiver(diverType, diverName);
    }

    private String addDivingSite(String[] data) {

        String siteName = data[0];
        String[] seaCreature = Arrays.stream(data).skip(1).toArray(String[]::new);
        return this.controller.addDivingSite(siteName, seaCreature);
    }

    private String removeDiver(String[] data) {
        String diverName = data[0];
        return this.controller.removeDiver(diverName);
    }


    private String startDiving(String[] data) {
        String divingSiteName = data[0];
        return this.controller.startDiving(divingSiteName);
    }

    private String getStatistics() {

        return this.controller.getStatistics();
    }


}
