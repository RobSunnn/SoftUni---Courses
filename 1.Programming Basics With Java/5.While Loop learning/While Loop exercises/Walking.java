package WhileLoopExercise;

import java.util.Scanner;

public class Walking {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int goal = 10000;
        int reachedSteps = 0;
        String input = scan.nextLine();

        while (!input.equals("Going home")) {

            int steps = Integer.parseInt(input);
            reachedSteps += steps;

            if (reachedSteps >= goal) {
                break;
            }

            input = scan.nextLine();
        }

        if (input.equals("Going home")) {
            int stepsToHome = Integer.parseInt(scan.nextLine());
            reachedSteps += stepsToHome;
        }
        if (reachedSteps >= goal) {
            System.out.println("Goal reached! Good job!");
            System.out.printf("%d steps over the goal!", reachedSteps - goal);
        } else {
            System.out.printf("%d more steps to reach goal.", goal - reachedSteps);
        }

    }

}
