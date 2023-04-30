package P07Streams.FilesAndDirectories.lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class P03CopyBytes {
    public static void main(String[] args) {
        String path = "C:\\folder\\input.txt";
        String outputPath = "C:\\folder\\P03input.txt";

        try (FileInputStream input = new FileInputStream(path);
             FileOutputStream out = new FileOutputStream(outputPath)) {

            int oneByte = input.read();

            while (oneByte >= 0) {
                String numbs = String.valueOf(oneByte);
                if (oneByte != 10 && oneByte != 32) {
                    for (int i = 0; i < numbs.length(); i++) {
                        out.write(numbs.charAt(i));
                    }

                } else {
                    out.write(oneByte);
                }

                oneByte = input.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
