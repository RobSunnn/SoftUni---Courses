package fundamentals.P09.Methods.lab;

import java.util.Scanner;

public class P09GreaterOfTwoValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String commandInput = scanner.nextLine();


        switch (commandInput) {
            case "int":
                int firstValue = Integer.parseInt(scanner.nextLine());
                int secondValue = Integer.parseInt(scanner.nextLine());
                System.out.println(getMax(firstValue, secondValue));
                break;
            case "char":
                char firstInput = scanner.nextLine().charAt(0);
                char secondInput = scanner.nextLine().charAt(0);
                System.out.println(getMax(firstInput, secondInput));
                break;
            case "string":
                String firstString = scanner.nextLine();
                String secondString = scanner.nextLine();
                System.out.println(getMax(firstString, secondString));
                break;
        }

    }

    public static int getMax(int firstNum, int secondNum) {
        if (firstNum > secondNum) {
            return firstNum;
        } else {
            return secondNum;
        }
    }

    public static char getMax(char first, char second) {
        if (first > second) {
            return first;
        } else {
            return second;
        }
    }

    public static String getMax(String first, String second) {
        if (first.compareTo(second) >= 0) {
            return first;
        } else {
            return second;
        }
    }
}
