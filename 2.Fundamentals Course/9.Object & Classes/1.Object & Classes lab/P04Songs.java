package fundamentals.P18.ObjectsAndClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P04Songs {
    public static class Song {
        String typeList;
        String name;
        String time;

        public void setTypeList(String typeList) {
            this.typeList = typeList;
        }

        public String getTypeList() {
            return typeList;
        }


        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setTime(String time) {
            this.time = time;
        }


    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Song> songList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] inputArr = scanner.nextLine().split("_");
            String typeList = inputArr[0];
            String songName = inputArr[1];
            String songTime = inputArr[2];

            Song currentSong = new Song();
            currentSong.setTypeList(typeList);
            currentSong.setName(songName);
            currentSong.setTime(songTime);
            songList.add(currentSong);
        }
        String typeList = scanner.nextLine();

        if (typeList.equals("all")) {
            for (Song element : songList) {
                System.out.println(element.getName());
            }
        } else {

            for (Song element : songList) {
                if (typeList.equals(element.getTypeList())) {
                    System.out.println(element.getName());
                }
            }
        }
    }
}
