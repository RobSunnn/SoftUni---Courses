package basic.nestedLoops;

import java.util.Scanner;

public class numberPyramid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int counter = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {

                counter++;

                System.out.print(counter + " ");

                if (counter == n) {
                    break;
                }
            }
            if (counter == n) {
                break;
            }

            System.out.println();
        }
    }
}
