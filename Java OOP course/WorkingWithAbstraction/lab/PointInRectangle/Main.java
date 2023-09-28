package WorkingWithAbstraction.lab.PointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] coordinates = Arrays.stream(scanner.nextLine()
                .split(" ")).mapToInt(i -> Integer.parseInt(i)).toArray();
        int n = Integer.parseInt(scanner.nextLine());

        Point firstPoint = new Point(coordinates[0], coordinates[1]);
        Point secondPoint = new Point(coordinates[2], coordinates[3]);

        Rectangle rectangle = new Rectangle(firstPoint, secondPoint);

        for (int i = 1; i <= n; i++) {
            String[] input = scanner.nextLine().split(" ");
            Point point = new Point(Integer.parseInt(input[0]), Integer.parseInt(input[1]));

            System.out.println(rectangle.contains(point));

        }

    }
}
