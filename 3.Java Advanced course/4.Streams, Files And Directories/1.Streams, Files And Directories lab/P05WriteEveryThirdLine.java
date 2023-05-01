package P07Streams.FilesAndDirectories.lab;

import java.io.*;

public class P05WriteEveryThirdLine {
    public static void main(String[] args) {
        String path = "C:\\folder\\input.txt";
        String outputPath = "C:\\folder\\P05input.txt";

        try (BufferedReader in = new BufferedReader(new FileReader(path));
             PrintWriter out = new PrintWriter(new FileWriter(outputPath))) {
            int counter = 1;

            String line = in.readLine();
            while (line != null) {
                if (counter % 3 == 0) {
                    out.println(line);
                }
                counter++;
                line = in.readLine();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
