package FirstSteps;

import java.util.Scanner;

public class PetShop {
    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);
        int dogPackages = Integer.parseInt(scan.nextLine());
        int catPackages = Integer.parseInt(scan.nextLine());
        double priceDog=dogPackages*2.50;
        double priceCat=catPackages*4;
        double totalPrice=priceCat+priceDog;

        System.out.printf("%f lv.",totalPrice);

    }
}
