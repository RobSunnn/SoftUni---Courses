package fundamentals.P02.basicSyntax.exercise;

import java.util.Scanner;

public class login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String username = scanner.nextLine();

        String passCode = "";
        int wrongPasswordsCount = 0;
        for (int i = username.length() - 1; i >= 0; i--) {
            passCode += String.valueOf(username.charAt(i));
        }

        String password = scanner.nextLine();

        while (!password.equals(passCode)) {
            wrongPasswordsCount++;

            if (wrongPasswordsCount == 4) {
                System.out.printf("User %s blocked!", username);
                break;
            }
            System.out.println("Incorrect password. Try again.");

            password = scanner.nextLine();

        }
        if (passCode.equals(password)) {
            System.out.printf("User %s logged in.", username);
        }
    }
}

