package fundamentals.P06.dataTypesAndVariables.MoreExercise;

import java.util.Scanner;

public class P06BalancedBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int openCount = 0;
        int closedCount = 0;

        for (int i = 1; i <= n; i++) {
            String input = scanner.nextLine();

            if (input.equals("(")) {
                openCount++;

            } else if (input.equals(")")) {

                closedCount++;

                if (openCount - closedCount != 0) {
                    System.out.println("UNBALANCED");
                    return;
                }
            }


        }

        if (openCount == closedCount) {
            System.out.println("BALANCED");
        } else {
            System.out.println("UNBALANCED");
        }
    }
}
