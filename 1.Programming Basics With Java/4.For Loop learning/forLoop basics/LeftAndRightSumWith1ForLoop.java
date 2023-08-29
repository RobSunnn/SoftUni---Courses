package ForLoopLab;

import java.util.Scanner;

public class LeftAndRightSumWith1ForLoop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int leftSum = 0;
        int rightSum = 0;

        for (int i = 1; i <= 2 * n; i++) {
            int num = Integer.parseInt(scan.nextLine());

            if (i == n || i < n) {

                leftSum += num;
            } else {
                rightSum += num;
            }

        }

        if (leftSum == rightSum) {
            System.out.printf("Yes, sum = %d", leftSum);
        } else {
            System.out.printf("No, diff = %d", Math.abs(leftSum - rightSum));
        }

    }
}
