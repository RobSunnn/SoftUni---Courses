package P07Streams.FilesAndDirectories.lab;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class P07ListFiles {
    public static void main(String[] args) {

        File file = new File("C:\\folder\\Files-and-Streams");

        if (file.isDirectory()) {

            File[] files = file.listFiles();

            for (File f : files) {
                if (!f.isDirectory()) {
                    System.out.printf("%s: [%s]%n", f.getName(), f.length());
                }
            }
        }
    }
}
