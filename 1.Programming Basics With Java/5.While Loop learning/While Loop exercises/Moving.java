package WhileLoopExercise;

import java.util.Scanner;

public class Moving {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int width = Integer.parseInt(scan.nextLine());
        int length = Integer.parseInt(scan.nextLine());
        int height = Integer.parseInt(scan.nextLine());

        int totalSpace = width * length * height;


        while (totalSpace > 0) {

            String input = scan.nextLine();

            if (input.equals("Done")) {
                break;
            }

            int boxes = Integer.parseInt(input);

            totalSpace -= boxes;

            if (totalSpace <= 0) {
                break;
            }


        }

        if (totalSpace > 0) {
            System.out.printf("%d Cubic meters left.", totalSpace);
        } else {
            System.out.printf("No more free space! You need %d Cubic meters more.", Math.abs(totalSpace));
        }

    }
}
