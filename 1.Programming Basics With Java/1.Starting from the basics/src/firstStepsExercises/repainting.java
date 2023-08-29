import java.util.Scanner;

public class repainting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nylon = Integer.parseInt(scanner.nextLine());
        int paint = Integer.parseInt(scanner.nextLine());
        int thinner = Integer.parseInt(scanner.nextLine());
        int hoursOfWork = Integer.parseInt(scanner.nextLine());

        double priceNylon = nylon * 1.50 + 3;
        double pricePaint = paint * 14.50;
        double totalPaint = pricePaint + pricePaint * 10 / 100;
        double priceThinner = thinner * 5.00;
        double priceBags = 0.40;

        double totalPrice = priceNylon + totalPaint + priceThinner + priceBags;
        double priceWorkers = (totalPrice * 30 / 100) * hoursOfWork;
        double endPrice = totalPrice + priceWorkers;

        System.out.println(endPrice);
    }
}
