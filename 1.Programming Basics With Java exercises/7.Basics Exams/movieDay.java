package basic.exams;

import java.util.Scanner;

public class movieDay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int timeForProduction = Integer.parseInt(scanner.nextLine());
        int scenesCount = Integer.parseInt(scanner.nextLine());
        int sceneTime = Integer.parseInt(scanner.nextLine());

        double timePreparation = timeForProduction * 0.15;
        double totalTimeForPictures = scenesCount * sceneTime;
        double totalTime = timePreparation + totalTimeForPictures;

        if (totalTime <= timeForProduction) {
            System.out.printf("You managed to finish the movie on time! You have %d minutes left!", Math.round(timeForProduction - totalTime));
        } else {
            System.out.printf("Time is up! To complete the movie you need %d minutes.", Math.round(totalTime - timeForProduction));
        }

    }
}
