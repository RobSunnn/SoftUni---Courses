package fundamentals.P05.dataTypesAndVariables.Exercise;

import java.util.Scanner;

public class P11Snowballs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        long highestSnowBall = Integer.MIN_VALUE;
        int snowBallSnowMax = 0;
        int snowBallTimeMax = 1;
        int snowBallQualityMax = 0;

        for (int i = 1; i <= n; i++) {
            int snowBallSnow = Short.parseShort(scanner.nextLine());
            int snowBallTime = Short.parseShort(scanner.nextLine());
            int snowBallQuality = Byte.parseByte(scanner.nextLine());

            long snowBallValue = (long) Math.pow(snowBallSnow * 1.0 / snowBallTime, snowBallQuality);

            if (snowBallValue > highestSnowBall) {
                highestSnowBall = snowBallValue;
                snowBallSnowMax = snowBallSnow;
                snowBallTimeMax = snowBallTime;
                snowBallQualityMax = snowBallQuality;
            }
        }
        System.out.printf("%d : %d = %d (%d)", snowBallSnowMax, snowBallTimeMax, highestSnowBall, snowBallQualityMax);


    }
}
