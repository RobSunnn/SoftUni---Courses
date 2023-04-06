package fundamentals.exams;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class HeartDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] neighborhood = Arrays.stream(scanner.nextLine().split("@")).mapToInt(Integer::parseInt).toArray();

        String input = scanner.nextLine();
        int lastPosition = 0;

        while (!input.equals("Love!")) {
            int jumpLength = Integer.parseInt(input.split(" ")[1]);
            lastPosition += jumpLength;

            if (lastPosition >= neighborhood.length) {
                lastPosition = 0;
            }

            neighborhood[lastPosition] = neighborhood[lastPosition] - 2;

            if (neighborhood[lastPosition] == 0) {
                System.out.printf("Place %d has Valentine's day.%n", lastPosition);
            }
            if (neighborhood[lastPosition] < 0) {
                System.out.printf("Place %d already had Valentine's day.%n", lastPosition);
            }

            input = scanner.nextLine();
        }

        int houseFailed = 0;
        System.out.printf("Cupid's last position was %d.%n", lastPosition);

        for (int i = 0; i < neighborhood.length; i++) {
            if (neighborhood[i] > 0) {
                houseFailed++;
            }
        }
        if (houseFailed > 0) {
            System.out.printf("Cupid has failed %d places.%n", houseFailed);
        } else {
            System.out.println("Mission was successful.");
        }
    }


}
