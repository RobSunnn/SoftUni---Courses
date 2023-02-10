package ConditionalStatementsLab;

import java.util.Scanner;

public class Numbers100to200 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());
        if (number < 100) {
            System.out.println("Less than 100");

        } else if (number >= 100)

            if (number <= 200) {
                System.out.println("Between 100 and 200");
            } else
                System.out.println("Greater than 200");

    }
}
