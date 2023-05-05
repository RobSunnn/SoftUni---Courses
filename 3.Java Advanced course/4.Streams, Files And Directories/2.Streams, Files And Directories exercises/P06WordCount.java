package P08Streams.FilesAndDirectories.exercise;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class P06WordCount {
    public static void main(String[] args) throws FileNotFoundException {
        String text = "C:\\Users\\DELL\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt";
        String textToRead = "C:\\Users\\DELL\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt";
        String output = "C:\\Users\\DELL\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\P06WordCount.txt";
        List<String> listOfWords = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();


        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(text));) {
            String[] currentLine = bufferedReader.readLine().split(" ");

            for (int i = 0; i < currentLine.length; i++) {
                listOfWords.add(currentLine[i]);
            }

        } catch (IOException e) {
            System.out.println("oops");
        }

        try (BufferedReader bf = new BufferedReader(new FileReader(textToRead))) {
            String[] line = bf.readLine().split(" ");

            for (int i = 0; i < line.length; i++) {
                String currentWord = line[i];

                if (listOfWords.contains(currentWord)) {
                    if (!map.containsKey(currentWord)) {
                        map.put(currentWord, 0);
                    }
                    map.put(currentWord, map.get(currentWord) + 1);

                }
            }


        } catch (IOException e) {
            System.out.println("ALele");
        }


        try (PrintWriter printWriter = new PrintWriter(output);) {
            map.entrySet().stream().sorted((e1, e2) -> e2.getValue()
                    .compareTo(e1.getValue())).forEach(entry -> printWriter.println(entry.getKey() + " - " + entry.getValue()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
