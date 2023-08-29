package WhileLoopExercise;

import java.util.Scanner;

public class Cake {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int width = Integer.parseInt(scan.nextLine());
        int length = Integer.parseInt(scan.nextLine());

        int totalPieces = width * length;

        while (totalPieces >= 0) {

            String input = scan.nextLine();

            if (input.equals("STOP")) {
                break;
            }

            int currentPieces = Integer.parseInt(input);

            totalPieces -= currentPieces;
        }

        if (totalPieces > 0) {
            System.out.printf("%d pieces are left.", totalPieces);
        } else {
            System.out.printf("No more cake left! You need %d pieces more.", Math.abs(totalPieces));
        }

    }
}

