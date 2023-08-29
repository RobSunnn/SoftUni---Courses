package fundamentals.P05.dataTypesAndVariables.Exercise;

import java.util.Scanner;

public class P07WaterOverflow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        byte n = Byte.parseByte(scanner.nextLine());
        short capacityOfTank = 255;
        short totalLitres = 0;

        for (int i = 1; i <= n; i++) {
            short litres = Short.parseShort(scanner.nextLine());
            totalLitres += litres;

            if (totalLitres > capacityOfTank) {
                System.out.println("Insufficient capacity!");
                totalLitres -= litres;
            }

        }
        System.out.println(totalLitres);
    }
}
