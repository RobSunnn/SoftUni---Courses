package ForLoopExercise;

import java.util.Scanner;

public class Salary {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tabs = Integer.parseInt(scan.nextLine());
        int salary = Integer.parseInt(scan.nextLine());


        for (int i = 1; i <= tabs; i++) {
            String currentTab = scan.nextLine();

            switch (currentTab) {
                case "Facebook" -> salary -= 150;
                case "Instagram" -> salary -= 100;
                case "Reddit" -> salary -= 50;
            }

            if (salary <= 0) {
                System.out.println("You have lost your salary.");
                break;
            }
        }

        if (salary > 0) {
            System.out.println(salary);
        }

    }
}
