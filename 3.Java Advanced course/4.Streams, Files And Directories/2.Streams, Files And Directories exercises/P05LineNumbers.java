package P08Streams.FilesAndDirectories.exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class P05LineNumbers {
    public static void main(String[] args) {
        String file = "C:\\Users\\DELL\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";
        String output = "C:\\Users\\DELL\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\P05LineNumbers.txt";

        List<String> list = new ArrayList<>();
        int line = 1;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String currentLine = bufferedReader.readLine();

            while (currentLine != null) {
                list.add(line + ". " + currentLine);
                line++;
                currentLine = bufferedReader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (PrintWriter printWriter = new PrintWriter(output)) {

            for (String s : list) {

                if (s != null) {
                    printWriter.println(s);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
