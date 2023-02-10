import java.util.Scanner;

public class foodDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double chickenMenu = Double.parseDouble(scanner.nextLine()) * 10.35;
        double fishMenu = Double.parseDouble(scanner.nextLine()) * 12.40;
        double veggieMenu = Double.parseDouble(scanner.nextLine()) * 8.15;

        double totalPrice = chickenMenu + fishMenu + veggieMenu;
        double priceDesert = totalPrice * 20 / 100;
        double priceDelivery = 2.50;

        double totalPriceEverything = totalPrice + priceDesert + priceDelivery;

        System.out.println(totalPriceEverything);

    }
}
