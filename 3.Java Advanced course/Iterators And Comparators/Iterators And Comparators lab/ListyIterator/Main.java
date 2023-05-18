package P14IteratorsAndComparators.exercises.P01ListyIterator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListyIterator listyIterator = null;
        String input = scanner.nextLine();

        while (!input.equals("END")) {
            String[] data = input.split(" ");
            String command = data[0];

            switch (command) {

                case "Create":
                    if (data.length == 1) {
                        listyIterator = new ListyIterator();
                    } else {
                        String[] strings = new String[data.length - 1];
                        for (int i = 1; i < data.length; i++) {
                            strings[i - 1] = data[i];
                        }
                        listyIterator = new ListyIterator(strings);
                    }
                    break;
                case "Move":
                    System.out.println(listyIterator.move());
                    break;
                case "HasNext":
                    System.out.println(listyIterator.hasNext());
                    break;
                case "Print":
                    try {
                        System.out.println(listyIterator.print());

                    }catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case "PrintAll":
                    try {
                        listyIterator.printAll();
                    }catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }

            input = scanner.nextLine();
        }

    }
}
