import java.util.Scanner;

public class suppliesForSchool {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int packWithPens = Integer.parseInt(scanner.nextLine());
        int packWithMarker = Integer.parseInt(scanner.nextLine());
        int litersOfDetergent = Integer.parseInt(scanner.nextLine());
        int discount = Integer.parseInt(scanner.nextLine());

        double pricePens = packWithPens * 5.80;
        double priceMarkers = packWithMarker * 7.20;
        double priceDetergent = litersOfDetergent * 1.20;

        double totalPrice = pricePens + priceMarkers + priceDetergent;

        double totalPriceWithDiscount = totalPrice - totalPrice * discount / 100;

        System.out.println(totalPriceWithDiscount);

    }
}
