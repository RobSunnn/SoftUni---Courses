package P08Streams.FilesAndDirectories.exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class P03AllCapitals {
    public static void main(String[] args) {

        String file = "C:\\Users\\DELL\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String output = "C:\\Users\\DELL\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\P03Output.txt";


        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
             PrintWriter printWriter = new PrintWriter(output)) {
            String currentLine = bufferedReader.readLine();

            while (currentLine != null) {

                printWriter.println(currentLine.toUpperCase());
                currentLine = bufferedReader.readLine();
            }

        } catch (IOException e) {

            e.printStackTrace();
        }

    }
}
