package fundamentals.P02.basicSyntax.exercise;

import java.util.Scanner;

public class vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int groupCount = Integer.parseInt(scanner.nextLine());
        String groupType = scanner.nextLine();
        String day = scanner.nextLine();
        double price = 0;

        switch (groupType) {
            case "Students":
                switch (day) {
                    case "Friday":
                        price = 8.45;
                        break;
                    case "Saturday":
                        price = 9.80;
                        break;
                    case "Sunday":
                        price = 10.46;
                        break;
                }
                break;
            case "Business":
                switch (day) {
                    case "Friday":
                        price = 10.90;
                        break;
                    case "Saturday":
                        price = 15.60;
                        break;
                    case "Sunday":
                        price = 16;
                        break;
                }
                break;
            case "Regular":
                switch (day) {
                    case "Friday":
                        price = 15;
                        break;
                    case "Saturday":
                        price = 20;
                        break;
                    case "Sunday":
                        price = 22.50;
                        break;
                }
                break;
        }
        double totalPrice = price * groupCount;
        if (groupType.equals("Students")) {
            if (groupCount >= 30) {
                totalPrice = totalPrice - totalPrice * 0.15;
            }
        }
        if (groupType.equals("Business")) {
            if (groupCount >= 100) {
                double stayForFree = price * 10;
                totalPrice = totalPrice - stayForFree;
            }
        }
        if (groupType.equals("Regular")) {
            if (groupCount >= 10 && groupCount <= 20) {
                totalPrice = totalPrice - totalPrice * 0.05;
            }
        }


        System.out.printf("Total price: %.2f", totalPrice);
    }
}
