package fundamentals.P09.Methods.lab;

import java.text.DecimalFormat;
import java.util.Scanner;

public class P08MathPower {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double numInput = Double.parseDouble(scanner.nextLine());
        double powInput = Double.parseDouble(scanner.nextLine());

        DecimalFormat df = new DecimalFormat("0.####");

        System.out.println(df.format(powOfNum(numInput, powInput)));

    }

    public static Double powOfNum(double num, double pow) {
        double result = 1;
        for (int i = 1; i <= pow; i++) {
            result = result * num;
        }
        return result;
    }
}
