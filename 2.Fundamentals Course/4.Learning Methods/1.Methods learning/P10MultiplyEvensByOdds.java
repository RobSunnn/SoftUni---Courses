package fundamentals.P09.Methods.lab;

import java.util.Scanner;

public class P10MultiplyEvensByOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberInput = Integer.parseInt(scanner.nextLine());
        System.out.println(getMultiplyOfEvenAndOdds(numberInput));

    }

    public static int getMultiplyOfEvenAndOdds(int number) {

        int evenSum = getEvenSum(number);
        int oddSum = getOddSum(number);

        return evenSum * oddSum;
    }

    public static int getEvenSum(int number) {
        int evenSum = 0;
        while (number != 0) {
            int currentNum = number % 10;
            if (currentNum % 2 == 0) {
                evenSum += currentNum;
            }
            number = number / 10;
        }
        return evenSum;
    }

    public static int getOddSum(int number) {
        int oddSum = 0;
        while (number != 0) {
            int currentNum = number % 10;
            if (currentNum % 2 != 0) {
                oddSum += currentNum;
            }
            number = number / 10;
        }
        return oddSum;
    }

}
