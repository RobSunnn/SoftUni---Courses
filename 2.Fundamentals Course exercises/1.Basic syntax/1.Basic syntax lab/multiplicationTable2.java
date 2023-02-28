package fundamentals.P01.basicSyntax.lab;

import java.util.Scanner;

public class multiplicationTable2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int multiplier = Integer.parseInt(scanner.nextLine());

        int result = n * multiplier;

        if (multiplier > 10) {
            System.out.printf("%d X %d = %d", n, multiplier, result);

        }
        for (int i = multiplier; i <= 10; i++) {
            System.out.printf("%d X %d = %d%n", n, i, n * i);
        }
    }
}
