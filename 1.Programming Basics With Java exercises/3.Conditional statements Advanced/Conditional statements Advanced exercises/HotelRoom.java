package ConditionalStatementsAdvancedExercise;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.util.Scanner;

public class HotelRoom {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String month = scan.nextLine();
        int nightsCount = Integer.parseInt(scan.nextLine());

        double price = 0.0;

        double studioPrice = 0;
        double apartPrice = 0;
        double totalPriceStudio = 0;
        double totalPriceApart = 0;

        if (month.equals("May") || month.equals("October")) {

            studioPrice = 50;
            apartPrice = 65;

            totalPriceStudio = studioPrice * nightsCount;
            totalPriceApart = apartPrice * nightsCount;

            if (nightsCount > 7 && nightsCount < 14) {
                totalPriceStudio = totalPriceStudio - totalPriceStudio * 0.05;
            }

            if (nightsCount > 14) {
                totalPriceStudio = totalPriceStudio - totalPriceStudio * 0.3;
                totalPriceApart = totalPriceApart - totalPriceApart * 0.1;
            }
        }

        if (month.equals("June") || month.equals("September")) {

            studioPrice = 75.20;
            apartPrice = 68.70;

            totalPriceStudio = studioPrice * nightsCount;
            totalPriceApart = apartPrice * nightsCount;

            if (nightsCount > 14) {
                totalPriceStudio = totalPriceStudio - totalPriceStudio * 0.2;
                totalPriceApart = totalPriceApart - totalPriceApart * 0.1;
            }
        }

        if (month.equals("July") || month.equals("August")) {

            studioPrice = 76;
            apartPrice = 77;

            totalPriceStudio = studioPrice * nightsCount;
            totalPriceApart = apartPrice * nightsCount;

            if (nightsCount > 14) {
                totalPriceApart = totalPriceApart - totalPriceApart * 0.1;
            }

        }

        System.out.printf("Apartment: %.2f lv.%nStudio: %.2f lv.", totalPriceApart, totalPriceStudio);
    }
}
