package fundamentals.P10.Methods.exercise;

import java.util.Scanner;

public class P04PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String passwordInput = scanner.nextLine();


        if (!isValidLengthOfPassword(passwordInput)) {
            System.out.println("Password must be between 6 and 10 characters");
        }

        if (!isValidLettersAndDigits(passwordInput)) {
            System.out.println("Password must consist only of letters and digits");
        }

        if (!isValidCountDigits(passwordInput)) {
            System.out.println("Password must have at least 2 digits");
        } else if (isValidLengthOfPassword(passwordInput) && isValidLettersAndDigits(passwordInput) && isValidCountDigits(passwordInput)) {
            System.out.println("Password is valid");
        }

    }

    private static boolean isValidLengthOfPassword(String password) {
        return password.length() >= 6 && password.length() <= 10;
    }

    private static boolean isValidLettersAndDigits(String password) {
        for (char symbol : password.toCharArray()) {
            if (!Character.isLetterOrDigit(symbol)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidCountDigits(String password) {
        int countDigits = 0;
        for (char symbol : password.toCharArray()) {
            if (Character.isDigit(symbol)) {
                countDigits++;
            }
        }
        return countDigits >= 2;
    }
}