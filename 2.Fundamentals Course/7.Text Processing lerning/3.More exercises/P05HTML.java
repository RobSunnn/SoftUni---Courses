package MoreExercise.Text.Processing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P05HTML {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String title = scanner.nextLine();
        String content = scanner.nextLine();

        List<String> commentsList = new ArrayList<>();

        String input = scanner.nextLine();

        while (!input.equals("end of comments")) {

            commentsList.add(input);

            input = scanner.nextLine();
        }

        System.out.println("<h1>");
        System.out.printf("    %s%n", title);
        System.out.println("</h1>");
        System.out.println("<article>");
        System.out.printf("    %s%n", content);
        System.out.println("</article>");
        for (String element : commentsList) {
            System.out.println("<div>");
            System.out.printf("    %s%n", element);
            System.out.println("</div>");

        }
    }
}
