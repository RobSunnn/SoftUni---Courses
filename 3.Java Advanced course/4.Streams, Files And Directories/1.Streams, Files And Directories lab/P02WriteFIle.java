package P07Streams.FilesAndDirectories.lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P02WriteFIle {
    public static void main(String[] args) {
        String path = "C:\\folder\\input.txt";
        String outputPath = "C:\\folder\\P02input.txt";
        List<Character> symbols = new ArrayList<>();
        Collections.addAll(symbols, ',', '.', '!', '?');

        try (FileInputStream input = new FileInputStream(path);
             FileOutputStream outputStream = new FileOutputStream(outputPath)) {

            int oneByte = input.read();
            while (oneByte >= 0) {

                if (!symbols.contains((char) oneByte)) {
                    outputStream.write(oneByte);
                }
                oneByte = input.read();
            }

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}
