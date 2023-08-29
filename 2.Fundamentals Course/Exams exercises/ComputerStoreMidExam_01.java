package fundamentals.exams;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ComputerStoreMidExam_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        double totalTax = 0.0;
        double totalPrice = 0.0;
        double finalPrice = 0.0;

        while (!input.equals("special") && !input.equals("regular")) {

            double priceForAPart = Double.parseDouble(input);
            double tax = priceForAPart * 0.2;

            if (priceForAPart > 0) {
                totalPrice += priceForAPart;
                totalTax += tax;
            } else {
                System.out.println("Invalid price!");
            }

            input = scanner.nextLine();
        }
        if (input.equals("special")) {
            finalPrice = (totalPrice + totalTax) * 0.9;
        } else {
            finalPrice = totalPrice + totalTax;
        }

        if (finalPrice != 0) {

            System.out.println("Congratulations you've just bought a new computer!");
            System.out.printf("Price without taxes: %.2f$%n", totalPrice);
            System.out.printf("Taxes: %.2f$%n", totalTax);
            System.out.println("-----------");
            System.out.printf("Total price: %.2f$", finalPrice);

        } else {
            System.out.println("Invalid order!");
        }

    }

}
