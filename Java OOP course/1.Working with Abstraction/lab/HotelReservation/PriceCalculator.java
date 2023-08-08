package Abstraction.lab.HotelReservation;

public class PriceCalculator {

    public static double calculatePrice(double pricePerDay,
                                        int numberOfDays,
                                        Season season,
                                        Discount discount) {

        int multiplier = season.getValue();
        double discountMultiplier = discount.getValue() * 1.0 / 100;
        double priceBeforeDiscount = numberOfDays * pricePerDay * multiplier;
        double discountedAmount = priceBeforeDiscount * discountMultiplier;

        return priceBeforeDiscount - discountedAmount;

    }
}
