package fundamentals.P10.Methods.exercise;

import java.util.Scanner;

public class P01SmallestofThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstNumInput = Integer.parseInt(scanner.nextLine());
        int secondNumInput = Integer.parseInt(scanner.nextLine());
        int thirdNumInput = Integer.parseInt(scanner.nextLine());

        smallestOfThreeNumbers(firstNumInput, secondNumInput, thirdNumInput);


    }

    public static void smallestOfThreeNumbers(int firstNum, int secondNum, int thirdNum) {
        if (firstNum <= secondNum && firstNum <= thirdNum) {
            System.out.println(firstNum);
        } else if (secondNum <= firstNum && secondNum <= thirdNum) {
            System.out.println(secondNum);
        } else {
            System.out.println(thirdNum);
        }
    }
}