package WorkingWithAbstraction.lab.StudentSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StudentSystem studentSystem = new StudentSystem();

        while (true) {

            String[] input = scanner.nextLine().split(" ");

            if (input[0].equals("Exit")) {
                break;
            }

            studentSystem.commandExecute(input);
        }
    }
}
