package fundamentals.exams;

import java.util.Scanner;

public class BonusScoring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countStudents = Integer.parseInt(scanner.nextLine());
        int lectures = Integer.parseInt(scanner.nextLine());
        int additionalBonus = Integer.parseInt(scanner.nextLine());
        double maxBonus = Double.MIN_VALUE;
        double bonus = 0;
        int maxLectures = 0;

        for (int i = 0; i < countStudents; i++) {
            int attendances = Integer.parseInt(scanner.nextLine());
            bonus = attendances * 1.0 / lectures * (5 + additionalBonus);
            if (bonus > maxBonus) {
                maxBonus = bonus;
                maxLectures = attendances;
            }
        }
        System.out.printf("Max Bonus: %d.%n", Math.round(maxBonus));
        System.out.printf("The student has attended %d lectures.", maxLectures);
    }
}
