package basic.nestedLoops;

import java.util.Scanner;

public class sumOfTwoNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n1 = Integer.parseInt(scanner.nextLine());
        int n2 = Integer.parseInt(scanner.nextLine());
        int magicN = Integer.parseInt(scanner.nextLine());

        int counter = 0;
        boolean flag = false;

        for (int i = n1; i <= n2; i++) {
            for (int j = n1; j <= n2; j++) {
                counter++;

                if (i + j == magicN) {
                    System.out.printf("Combination N:%d (%d + %d = %d)", counter, i, j, magicN);
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }
        if (!flag) {
            System.out.printf("%d combinations - neither equals %d", counter, magicN);
        }
    }
}
