package ConditionalStatementAdvancedLab;

import java.util.Scanner;

public class CinemaTicket {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int price = 0;

        String day = scan.nextLine();
        switch (day) {
            case "Monday":
            case "Tuesday":
            case "Friday":
                price = 12;
                break;

            case "Wednesday":
            case "Thursday":
                price = 14;
                break;

            case "Saturday":
            case "Sunday":
                price = 16;
                break;
        }

        System.out.println(price);
    }
}
