package fundamentals.P19.ObjectsAndClasses.Exercise;

import java.util.Scanner;

public class P02Articles {
    public static class Article {
        private String title;
        private String content;
        private String author;


        public Article(String title, String content, String author) {
            this.title = title;
            this.content = content;
            this.author = author;

        }

        public void edit(String newContent) {
            this.content = newContent;
        }

        public void changeAuthor(String newAuthor) {
            this.author = newAuthor;
        }

        public void rename(String newTitle) {
            this.title = newTitle;
        }

        @Override
        public String toString() {
            return String.format("%s - %s: %s", title, content, author);
        }


    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] text = scanner.nextLine().split(", ");
        String title = text[0];
        String content = text[1];
        String author = text[2];
        Article article = new Article(title, content, author);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            String[] inputArr = scanner.nextLine().split("\\: ");
            String command = inputArr[0];

            switch (command) {
                case "Edit":
                    String newContent = inputArr[1];
                    article.edit(newContent);
                    break;
                case "ChangeAuthor":
                    String newAuthor = inputArr[1];
                    article.changeAuthor(newAuthor);
                    break;
                case "Rename":
                    String newTitle = inputArr[1];
                    article.rename(newTitle);
                    break;
            }

        }
        System.out.println(article.toString());


    }
}
