package harpoonDiver;

import harpoonDiver.core.Controller;
import harpoonDiver.core.ControllerImpl;
import harpoonDiver.core.Engine;
import harpoonDiver.core.EngineImpl;

public class Main {

    public static void main(String[] args) {
        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}
