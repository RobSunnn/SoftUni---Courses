package fundamentals.P02.basicSyntax.exercise;

import java.util.Scanner;

public class padawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int studentsCount = Integer.parseInt(scanner.nextLine());
        double singleLightSaberPrice = Double.parseDouble(scanner.nextLine());
        double singleRobePrice = Double.parseDouble(scanner.nextLine());
        double singleBeltPrice = Double.parseDouble(scanner.nextLine());

        int freeBelts = 0;

        for (int i = 1; i <= studentsCount; i++) {
            if (i % 6 == 0) {
                freeBelts++;
            }
        }

        double totalLightSabersPrice = singleLightSaberPrice * Math.ceil(studentsCount + studentsCount * 0.10);
        double totalRobePrice = singleRobePrice * studentsCount;
        double totalBeltPrice = singleBeltPrice * (studentsCount - freeBelts);
        double totalPrice = totalLightSabersPrice + totalRobePrice + totalBeltPrice;
        if (totalPrice <= budget) {
            System.out.printf("The money is enough - it would cost %.2flv.", totalPrice);
        } else {
            System.out.printf("George Lucas will need %.2flv more.", totalPrice - budget);
        }


    }
}
