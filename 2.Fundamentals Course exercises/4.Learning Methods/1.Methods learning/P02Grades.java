package fundamentals.P09.Methods.lab;

import java.util.Scanner;

public class P02Grades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double gradeInput = Double.parseDouble(scanner.nextLine());

        printGrade(gradeInput);

    }

    public static void printGrade(double grade) {
        if (grade >= 2 && grade <= 2.99) {
            System.out.println("Fail");
        } else if (grade >= 3 && grade <= 3.49) {
            System.out.println("Poor");
        } else if (grade >= 3.50 && grade <= 4.49) {
            System.out.println("Good");
        } else if (grade >= 4.50 && grade <= 5.49) {
            System.out.println("Very good");
        } else if (grade >= 5.50 && grade <= 6) {
            System.out.println("Excellent");
        }
    }
}
