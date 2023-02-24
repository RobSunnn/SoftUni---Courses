package basic.nestedLoops;

import java.util.Scanner;

public class cinemaTickets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int student = 0;
        int kid = 0;
        int standard = 0;
        int tickets = 0;
        boolean flag = false;
        int totalTickets = 0;

        while (!input.equals("Finish")) {
            int freeSpace = Integer.parseInt(scanner.nextLine());

            for (int i = 1; i <= freeSpace; i++) {
                String typeOfTicket = scanner.nextLine();


                switch (typeOfTicket) {
                    case "student":
                        student++;
                        break;
                    case "standard":
                        standard++;
                        break;
                    case "kid":
                        kid++;
                        break;
                }
                if (typeOfTicket.equals("End")) {
                    flag = true;
                    break;
                }
                totalTickets++;
                tickets++;


            }

            System.out.printf("%s - %.2f%% full.%n", input, tickets * 1.0 / freeSpace * 100);

            tickets = 0;
            input = scanner.nextLine();

            if (input.equals("Finish")) {
                System.out.printf("Total tickets: %d%n", totalTickets);
                System.out.printf("%.2f%% student tickets.%n", student * 1.0 / totalTickets * 100);
                System.out.printf("%.2f%% standard tickets.%n", standard * 1.0 / totalTickets * 100);
                System.out.printf("%.2f%% kids tickets.", kid * 1.0 / totalTickets * 100);
            }
        }

    }
}
