package fundamentals.P06.dataTypesAndVariables.MoreExercise;


import java.util.Scanner;

public class P03FloatingEquality {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double n1 = Double.parseDouble(scanner.nextLine());
        double n2 = Double.parseDouble(scanner.nextLine());

        if (n1 - n2 >= 0.000001 || n2 - n1 >= 0.000001) {
            System.out.println("False");
        } else {
            System.out.println("True");
        }
    }
}
