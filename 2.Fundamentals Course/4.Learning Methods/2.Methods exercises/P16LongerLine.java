package fundamentals.P10.Methods.exercise;

import java.util.Scanner;

public class P16LongerLine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] longerLine = new double[4];

        double x1 = Double.parseDouble(scanner.nextLine());
        double y1 = Double.parseDouble(scanner.nextLine());
        double x2 = Double.parseDouble(scanner.nextLine());
        double y2 = Double.parseDouble(scanner.nextLine());
        double x3 = Double.parseDouble(scanner.nextLine());
        double y3 = Double.parseDouble(scanner.nextLine());
        double x4 = Double.parseDouble(scanner.nextLine());
        double y4 = Double.parseDouble(scanner.nextLine());

        returnsTheLongerLineInCoordinateSystem(x1, y1, x2, y2, x3, y3, x4, y4, longerLine);

        System.out.printf("(%.0f, %.0f)(%.0f, %.0f)", longerLine[0], longerLine[1], longerLine[2], longerLine[3]);

    }

    public static void returnsTheLongerLineInCoordinateSystem(double n1, double m1, double n2, double m2, double n3
            , double m3, double n4, double m4, double[] arr) {

        double firstPoint = Math.sqrt(Math.pow(n2 - n1, 2) + Math.pow(m2 - m1, 2));
        double secondPoint = Math.sqrt(Math.pow(n4 - n3, 2) + Math.pow(m4 - m3, 2));

        if (firstPoint >= secondPoint) {
            double firstPointValue = Math.sqrt((n1 * n1) + (m1 * m1));
            double secondPointValue = Math.sqrt((n2 * n2) + (m2 * m2));


            if (firstPointValue > secondPointValue) {

                arr[0] = n2;
                arr[1] = m2;
                arr[2] = n1;
                arr[3] = m1;


            } else {

                arr[0] = n1;
                arr[1] = m1;
                arr[2] = n2;
                arr[3] = m2;
            }

        } else {
            double firstPointValue = Math.sqrt((n3 * n3) + (m3 * m3));
            double secondPointValue = Math.sqrt((n4 * n4) + (m4 * m4));


            if (firstPointValue > secondPointValue) {

                arr[0] = n4;
                arr[1] = m4;
                arr[2] = n3;
                arr[3] = m3;

            } else {

                arr[0] = n3;
                arr[1] = m3;
                arr[2] = n4;
                arr[3] = m4;
            }


        }

    }
}
