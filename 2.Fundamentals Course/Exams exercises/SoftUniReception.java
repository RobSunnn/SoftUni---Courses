package fundamentals.exams;

import java.util.Scanner;

public class SoftUniReception {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstEmployeeEfficiency = Integer.parseInt(scanner.nextLine());
        int secondEmployeeEfficiency = Integer.parseInt(scanner.nextLine());
        int thirdEmployeeEfficiency = Integer.parseInt(scanner.nextLine());
        int totalAnsweredQuestionsPerHour = firstEmployeeEfficiency + secondEmployeeEfficiency + thirdEmployeeEfficiency;
        int studentsCount = Integer.parseInt(scanner.nextLine());
        int hoursCount = 0;

        while (studentsCount > 0) {
            studentsCount = studentsCount - totalAnsweredQuestionsPerHour;
            hoursCount++;
            if (hoursCount % 4 == 0) {
                hoursCount++;
            }

        }
        System.out.printf("Time needed: %dh.", hoursCount);
    }
}
