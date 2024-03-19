package WorkingWithAbstraction.exercise.TrafficLights;

public enum TrafficLight {
    GREEN, YELLOW, RED;


    public TrafficLight changeLight(TrafficLight trafficLight) {
        switch (trafficLight) {
            case GREEN:
                trafficLight = YELLOW;
                break;
            case YELLOW:
                trafficLight = RED;
                break;
            case RED:
                trafficLight = GREEN;
                break;
        }
        return trafficLight;
    }


}
