package basic.nestedLoops;

import java.util.Scanner;

public class trainTheTrainers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int teachers = Integer.parseInt(scanner.nextLine());

        double assessments = 0;
        int assessmentCounter = 0;
        double allAssessments = 0;
        boolean flag = false;

        String input = scanner.nextLine();

        while (!input.equals("Finish")) {

            for (int i = 1; i <= teachers; i++) {

                double assessment = Double.parseDouble(scanner.nextLine());
                allAssessments += assessment;
                assessments += assessment;
                assessmentCounter++;

                if (i == teachers) {
                    System.out.printf("%s - %.2f.%n", input, assessments / teachers);
                    assessments = 0;
                }
            }


            input = scanner.nextLine();

        }
        System.out.printf("Student's final assessment is %.2f.", allAssessments / assessmentCounter);
    }
}
