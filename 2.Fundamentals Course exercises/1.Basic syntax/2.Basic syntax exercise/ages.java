package fundamentals.P02.basicSyntax.exercise;

import java.util.Scanner;

public class ages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int age = Integer.parseInt(scanner.nextLine());

        if (age >= 0 && age <= 2) {
            System.out.println("baby");
        } else if (age > 2 && age <= 13) {
            System.out.println("child");
        } else if (age > 13 && age <= 19) {
            System.out.println("teenager");
        } else if (age > 19 && age <= 65) {
            System.out.println("adult");
        } else if (age >= 66) {
            System.out.println("elder");
        }

    }
}
