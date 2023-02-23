import java.util.Scanner;

public class zooMag {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double dog = Double.parseDouble(scanner.nextLine()) * 2.50;
        double cat = Double.parseDouble(scanner.nextLine()) * 4;

        double total = cat + dog;

        System.out.printf("%.1f lv.", total);
    }
}
