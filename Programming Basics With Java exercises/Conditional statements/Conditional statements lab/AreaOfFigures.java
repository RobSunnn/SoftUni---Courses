package ConditionalStatementsLab;

import java.util.Scanner;

public class AreaOfFigures {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String figure = scan.nextLine();

        if (figure.equals("square")) {

            double lenght = Double.parseDouble(scan.nextLine());
            double area = lenght * lenght;
            System.out.printf("%.3f", area);

        } else if (figure.equals("rectangle")) {

            double a = Double.parseDouble(scan.nextLine());
            double b = Double.parseDouble(scan.nextLine());
            double area = a * b;
            System.out.printf("%.3f", area);

        } else if (figure.equals("circle")) {

            double r = Double.parseDouble(scan.nextLine());
            double area = r * r * Math.PI;
            System.out.printf("%.3f", area);

        } else if (figure.equals("triangle")) {

            double a = Double.parseDouble(scan.nextLine());
            double b = Double.parseDouble(scan.nextLine());
            double area = a * b / 2;
            System.out.printf("%.3f", area);
        }
    }
}


//package ConditionalStatementsLab;

//        import java.util.Scanner;

//public class AreaOfFigures {
//    public static void main(String[] args) {
//       Scanner scan = new Scanner(System.in);
//      String figure = scan.nextLine();
//       switch (figure) {
//            case "square" -> {
//                double lenght = Double.parseDouble(scan.nextLine());
//                double area = lenght * lenght;
//                System.out.printf("%.3f", area);
//                break;
//            }
//            case "rectangle" -> {
//                double a = Double.parseDouble(scan.nextLine());
//                double b = Double.parseDouble(scan.nextLine());
//                double area = a * b;
//                System.out.printf("%.3f", area);
//                break;
//            }
//            case "circle" -> {
//                double r = Double.parseDouble(scan.nextLine());
//                double area = r * r * Math.PI;
//                System.out.printf("%.3f", area);
//                break;
//            }
//            case "triangle" -> {
//                double a = Double.parseDouble(scan.nextLine());
//                double b = Double.parseDouble(scan.nextLine());
//                double area = a * b / 2;
//                System.out.printf("%.3f", area);
//                break;
//            }
//        }
//    }
//}
