package fundamentals.P03.basicSyntax.moreExercise;

import java.util.Scanner;

public class englishNameOfLastDigit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        int currentN = n % 10;

        if (currentN == 1) {
            System.out.println("one");
        } else if (currentN == 2) {
            System.out.println("two");
        } else if (currentN == 3) {
            System.out.println("three");
        } else if (currentN == 4) {
            System.out.println("four");
        } else if (currentN == 5) {
            System.out.println("five");
        } else if (currentN == 6) {
            System.out.println("six");
        } else if (currentN == 7) {
            System.out.println("seven");
        } else if (currentN == 8) {
            System.out.println("eight");
        } else if (currentN == 9) {
            System.out.println("nine");
        } else {
            System.out.println("zero");
        }
    }
}
