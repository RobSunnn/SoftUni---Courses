package fundamentals.P05.dataTypesAndVariables.Exercise;

import java.util.Scanner;

public class P05PrintPartOfTheASCITable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int start = Integer.parseInt(scanner.nextLine());
        int finish = Integer.parseInt(scanner.nextLine());

        for (int i = start; i <= finish; i++) {
            System.out.print((char) i + " ");
        }
    }
}
