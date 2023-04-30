package P07Streams.FilesAndDirectories.lab;

import java.io.*;
import java.util.Scanner;

public class P04ExtractIntegers {
    public static void main(String[] args) throws IOException {


        String path = "C:\\folder\\input.txt";
        String outputPath = "C:\\folder\\P04input.txt";
        Scanner scanner = new Scanner(new FileInputStream(path));
        PrintWriter out = new PrintWriter(new FileOutputStream(outputPath));


        while (scanner.hasNext()) {

            if (scanner.hasNextInt()) {
                out.println(scanner.nextInt());
            }
            scanner.next();
        }
        out.close();

    }
}
