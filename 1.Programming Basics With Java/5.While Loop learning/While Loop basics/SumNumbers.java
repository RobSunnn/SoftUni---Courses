package WhileLoopLab;

import java.util.Scanner;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        int sum = 0;

        while (sum < n) {

            int currentNum = Integer.parseInt(scan.nextLine());

            sum += currentNum;
        }
        System.out.println(sum);
    }
}
