package fundamentals.P05.dataTypesAndVariables.Exercise;

import java.util.Scanner;

public class P10Pokemon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int n1 = n;
        int m = Integer.parseInt(scanner.nextLine());
        byte y = Byte.parseByte(scanner.nextLine());
        int pokesCount = 0;

        while (n >= m) {

            n = n - m;
            pokesCount++;

            if (n == n1 * 50 / 100) {
                n = n / y;
            }
            if (m > n) {
                break;
            }

        }

        System.out.println(n);
        System.out.println(pokesCount);
    }

}
