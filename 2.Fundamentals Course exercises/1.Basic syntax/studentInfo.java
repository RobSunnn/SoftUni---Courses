package fundamentals.P01.basicSyntax.lab;

import java.util.Scanner;

public class studentInfo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String studentName = scanner.nextLine();
        byte age = Byte.parseByte(scanner.nextLine());
        double grade = Double.parseDouble(scanner.nextLine());

        System.out.printf("Name: %s, Age: %d, Grade: %.2f", studentName, age, grade);
    }
}
