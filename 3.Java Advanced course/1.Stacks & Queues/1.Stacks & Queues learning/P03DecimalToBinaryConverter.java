package P01StacksAndQueues.lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P03DecimalToBinaryConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> binaryRepresentation = new ArrayDeque<>();

        if (number == 0) {

            System.out.println(0);

        }

        while (number != 0) {
            int result = number % 2;

            binaryRepresentation.push(result);

            number = number / 2;


        }

        for (int element : binaryRepresentation) {

            System.out.print(element);
        }
        //   System.out.println(binaryRepresentation.toString().replaceAll("[\\[\\], ]",""));
    }
}
