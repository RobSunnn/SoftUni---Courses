package ConditionalStatementAdvancedLab;

import java.util.Scanner;

public class PersonalTitles {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        double age = Double.parseDouble(scan.nextLine());
        String gender = scan.nextLine();

        if ("m".equals(gender)) {

            if (age >= 16) {
                System.out.println("Mr.");

            } else {

                System.out.println("Master");
            }

        }
        if ("f".equals(gender)) {

            if (age >= 16) {
                System.out.println("Ms.");
            } else {
                System.out.println("Miss");
            }
        }
    }
}
