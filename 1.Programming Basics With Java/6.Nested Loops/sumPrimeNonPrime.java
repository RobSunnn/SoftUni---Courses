package basic.nestedLoops;

import java.util.Scanner;

public class sumPrimeNonPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int primeNumSum = 0;
        int nonPrimeNumSum = 0;

        String input = scanner.nextLine();
        while (!input.equals("stop")) {

            int num = Integer.parseInt(input);

            if (num < 0) {
                System.out.println("Number is negative.");
                input = scanner.nextLine();
                continue;
            }

            boolean flag = true;

            for (int i = 2; i <= num - 1; i++) {
                if (num % i == 0) {
                    nonPrimeNumSum += num;
                    flag = false;
                    break;
                }


            }
            if (flag) {
                primeNumSum += num;
            }


            input = scanner.nextLine();
        }

        System.out.printf("Sum of all prime numbers is: %d%n", primeNumSum);
        System.out.printf("Sum of all non prime numbers is: %d", nonPrimeNumSum);
    }

}
