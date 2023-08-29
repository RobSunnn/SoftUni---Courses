package fundamentals.P01.basicSyntax.lab;

import java.util.Scanner;

public class evenNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        while (true) {
            int currentNum = Integer.parseInt(scanner.nextLine());
            if (currentNum % 2 != 0) {
                System.out.println("Please write an even number.");
            } else {
                System.out.printf("The number is: %d", Math.abs(currentNum));
                break;
            }
        }
    }
}
