package More.Exercise.Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class P03RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int num = Integer.parseInt(scanner.nextLine());
        int[] numArr = new int[num];

        if (num >= 3) {

            numArr[0] = 1;
            numArr[1] = 1;
            numArr[2] = 2;

            for (int i = 3; i <= numArr.length - 1; i++) {

                numArr[i] = numArr[i - 2] + numArr[i - 1];
            }

        } else {
            Arrays.fill(numArr, 1);
        }
        System.out.println(numArr[numArr.length - 1]);
    }
}
