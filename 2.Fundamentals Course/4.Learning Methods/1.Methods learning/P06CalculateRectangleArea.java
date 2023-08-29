package fundamentals.P09.Methods.lab;

import java.util.Scanner;

public class P06CalculateRectangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double widthInput = Double.parseDouble(scanner.nextLine());
        double heightInput = Double.parseDouble(scanner.nextLine());
        double area = getRectangleArea(widthInput, heightInput);

        System.out.printf("%.0f", area);


    }

    public static double getRectangleArea(double width, double height) {
        return width * height;
    }
}
