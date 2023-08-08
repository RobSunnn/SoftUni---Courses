package Abstraction.exercise.TrafficLights;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] trafficLights = scanner.nextLine().split(" ");
        int countTimesToChangeLight = Integer.parseInt(scanner.nextLine());

        for (int countTimes = 0; countTimes < countTimesToChangeLight; countTimes++) {

            for (int i = 0; i < trafficLights.length; i++) {

                TrafficLight currentLight = TrafficLight.valueOf(trafficLights[i]);

                trafficLights[i] = String.valueOf(currentLight.changeLight(currentLight));
                System.out.print(trafficLights[i] + " ");
            }
            System.out.println();
        }






    }
}
