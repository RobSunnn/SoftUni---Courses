package basic.exams;

import java.util.Scanner;

public class movieProfit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String movie = scanner.nextLine();
        int days = Integer.parseInt(scanner.nextLine());
        int tickets = Integer.parseInt(scanner.nextLine());
        double priceTicket = Double.parseDouble(scanner.nextLine());
        int percentForCinema = Integer.parseInt(scanner.nextLine());

        double priceForADay = tickets * priceTicket;
        double totalForPeriod = days * priceForADay;
        double percent = totalForPeriod * percentForCinema / 100;
        double totalProfit = totalForPeriod - percent;

        System.out.printf("The profit from the movie %s is %.2f lv.", movie, totalProfit);
    }
}
