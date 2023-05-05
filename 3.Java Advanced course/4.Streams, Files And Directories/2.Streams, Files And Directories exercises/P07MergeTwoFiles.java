package P08Streams.FilesAndDirectories.exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class P07MergeTwoFiles {
    public static void main(String[] args) {
        String firstFile = "C:\\Users\\DELL\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt";
        String secondFile = "C:\\Users\\DELL\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt";
        String output = "C:\\Users\\DELL\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\P07MergeTwoFiles.txt";
        List<String> list = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(firstFile))) {
            String current = bufferedReader.readLine();
            while (current != null) {
                list.add(current);
                current = bufferedReader.readLine();
            }


        } catch (IOException e) {

            System.out.println("WOW");
        }
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(secondFile))) {
            String current = bufferedReader.readLine();
            while (current != null) {
                list.add(current);
                current = bufferedReader.readLine();
            }

        } catch (IOException e) {
            System.out.println("WOW");
        }

        try (PrintWriter printWriter = new PrintWriter(output);) {
            for (int i = 0; i < list.size(); i++) {
                printWriter.println(list.get(i));
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
