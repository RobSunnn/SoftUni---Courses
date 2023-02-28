package fundamentals.P01.basicSyntax.lab;

import java.util.Scanner;

public class monthPrinter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        byte number = Byte.parseByte(scanner.nextLine());
        String month = "";


        switch (number) {
            case 1:
                month = "January";
                break;
            case 2:
                month = "February";
                break;
            case 3:
                month = "March";
                break;
            case 4:
                month = "April";
                break;
            case 5:
                month = "May";
                break;
            case 6:
                month = "June";
                break;
            case 7:
                month = "July";
                break;
            case 8:
                month = "August";
                break;
            case 9:
                month = "September";
                break;
            case 10:
                month = "October";
                break;
            case 11:
                month = "November";
                break;
            case 12:
                month = "December";
                break;
            default:
                System.out.println("Error!");
                break;


        }
        System.out.println(month);
    }
}
