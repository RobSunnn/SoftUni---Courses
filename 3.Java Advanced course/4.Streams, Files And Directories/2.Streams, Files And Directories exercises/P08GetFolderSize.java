package P08Streams.FilesAndDirectories.exercise;

import java.io.File;

public class P08GetFolderSize {
    public static void main(String[] args) {
        String file = "C:\\Users\\DELL\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";

        File folder = new File(file);

        File[] allFiles = folder.listFiles();

        int size = 0;
        for (File currentFile : allFiles) {

            size += currentFile.length();
        }
        System.out.println("Folder size: " + size);
    }
}
