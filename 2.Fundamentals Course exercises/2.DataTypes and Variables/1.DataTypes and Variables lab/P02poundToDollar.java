package fundamentals.P04.dataTypesAndVariables.lab;

import java.math.BigDecimal;
import java.util.Scanner;

public class P02poundToDollar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double pound = Double.parseDouble(scanner.nextLine());

        BigDecimal dollar = BigDecimal.valueOf(pound * 1.36);

        System.out.printf("%.3f", dollar);

    }
}
