package P09FunctionalProgramming.lab;

import java.util.Scanner;

public class P06FindEvensAndOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int start = Integer.parseInt(input[0]);
        int end = Integer.parseInt(input[1]);
        String command = scanner.nextLine();

        if (command.equals("odd")) {
            for (int i = start; i <= end; i++) {
                if (i % 2 != 0) {
                    System.out.print(i + " ");
                }
            }
        } else if (command.equals("even")) {
            for (int i = start; i <= end; i++) {
                if (i % 2 == 0) {
                    System.out.print(i + " ");
                }
            }
        }


    }
}
