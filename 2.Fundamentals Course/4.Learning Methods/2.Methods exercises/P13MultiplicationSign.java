package fundamentals.P10.Methods.exercise;

import java.util.Scanner;

public class P13MultiplicationSign {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());
        int thirdNum = Integer.parseInt(scanner.nextLine());

        System.out.println(multiplicationSign(firstNum, secondNum, thirdNum));


    }

    public static String multiplicationSign(int num, int number, int numb) {
        String result = "";

        if (num < 0 || number < 0 || numb < 0) {
            result = "negative";
        } else if (num == 0 || number == 0 || numb == 0) {
            result = "zero";
        }
        if (num > 0 && number > 0 && numb > 0 ||
                num > 0 && number < 0 && numb < 0 ||
                num < 0 && number < 0 && numb > 0 ||
                num < 0 && number > 0 && numb < 0) {
            result = "positive";
        }

        return result;
    }
}
