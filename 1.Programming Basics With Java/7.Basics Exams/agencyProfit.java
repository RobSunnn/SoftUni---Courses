package basic.exams;

import java.util.Scanner;

public class agencyProfit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String company = scanner.nextLine();
        int adultTicketsCount = Integer.parseInt(scanner.nextLine());
        int kidTicketsCount = Integer.parseInt(scanner.nextLine());
        double ticketPrice = Double.parseDouble(scanner.nextLine());
        double tax = Double.parseDouble(scanner.nextLine());

        double priceKidTicket = ticketPrice * 0.3;
        double adultTicketPrice = ticketPrice + tax;
        double priceKidsTicketPlusTax = priceKidTicket + tax;
        double totalPrice = (adultTicketsCount * adultTicketPrice) + (kidTicketsCount * priceKidsTicketPlusTax);
        double profit = totalPrice * 0.2;

        System.out.printf("The profit of your agency from %s tickets is %.2f lv.", company, profit);
    }
}


