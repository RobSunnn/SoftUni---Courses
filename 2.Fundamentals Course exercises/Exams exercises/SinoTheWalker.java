package fundamentals.exams;

import java.math.BigInteger;
import java.util.Scanner;

public class SinoTheWalker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] leavingTime = scanner.nextLine().split(":");
        BigInteger steps = BigInteger.valueOf(Integer.parseInt(scanner.nextLine()));
        BigInteger timeForAStep = BigInteger.valueOf(Integer.parseInt(scanner.nextLine()));

        int hours = Integer.parseInt(leavingTime[0]);
        int minutes = Integer.parseInt(leavingTime[1]);
        int seconds = Integer.parseInt(leavingTime[2]);
        BigInteger totalTimeNeededToGoHome = steps.multiply(timeForAStep);
        int allSeconds = (hours * 60 * 60) + (minutes * 60) + seconds;
        BigInteger allSecondsPlus = totalTimeNeededToGoHome.add(BigInteger.valueOf(allSeconds));

        BigInteger[] hoursToPrint = (allSecondsPlus.divide(BigInteger.valueOf(3600)))
                .divideAndRemainder(BigInteger.valueOf(24));
        BigInteger[] minutesToPrint = (allSecondsPlus.divide(BigInteger.valueOf(60)))
                .divideAndRemainder(BigInteger.valueOf(60));
        BigInteger[] secondsToPrint = allSecondsPlus.divideAndRemainder(BigInteger.valueOf(60));


        if (hoursToPrint[1].intValue() < 10 || minutesToPrint[1].intValue() < 10 || secondsToPrint[1].intValue() < 10) {

            System.out.printf("Time Arrival: %02d:%02d:%02d", hoursToPrint[1], minutesToPrint[1], secondsToPrint[1]);
        } else {

            System.out.printf("Time Arrival: %d:%d:%d", hoursToPrint[1], minutesToPrint[1], secondsToPrint[1]);
        }


    }
}
