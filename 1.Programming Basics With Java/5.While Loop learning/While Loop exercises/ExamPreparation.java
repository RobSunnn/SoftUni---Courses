package WhileLoopExercise;

import java.util.Scanner;

public class ExamPreparation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int failedThreshold = Integer.parseInt(scan.nextLine());

        int failedTimes = 0;
        int problemsSolved = 0;
        double gradesSum = 0;

        String lastProblem = "";
        boolean isFailed = true;

        while (failedTimes < failedThreshold) {

            String problemName = scan.nextLine();

            if ("Enough".equals(problemName)) {
                isFailed = false;
                break;
            }
            int grade = Integer.parseInt(scan.nextLine());

            if (grade <= 4) {
                failedTimes++;
            }

            gradesSum += grade;
            problemsSolved++;
            lastProblem = problemName;


        }

        if (isFailed) {
            System.out.printf("You need a break, %d poor grades.", failedThreshold);
        } else {
            System.out.printf("Average score: %.2f%n", gradesSum / problemsSolved);
            System.out.printf("Number of problems: %d%n", problemsSolved);
            System.out.printf("Last problem: %s", lastProblem);
        }

    }
}
