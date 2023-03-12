package fundamentals.P07.Arrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class P07CondenseArrayToNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbersArr = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        //solution with while loop & for loop , in while loop we create a new int[] to keep the numbers while the length of the array is bigger than 1
        while (numbersArr.length != 1) {
            int[] condensed = new int[numbersArr.length - 1];

            for (int i = 0; i < numbersArr.length - 1; i++) {
                condensed[i] = numbersArr[i] + numbersArr[i + 1];
            }
            numbersArr = condensed;
        }
        //solution with two for loops
        // for (int i = 0; i < numbersArr.length - 1; i++) {
        //     for (int j = 0; j < numbersArr.length - 1; j++) {
        //         numbersArr[j] = numbersArr[j] + numbersArr[j+1];
        //     }
        // }

        System.out.println(numbersArr[0]);
    }
}
