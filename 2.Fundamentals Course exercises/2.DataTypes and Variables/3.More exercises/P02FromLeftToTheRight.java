package fundamentals.P06.dataTypesAndVariables.MoreExercise;

import java.util.Scanner;

public class P02FromLeftToTheRight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {

            long leftNum = Long.parseLong(scanner.next());
            long rightNum = Long.parseLong(scanner.next());
            int sum = 0;

            if (leftNum > rightNum) {
                long numLeft = leftNum;

                while (numLeft != 0) {
                    sum += Math.abs(numLeft % 10);
                    numLeft = Math.abs(numLeft / 10);
                }
            } else {
                long numRight = rightNum;

                while (numRight != 0) {
                    sum += Math.abs(numRight % 10);

                    numRight = Math.abs(numRight / 10);
                }

            }
            System.out.println(Math.abs(sum));
        }
    }
}
