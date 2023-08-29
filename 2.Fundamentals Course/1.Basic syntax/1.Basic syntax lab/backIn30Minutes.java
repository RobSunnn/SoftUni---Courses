package fundamentals.P01.basicSyntax.lab;

import java.util.Scanner;

public class backIn30Minutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hours = Integer.parseInt(scanner.nextLine());
        int minutes = Integer.parseInt(scanner.nextLine()) + 30;
        int totalMin = (hours * 60) + minutes;
        int realHour = totalMin / 60;
        int realMin = totalMin % 60;

        if (realMin >= 60) {
            realHour += 1;
            realMin = 0;
        }
        if (realHour >= 24) {
            realHour = 0;
        }

        System.out.printf("%d:%02d", realHour, realMin);
    }
}
