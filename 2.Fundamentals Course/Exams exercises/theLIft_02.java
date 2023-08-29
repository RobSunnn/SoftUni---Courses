package fundamentals.exams;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class theLIft_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int peopleWaitingForTheLift = Integer.parseInt(scanner.nextLine());
        int[] currentStateOfTheLift = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < currentStateOfTheLift.length; i++) {
            if ((currentStateOfTheLift[i] < 4)) {
                if (peopleWaitingForTheLift >= 4 - currentStateOfTheLift[i]) {
                    peopleWaitingForTheLift -= 4 - currentStateOfTheLift[i];
                    currentStateOfTheLift[i] = 4;
                } else {
                    currentStateOfTheLift[i] += peopleWaitingForTheLift;
                    peopleWaitingForTheLift = 0;
                }
            }
        }
        boolean isFull = true;
        for (int i = 0; i < currentStateOfTheLift.length; i++) {
            if (currentStateOfTheLift[i] < 4) {
                isFull = false;
                break;
            }
        }
        if (isFull && peopleWaitingForTheLift > 0) {
            System.out.printf("There isn't enough space! %d people in a queue!%n", peopleWaitingForTheLift);
        } else if (!isFull && peopleWaitingForTheLift == 0) {
            System.out.println("The lift has empty spots!");
        }

        for (int element : currentStateOfTheLift) {
            System.out.print(element + " ");
        }


    }
}
