package P08Streams.FilesAndDirectories.exercise;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class P01SumLines {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\DELL\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        String currentLine = bufferedReader.readLine();

        while (currentLine != null) {

            long sum = 0;
            for (char current : currentLine.toCharArray()) {
                sum += current;
            }
            System.out.println(sum);
            currentLine = bufferedReader.readLine();
        }


        System.out.println();
    }
}
