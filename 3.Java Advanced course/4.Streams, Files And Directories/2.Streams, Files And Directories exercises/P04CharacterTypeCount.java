package P08Streams.FilesAndDirectories.exercise;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class P04CharacterTypeCount {
    public static void main(String[] args) throws FileNotFoundException {

        String file = "C:\\Users\\DELL\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String output = "C:\\Users\\DELL\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\P04Output.txt";

        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("Vowels", 0);
        map.put("Other symbols", 0);
        map.put("Punctuation", 0);

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            int oneByte = bufferedReader.read();

            while (oneByte != -1) {
                if (oneByte == ' ' || oneByte == 10 || oneByte == 13) {
                    oneByte = bufferedReader.read();
                    continue;
                }

                if (oneByte == 'a' || oneByte == 'e' || oneByte == 'o'
                        || oneByte == 'u' || oneByte == 'i' ) {

                    map.put("Vowels", map.get("Vowels") + 1);

                } else if (oneByte == ',' || oneByte == '.' || oneByte == '!' || oneByte == '?') {

                    map.put("Punctuation", map.get("Punctuation") + 1);

                } else {

                    map.put("Other symbols", map.get("Other symbols") + 1);
                }
                oneByte = bufferedReader.read();
            }
        } catch (IOException e) {

            e.printStackTrace();
        }
        try(PrintWriter printWriter = new PrintWriter(output);) {
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                printWriter.printf("%s: %d%n", entry.getKey(), entry.getValue());

            }
        }catch (IOException e) {
            e.printStackTrace();
        }



    }
}
