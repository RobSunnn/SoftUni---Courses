package P01StacksAndQueues.lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P08BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> browserHistory = new ArrayDeque<>();
        ArrayDeque<String> forwardHistory = new ArrayDeque<>();

        String input = scanner.nextLine();
        String currentPage = "";

        while (!input.equals("Home")) {

            if (input.equals("back")) {

                if (!browserHistory.isEmpty()) {
                    forwardHistory.push(currentPage);
                    currentPage = browserHistory.pop();

                } else {

                    System.out.println("no previous URLs");
                    input = scanner.nextLine();
                    continue;
                }
            } else if (input.equals("forward")) {
                if (!forwardHistory.isEmpty()) {
                    currentPage = forwardHistory.pop();

                } else {

                    System.out.println("no next URLs");
                    input = scanner.nextLine();
                    continue;
                }

            } else {

                if (!currentPage.equals("")) {

                    browserHistory.push(currentPage);
                }
                forwardHistory.clear();
                currentPage = input;
            }


            System.out.println(currentPage);
            input = scanner.nextLine();
        }
    }
}
