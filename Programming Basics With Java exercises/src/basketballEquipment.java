import java.util.Scanner;

public class basketballEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int taxForYear = Integer.parseInt(scanner.nextLine());

        double priceSneakers = taxForYear - (taxForYear * 1.0) * 40 / 100;
        double priceClothes = priceSneakers - priceSneakers * 20 / 100;
        double priceBall = priceClothes / 4;
        double priceAcc = priceBall / 5;
        double total = taxForYear + priceSneakers + priceClothes + priceBall + priceAcc;

        System.out.println(total);
    }
}
