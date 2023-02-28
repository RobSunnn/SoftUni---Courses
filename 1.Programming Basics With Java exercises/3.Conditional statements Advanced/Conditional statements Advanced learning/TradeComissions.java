package ConditionalStatementAdvancedLab;

import java.util.Scanner;

public class TradeComissions {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String town = scan.nextLine();
        double sales = Double.parseDouble(scan.nextLine());
        double commision = 0.0;

        if (sales >= 0 && sales <= 500) {

            switch (town) {

                case "Sofia":
                    commision = sales * 0.05;

                    break;
                case "Varna":
                    commision = sales * 0.045;

                    break;
                case "Plovdiv":
                    commision = sales * 0.055;

                    break;
                default:
                    System.out.println("error");

                    break;
            }

        } else if (sales > 500 && sales <= 1000) {
            switch (town) {

                case "Sofia":
                    commision = sales * 0.07;

                    break;
                case "Varna":
                    commision = sales * 0.075;

                    break;
                case "Plovdiv":
                    commision = sales * 0.08;

                    break;
                default:
                    System.out.println("error");
                    break;
            }
        } else if (sales > 1000 && sales <= 10000) {
            switch (town) {
                case "Sofia":
                    commision = sales * 0.08;

                    break;
                case "Varna":
                    commision = sales * 0.1;

                    break;
                case "Plovdiv":
                    commision = sales * 0.12;

                    break;
                default:
                    System.out.println("error");
                    break;
            }

        } else if (sales > 10000) {
            switch (town) {
                case "Sofia":
                    commision = sales * 0.12;

                    break;
                case "Varna":
                    commision = sales * 0.13;

                    break;
                case "Plovdiv":
                    commision = sales * 0.145;

                    break;
                default:
                    System.out.println("error");
                    break;

            }
        } else {
            System.out.println("error");
        }
        if (commision != 0) {
            System.out.printf("%.2f", commision);
        }

    }
}
