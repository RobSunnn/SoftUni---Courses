package fundamentals.exams;

import java.util.Scanner;

public class Easter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        StringBuilder sb = new StringBuilder(text);

        String input = scanner.nextLine();

        while (!input.equals("Easter")) {
            String[] data = input.split("\\s+");
            String command = data[0];

            switch (command) {
                case "Replace":
                    String current = data[1];
                    String replacement = data[2];

                    if (sb.toString().contains(current) && !current.equals(replacement)) {
                        sb = new StringBuilder(sb.toString().replace(current, replacement));
                    }
                    System.out.println(sb.toString());

                    break;
                case "Remove":
                    String substring = data[1];
                    if (sb.toString().contains(substring)) {
                        sb = new StringBuilder(sb.toString().replace(substring, ""));
                    }
                    System.out.println(sb.toString());
                    break;
                case "Includes":
                    String string = data[1];
                    if (sb.toString().contains(string)) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "Change":
                    String lowerOrUpper = data[1];

                    if (lowerOrUpper.equals("Upper")) {
                        sb = new StringBuilder(sb.toString().toUpperCase());
                    } else if (lowerOrUpper.equals("Lower")) {
                        sb = new StringBuilder(sb.toString().toLowerCase());
                    }
                    System.out.println(sb.toString());
                    break;
                case "Reverse":
                    int startIndex = Integer.parseInt(data[1]);
                    int endIndex = Integer.parseInt(data[2]);

                    if (isIndexValid(startIndex, sb.toString()) && isIndexValid(endIndex, sb.toString())) {
                        String sub = sb.substring(startIndex, endIndex + 1);
                        StringBuilder builder = new StringBuilder(sub);
                        builder.reverse();
                        System.out.println(builder);
                    }

                        break;
            }

            input = scanner.nextLine();
        }


    }

    private static boolean isIndexValid(int index, String str) {
        return index >= 0 && index <= str.length() - 1;
    }
}
