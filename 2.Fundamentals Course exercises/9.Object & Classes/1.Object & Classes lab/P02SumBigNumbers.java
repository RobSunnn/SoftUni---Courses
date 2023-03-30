package fundamentals.P18.ObjectsAndClasses;

import java.math.BigInteger;
import java.util.Scanner;

public class P02SumBigNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigInteger firstNum = new BigInteger(scanner.nextLine());
        BigInteger secondNum = new BigInteger(scanner.nextLine());
        BigInteger result = firstNum.add(secondNum);

        System.out.println(result);
    }
}
