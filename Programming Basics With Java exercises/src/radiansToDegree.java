import java.util.Scanner;

public class radiansToDegree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double radians = Double.parseDouble(scanner.nextLine());

        double degree = radians * 180 / Math.PI;

        System.out.println(degree);
    }
}
