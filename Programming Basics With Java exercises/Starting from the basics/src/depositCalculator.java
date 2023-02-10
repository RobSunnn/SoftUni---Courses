import java.util.Scanner;

public class depositCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double depositSum = Double.parseDouble(scanner.nextLine());
        int depositTime = Integer.parseInt(scanner.nextLine());
        double apy = Double.parseDouble(scanner.nextLine());

        double interest = depositSum * apy / 100;
        double interestForMonth = interest / 12;

        double totalSum = depositSum + depositTime * interestForMonth;

        System.out.println(totalSum);
    }
}
