package P08Streams.FilesAndDirectories.exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class P02SumBytes {
    public static void main(String[] args) {

        String fileText = "C:\\Users\\DELL\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        long sum = 0L;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileText));) {
            int oneByte = bufferedReader.read();
            while (oneByte != -1) {
                if (oneByte != 10 && oneByte != 13) {
                    sum += oneByte;
                }
                oneByte = bufferedReader.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(sum);
    }
}
