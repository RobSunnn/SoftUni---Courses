package fundamentals.P05.dataTypesAndVariables.Exercise;

import java.util.Scanner;

public class P01IntegerOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());
        int thirdNumber = Integer.parseInt(scanner.nextLine());
        int fourthNumber = Integer.parseInt(scanner.nextLine());

        int result = ((firstNumber + secondNumber) / thirdNumber) * fourthNumber;
        System.out.println(result);
    }
}
