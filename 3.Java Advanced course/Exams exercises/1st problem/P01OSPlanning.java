package Exams;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P01OSPlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tasksArr = scanner.nextLine().split(", ");
        String[] threadsArr = scanner.nextLine().split(" ");
        int killer = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> tasks = new ArrayDeque<>();
        ArrayDeque<Integer> threads = new ArrayDeque<>();

        for (String s : tasksArr) {

            tasks.push(Integer.parseInt(s));

        }
        for (String s : threadsArr) {

            threads.offer(Integer.parseInt(s));
        }
        boolean isFound = false;
        int threadToPrint = 0;

        while (true) {

            int task = tasks.pop();
            int thread = threads.poll();

            if (task == killer) {
                threadToPrint = thread;
                threads.addFirst(thread);
                isFound = true;
            }

            if (thread < task) {
                tasks.push(task);

            }

            if (isFound) {
                break;
            }
        }

        System.out.printf("Thread with value %d killed task %d%n", threadToPrint, killer);

        while (threads.size() > 0) {

            System.out.print(threads.poll() + " ");
        }
    }
}
