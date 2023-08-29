package basic.exams;

import java.util.Scanner;

public class seriesCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String nameSerial = scanner.nextLine();
        int seasons = Integer.parseInt(scanner.nextLine());
        int episodes = Integer.parseInt(scanner.nextLine());
        double timeOfEpisode = Double.parseDouble(scanner.nextLine());

        double episodeLength = timeOfEpisode + timeOfEpisode * 0.2;
        double extraTime = seasons * 10;
        double totalTime = episodeLength * episodes * seasons + extraTime;


        System.out.printf("Total time needed to watch the %s series is %.0f minutes.", nameSerial, totalTime);
    }
}
