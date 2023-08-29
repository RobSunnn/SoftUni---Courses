package fundamentals.exams;

import java.util.Scanner;

public class CounterStrike {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int initialEnergy = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        int counter = 0;
        boolean isWon = true;

        while (!input.equals("End of battle")) {

            int energyForTheWin = Integer.parseInt(input);

            if (initialEnergy < energyForTheWin) {
                isWon = false;
                System.out.printf("Not enough energy! Game ends with %d won battles and %d energy%n", counter, initialEnergy);
                break;
            }


            initialEnergy -= energyForTheWin;
            counter++;

            if (counter % 3 == 0) {
                initialEnergy += counter;
            }


            input = scanner.nextLine();
        }
        if (isWon) {
            System.out.printf("Won battles: %d. Energy left: %d%n", counter, initialEnergy);
        }
    }
}
