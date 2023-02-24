package basic.nestedLoops;

import java.util.Scanner;

public class specialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1111; i <= 9999; i++) {
            boolean isSpecial = false;
            int currentNum = i;

            while (currentNum > 0) {

                int currentNumToCheck = currentNum % 10;

                if (currentNumToCheck != 0) {
                    if (n % currentNumToCheck == 0) {
                        isSpecial = true;
                    } else {
                        isSpecial = false;
                        break;
                    }
                } else {
                    isSpecial = false;
                    break;
                }
                currentNum = currentNum / 10;
            }
            if (isSpecial) {
                System.out.print(i + " ");
            }

        }

    }
}
