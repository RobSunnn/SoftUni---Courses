package fundamentals.P15.TextProcessing.exercise;


import java.util.Scanner;

public class P07StringExplosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        StringBuilder textBuilder = new StringBuilder(text);
        int power = 0;

        for (int i = 0; i < textBuilder.length(); i++) {
            char currentCharacter = textBuilder.charAt(i);

            if (currentCharacter == '>') {

                power += textBuilder.charAt(i + 1) - 48;
            }
            if (currentCharacter != '>' && power != 0) {
                textBuilder.deleteCharAt(i);
                power--;
                i--;
            }

        }
        System.out.println(textBuilder);
    }
}
