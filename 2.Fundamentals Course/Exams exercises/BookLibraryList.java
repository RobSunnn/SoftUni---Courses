package fundamentals.exams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BookLibraryList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> booksOnShelf = Arrays.stream(scanner.nextLine().split("&")).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("Done")) {
            String command = input.split(" \\| ")[0];

            switch (command) {
                case "Add Book":
                    String bookToAdd = input.split("\\|")[1].trim();
                    if (!booksOnShelf.contains(bookToAdd)) {
                        booksOnShelf.add(0, bookToAdd);
                    }
                    break;
                case "Take Book":
                    String bookToTake = input.split("\\|")[1].trim();
                    booksOnShelf.remove(bookToTake);
                    break;
                case "Swap Books":
                    String firstBookToSwap = input.split("\\|")[1].trim();
                    String secondBookToSwap = input.split("\\|")[2].trim();
                    if (booksOnShelf.contains(firstBookToSwap) && booksOnShelf.contains(secondBookToSwap)) {
                        int indexFirstBook = booksOnShelf.indexOf(firstBookToSwap);
                        int indexSecondBook = booksOnShelf.indexOf(secondBookToSwap);
                        booksOnShelf.set(indexFirstBook, secondBookToSwap);
                        booksOnShelf.set(indexSecondBook, firstBookToSwap);
                    }
                    break;
                case "Insert Book":
                    String bookToInsert = input.split("\\|")[1].trim();
                    if (!booksOnShelf.contains(bookToInsert)) {
                        booksOnShelf.add(bookToInsert);
                    }

                    break;
                case "Check Book":
                    int index = Integer.parseInt(input.split("\\|")[1].trim());
                    if (index >= 0 && index <= booksOnShelf.size() - 1) {
                        System.out.println(booksOnShelf.get(index));
                    }

                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println(String.join(", ", booksOnShelf));
    }
}
