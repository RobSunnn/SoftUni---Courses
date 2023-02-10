import java.util.Scanner;

public class yardGreening {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double yard = Double.parseDouble(scanner.nextLine());

        double priceWholeYard = yard * 7.61;
        double discount = 0.18 * priceWholeYard;
        double totalPrice = priceWholeYard - discount;

        System.out.printf("The final price is: %.2f lv.%n", totalPrice);
        System.out.printf("The discount is: %.2f lv.", discount);

    }
}
