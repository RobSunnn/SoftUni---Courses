package fundamentals.exams;

import java.util.Scanner;

public class PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        StringBuilder oldPassword = new StringBuilder(text);
        StringBuilder newPassword = new StringBuilder();
        String input = scanner.nextLine();

        while (!input.equals("Done")) {
            String command = input.split(" ")[0];
            if (command.equals("TakeOdd")) {

                for (int i = 1; i < oldPassword.length(); i += 2) {
                    newPassword.append(oldPassword.charAt(i));
                }
                oldPassword = newPassword;

                System.out.println(oldPassword);
            } else if (command.equals("Cut")) {
                int index = Integer.parseInt(input.split(" ")[1]);
                int length = Integer.parseInt(input.split(" ")[2]);
                oldPassword.delete(index, (index + length));
                System.out.println(oldPassword);

            } else if (command.equals("Substitute")) {
                String substring = input.split(" ")[1];
                String substitute = input.split(" ")[2];

                if (!oldPassword.toString().contains(substring) && !substring.equals(substitute)) {
                    System.out.println("Nothing to replace!");
                    input = scanner.nextLine();
                    continue;
                } else {
                    oldPassword = new StringBuilder(oldPassword.toString().replace(substring, substitute));
                }
                System.out.println(oldPassword);
            }


            input = scanner.nextLine();
        }
        System.out.println("Your password is: " + oldPassword);
    }
}
//package fundamentals.exams;              РАЗЛИЧНО РЕШЕНИЕ И ПО ДОБРО !!!
//
//import java.util.*;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//import java.util.stream.Collectors;
//
//public class exercise {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        String text = scanner.nextLine();
//        StringBuilder textBuilder = new StringBuilder(text);
//
//        String input = scanner.nextLine();
//
//        while (!input.equals("Done")) {
//
//            String[] tokens = input.split(" ");
//            String command = tokens[0];
//
//            switch (command) {
//
//                case "TakeOdd":
//
//                    for (int i = 0; i < textBuilder.length(); i+=2) {
//
//                        textBuilder.deleteCharAt(i);
//                        i--;
//
//                    }
//                    System.out.println(textBuilder);
//
//                    break;
//                case "Cut":
//                    int index = Integer.parseInt(tokens[1]);
//                    int length = Integer.parseInt(tokens[2]);
//
//                    textBuilder = new StringBuilder(textBuilder.delete(index, index + length));
//
//                    System.out.println(textBuilder);
//
//                    break;
//                case "Substitute":
//                    String substring = tokens[1];
//                    String substitute = tokens[2];
//
//                    if (textBuilder.toString().contains(substring) && !substring.equals(substitute)) {
//
//                        textBuilder = new StringBuilder(textBuilder.toString().replace(substring, substitute));
//
//                        System.out.println(textBuilder);
//
//                    } else {
//
//                        System.out.println("Nothing to replace!");
//                    }
//                    break;
//
//
//            }
//
//            input = scanner.nextLine();
//        }
//        System.out.println("Your password is: " + textBuilder);
//
//    }
//
//
//}