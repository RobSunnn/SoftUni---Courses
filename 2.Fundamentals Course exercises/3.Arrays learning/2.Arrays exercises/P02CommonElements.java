package fundamentals.P08.Arrays.exercise;

import java.util.Scanner;

public class P02CommonElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstArr = scanner.nextLine().split(" ");
        String[] secondArr = scanner.nextLine().split(" ");

        if (secondArr.length >= firstArr.length) {

            for (int i = 0; i < secondArr.length; i++) {

                for (int j = 0; j < firstArr.length; j++) {
                    if (firstArr[j].equals(secondArr[i])) {
                        System.out.print(secondArr[i] + " ");
                    }
                }

            }
        } else {

            for (int i = 0; i < secondArr.length; i++) {

                for (int j = 0; j < firstArr.length; j++) {
                    if (firstArr[j].equals(secondArr[i])) {
                        System.out.print(secondArr[i] + " ");
                    }
                }

            }
        }
    }
}

