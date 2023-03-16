package fundamentals.P10.Methods.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P15CenterPoint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int x1 = Integer.parseInt(scanner.nextLine());
        int y1 = Integer.parseInt(scanner.nextLine());
        int x2 = Integer.parseInt(scanner.nextLine());
        int y2 = Integer.parseInt(scanner.nextLine());

        System.out.println(Arrays.toString(returnsClosestPointOfCoordinateSystem(x1, y1, x2, y2))
                .replace("[", "(").replace("]", ")"));

    }

    public static int[] returnsClosestPointOfCoordinateSystem(int first, int second, int third, int fourth) {
        int firstPoint = first + second;
        int secondPoint = third + fourth;
        int[] closestPoint = new int[2];

        if (firstPoint < secondPoint) {
            closestPoint[0] = first;
            closestPoint[1] = second;

        } else if (firstPoint > secondPoint) {

            closestPoint[0] = third;
            closestPoint[1] = fourth;
        } else {

            closestPoint[0] = first;
            closestPoint[1] = second;
        }

        return closestPoint;
    }
}
