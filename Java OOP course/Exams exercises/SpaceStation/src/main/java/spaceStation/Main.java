package spaceStation;

import spaceStation.core.ControllerImpl;
import spaceStation.core.EngineImpl;


public class Main {
    public static void main(String[] args) {

        ControllerImpl controller = new ControllerImpl();

        EngineImpl engine = new EngineImpl(controller);
        engine.run();
    }
}
