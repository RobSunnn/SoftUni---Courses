package fundamentals.P15.TextProcessing.exercise;

import java.util.Scanner;

public class P03ExtractFiles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] destination = input.split("\\\\");
        String[] files = destination[destination.length - 1].split("\\.");
        String fileName = files[0];
        String extension = files[1];

        System.out.printf("File name: %s%nFile extension: %s", fileName, extension);
    }
}
