package fundamentals.P09.Methods.lab;

import java.util.Scanner;

public class P07RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String stringToRepeatInput = scanner.nextLine();
        int countInput = Integer.parseInt(scanner.nextLine());
        System.out.println(stringToRepeatMethod(stringToRepeatInput, countInput));


    }

    public static String stringToRepeatMethod(String stringToRepeat, int count) {
        String startingStringToRepeat = "";
        for (int i = 0; i < count; i++) {
            startingStringToRepeat += stringToRepeat;
        }
        return startingStringToRepeat;
    }
}
