package MoreExercise.Text.Processing;

import java.util.Scanner;

public class P04MorseCode {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] inputLine = input.split(" ");

        for (int i = 0; i < inputLine.length; i++) {
            String element = inputLine[i];
            if (element.equals(".-")) {
                inputLine[i] = ("A");
            } else if (element.equals("-...")) {
                inputLine[i] = ("B");
            } else if (element.equals("-.-.")) {
                inputLine[i] = ("C");
            } else if (element.equals("-..")) {
                inputLine[i] = ("D");
            } else if (element.equals(".")) {
                inputLine[i] = ("E");
            } else if (element.equals("..-.")) {
                inputLine[i] = ("F");
            } else if (element.equals("--.")) {
                inputLine[i] = ("G");
            } else if (element.equals("....")) {
                inputLine[i] = ("H");
            } else if (element.equals("..")) {
                inputLine[i] = ("I");
            } else if (element.equals(".---")) {
                inputLine[i] = ("J");
            } else if (element.equals("-.-")) {
                inputLine[i] = ("K");
            } else if (element.equals(".-..")) {
                inputLine[i] = ("L");
            } else if (element.equals("--")) {
                inputLine[i] = ("M");
            } else if (element.equals("-.")) {
                inputLine[i] = ("N");
            } else if (element.equals("---")) {
                inputLine[i] = ("O");
            } else if (element.equals(".--.")) {
                inputLine[i] = ("P");
            } else if (element.equals("--.-")) {
                inputLine[i] = ("Q");
            } else if (element.equals(".-.")) {
                inputLine[i] = ("R");
            } else if (element.equals("...")) {
                inputLine[i] = ("S");
            } else if (element.equals("-")) {
                inputLine[i] = ("T");
            } else if (element.equals("..-")) {
                inputLine[i] = ("U");
            } else if (element.equals("...-")) {
                inputLine[i] = ("V");
            } else if (element.equals(".--")) {
                inputLine[i] = ("W");
            } else if (element.equals("-..-")) {
                inputLine[i] = ("X");
            } else if (element.equals("-.--")) {
                inputLine[i] = ("Y");
            } else if (element.equals("--..")) {
                inputLine[i] = ("Z");
            }

        }

        for (String element : inputLine) {
            System.out.print(element.replaceAll("\\|", " ") + "");
        }

    }
}
