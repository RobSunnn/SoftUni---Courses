package basic.exams;

import java.util.Scanner;

public class aluminumJoinery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int joinery = Integer.parseInt(scanner.nextLine());
        String typeJoinery = scanner.nextLine();
        String typeDelivery = scanner.nextLine();

        double price = 0;
        double totalPrice = 0;

        if (joinery < 10) {
            System.out.println("Invalid order");
            return;
        }

        if (typeJoinery.equals("90X130")) {
            price = 110 * joinery;

            if (joinery > 30 && joinery <= 59) {
                price = price - price * 0.05;
            } else if (joinery > 60) {
                price = price - price * 0.08;
            }
        } else if (typeJoinery.equals("100X150")) {
            price = 140 * joinery;

            if (joinery > 40 && joinery <= 79) {
                price = price - price * 0.06;
            } else if (joinery > 80) {
                price = price - price * 0.1;
            }
        } else if (typeJoinery.equals("130X180")) {
            price = 190 * joinery;

            if (joinery > 20 && joinery <= 49) {
                price = price - price * 0.07;
            } else if (joinery > 50) {
                price = price - price * 0.12;
            }
        } else {
            price = 250 * joinery;

            if (joinery > 25 && joinery <= 49) {
                price = price - price * 0.09;
            } else if (joinery > 50) {
                price = price - price * 0.14;
            }
        }

        if (typeDelivery.equals("With delivery")) {
            price = price + 60;
        }

        totalPrice = price;

        if (joinery >= 100) {
            totalPrice = totalPrice - totalPrice * 0.04;
        }

        System.out.printf("%.2f BGN", totalPrice);
    }
}